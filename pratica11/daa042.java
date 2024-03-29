// Exemplo de implementaÃ§Ã£o de algoritmo de Edmonds-Karp
// usando lista de adjacencias + matriz de capacidades
// (implementacao com vector)

import java.util.*;

class daa042 {

// Classe para no da fila do BFS: pares (no, capacidade)
static class NodeQ {
        public int node;
        public int flow;

        NodeQ(int n, int f) {
        node = n;
        flow = f;
        }
    }

// Classe que representa um grafo
static class Graph {
    int n;                       // Numero de nos do grafo
    Vector<Vector<Integer>> adj; // Lista de adjacencias
    int[][] cap;                 // Matriz de capacidades

    Graph(int n) {
	this.n = n;
	adj = new Vector<>();
	for (int i=0; i<=n; i++) adj.add(new Vector<>());
	cap = new int[n+1][n+1]; // +1 se os nós comecam em 1 ao inves de 0
    }

    void addLink(int a, int b, int c) {
	// adjacencias do grafo nao dirigido, porque podemos ter de andar no sentido
	// contrário ao procurarmos caminhos de aumento
	adj.get(a).add(b);
	adj.get(b).add(a);
	cap[a][b] = c;
    }

    // BFS para encontrar caminho de aumento
    // devolve valor do fluxo nesse caminho
    int bfs(int s, int t, int[] parent) {
	for (int i=0; i<=n; i++) parent[i] = -1;

	parent[s] = -2;
	Queue<NodeQ> q = new LinkedList<>(); // fila do BFS
	// inicializar com na origem e grande capacidade
	q.add(new NodeQ(s, Integer.MAX_VALUE));

	while (!q.isEmpty()) {
	    // returar primeiro no da fila
	    int cur = q.peek().node;
	    int flow = q.peek().flow;
	    q.poll();

	    // percorrer nos adjacentes ao no atual (cur)
	    for (int next : adj.get(cur)) {
		// se o vizinho ainda nao foi visitado (parent==-1)
		// e a aresta respetiva ainda tem capacidade para passar fluxo
		if (parent[next] == -1 && cap[cur][next]>0) {
		    parent[next] = cur;                        // atualizar pai
		    int new_flow = Math.min(flow, cap[cur][next]); // atualizar fluxo
		    if (next == t) return new_flow;            // chegamos ao final?
		    q.add(new NodeQ(next, new_flow));          // adicionar a fila
		}
	    }
	}

	return 0;
    }

    // Algoritmo de Edmonds-Karp para fluxo maximo entre s e t
    // devolve valor do fluxo maximo (cap[][] fica com grafo residual)
    int maxFlow(int s, int t) {
	int flow = 0;                // fluxo a calcular
	int[] parent = new int[n+1]; // array de pais (permite reconstruir caminho)
	while (true) {

	    int new_flow = bfs(s, t, parent); // fluxo de um caminho de aumento
	    if (new_flow == 0) break;         // se nao existir, terminar

      flow++;
	    // imprimir fluxo e caminho de aumento
	    //System.out.print("Caminho de aumento: fluxo " + new_flow + " | " + t);

	    //flow += new_flow;  // aumentar fluxo total com fluxo deste caminho
	    int cur = t;
	    while (cur != s) { // percorrer caminho de aumento e alterar arestas
		int prev = parent[cur];
		cap[prev][cur] -= 1;
		cap[cur][prev] += 1;
		cur = prev;
		//System.out.print(" <- " + cur); // imprimir proximo no do caminho
	    }
	   // System.out.println();
	}

	return flow;
    }
}



    public static void main(String[] args) {
	   Scanner in = new Scanner(System.in);
     int many = in.nextInt();
     for(int i = 0; i < many; i++){
       int pessoas = in.nextInt();
       int interesse = in.nextInt();
       int nos = pessoas*2 ;
       Graph g = new Graph(nos+2);
       for(int j = 0; j < pessoas; j++){
         g.addLink(nos+1, j, 1);
       }
       for(int j = pessoas; j < pessoas*2; j++){
         g.addLink(j, nos+2, 1);
       }
       for(int j = 0; j < interesse; j++){
         int a = in.nextInt();
         int b = in.nextInt() + pessoas;
         g.addLink(a, b, 1);
       }
       int flow = g.maxFlow(nos+1, nos+2);
       if(flow == pessoas){
         System.out.println("YES");
       }
       else{
         System.out.println("NO");
       }
     }
  }
}
