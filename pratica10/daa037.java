import java.util.LinkedList;
import java.util.Scanner;
import java.util.TreeSet;
// Classe que representa uma aresta

public class daa037 {

static class Edge {
    int to;     // No destino
    double weight; // Peso da aresta

    Edge(int t, double w) {
	to = t;
	weight = w;
    }
}

// Classe que representa um no
static class Node {
    public LinkedList<Edge> adj; // Lista de adjacencias
    public boolean visited;      // No ja foi visitado?
    public double distance;         // Distancia ao no origem da pesquisa
    public int x, y;

    Node() {
	adj = new LinkedList<>();
    }
}

// Classe que representa um no para ficar na fila de prioridade
static class NodeQ implements Comparable<NodeQ> {
    public double cost;
    public int node;

    NodeQ(double c, int n) {
	cost = c;
	node = n;
    }

    @Override
    public int compareTo(NodeQ nq) {
        if (cost < nq.cost) return -1;
        if (cost > nq.cost) return +1;
        if (node < nq.node) return -1;
        if (node > nq.node) return +1;
        return 0;
    }
}

// Classe que representa um grafo
static class Graph {
    int n;          // Numero de nos do grafo
    Node[] nodes;   // Array para conter os nos

    Graph(int n) {
	this.n = n;
	nodes = new Node[n+1];  // +1 se os nos comecam em 1 ao inves de 0
	for (int i=1; i<=n; i++)
	    nodes[i] = new Node();
    }

    void addLink(int a, int b, double c) {
	nodes[a].adj.add(new Edge(b, c));
  nodes[b].adj.add(new Edge(a, c));
    }

    // Algoritmo de Dijkstra
    void prim(int s) {

	//Inicializar nos como nao visitados e com distancia infinita
	for (int i=1; i<=n; i++) {
	    nodes[i].distance = Integer.MAX_VALUE;
	    nodes[i].visited  = false;
	}

	// Inicializar "fila" com no origem
	nodes[s].distance = 0;
	TreeSet<NodeQ> q = new TreeSet<>();
	q.add(new NodeQ(0, s)); // Criar um par (dist=0, no=s)

  double total = 0;
	// Ciclo principal do Dijkstra
	while (!q.isEmpty()) {

	    // Retirar no com menor distancia (o "primeiro" do set, que e uma BST)
	    NodeQ nq = q.pollFirst();
	    int  u = nq.node;
	    nodes[u].visited = true;
	    //System.out.println(u + " [dist=" + nodes[u].distance + "]");
      total += nodes[u].distance;

	    // Relaxar arestas do no retirado
	    for (Edge e : nodes[u].adj) {
		int v = e.to;
		double cost = e.weight;
		if (!nodes[v].visited &&  cost < nodes[v].distance) {
		    q.remove(new NodeQ(nodes[v].distance, v)); // Apagar do set
		    nodes[v].distance = cost;
		    q.add(new NodeQ(nodes[v].distance, v));    // Inserir com nova (e menor) distancia
		}
	    }
	}
  System.out.printf("%.5f", total);
  System.out.println();
    }
}



    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
  int n = in.nextInt();
	Graph g = new Graph(n);
  Node[] newnodes = new Node[n+1];
  double dist;
  for(int i = 1; i <= n ; i++){
    newnodes[i] = new Node();
    newnodes[i].x = in.nextInt();
    newnodes[i].y = in.nextInt();
  }
  for(int i=1; i<n; i++){
    for(int j=i+1; j<=n; j++){
      dist = Math.sqrt((newnodes[i].x-newnodes[j].x)*(newnodes[i].x-newnodes[j].x) + (newnodes[i].y-newnodes[j].y)*(newnodes[i].y-newnodes[j].y));
      g.addLink(i, j, dist);
    }
  }
  g.prim(1);
    }
}
