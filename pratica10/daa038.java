import java.util.Arrays;
import java.util.LinkedList;
import java.util.TreeSet;


public class daa038{

// Classe que representa uma aresta
static class Edge{
      int to;     // No destino
      int weight; // Peso da aresta

      Edge(int t, int w){
          to = t;
          weight = w;
      }

    }

// Classe que representa um nó
static class Node{
      public LinkedList<Edge> adj; // Lista de adjacencias
      public boolean visited; // No ja foi visitado?
      public int distance; // Distância ao nó origem da pesquisa

      Node(){
          adj = new LinkedList<>();
      }

    }

// Classe que representa um nó para ficar na fila de prioridade
static class NodeQ implements Comparable<NodeQ>{
  public int cost;
  public int node;

  NodeQ(int c, int n){
	  cost = c;
	  node = n;
  }

  @Override
  public int compareTo(NodeQ nq){
      if (cost < nq.cost) return -1;
      if (cost > nq.cost) return +1;
      if (node < nq.node) return -1;
      if (node > nq.node) return +1;
    return 0;
  }
}

// Classe que representa um grafo
static class Graph{
      int n, vermelhas;          // Numero de nos do grafo
      Node[] nodes;   // Array para conter os nos

      Graph(int n, int red){
          this.n = n;
        vermelhas = red;
          nodes = new Node[n+1];  // +1 se os nós comecam em 1 ao inves de 0
          for (int i=1; i<=n; i++) nodes[i] = new Node();
      }

      void addLink(int a, int b, int c){
          nodes[a].adj.add(new Edge(b, c));
        nodes[b].adj.add(new Edge(a, c));
      }

      // Algoritmo de Dijkstra
      void prim(int r){
          //Inicializar nos como nao visitados e com distancia infinita
          for (int i=1; i<=n; i++){
            nodes[i].distance = Integer.MAX_VALUE;
            nodes[i].visited  = false;
          }

         // Inicializar "fila" com nó origem
         nodes[r].distance = 0;
         TreeSet<NodeQ> q = new TreeSet<>();
         q.add(new NodeQ(0, r)); // Criar um par (dist=0, no=s)

       int total = 0;
       int[] arestas = new int[vermelhas];

         // Ciclo principal do Dijkstra
         while (!q.isEmpty()){
           // Retirar no com menor distância (o "primeiro" do ‘set’, que e uma BST)
           NodeQ nq = q.pollFirst();
           int  u = nq.node;
           nodes[u].visited = true;
         //System.out.println(nodes[u].distance);
         total += nodes[u].distance;
           // Relaxar arestas do no retirado
           for (Edge e : nodes[u].adj){
              int v = e.to;
              int cost = e.weight;
              if (!nodes[v].visited && cost < nodes[v].distance){
                q.remove(new NodeQ(nodes[v].distance, v)); // Apagar do set
                nodes[v].distance = cost;
                q.add(new NodeQ(nodes[v].distance, v));    // Inserir com nova (e menor) distancia
              }
           }
          }
        int j=0;
        for(int i=n-vermelhas+1; i<=n; i++) arestas[j++] = nodes[i].distance;
        Arrays.sort(arestas);
        FastPrint.out.println(total);
        for(int k=0; k<vermelhas; k++){
          if(k!=vermelhas-1) FastPrint.out.print(arestas[k] + " ");
          else FastPrint.out.println(arestas[k]);
        }
      }

    }
    public static void main(String[] args){
	  FastScanner in = new FastScanner(System.in);
    int black = in.nextInt();
    int red = in.nextInt();
    int houses = black + red;
    int lig = in.nextInt();
	  Graph g = new Graph(houses,red);
    for(int i=1; i<black; i++){
      g.addLink(i,i+1,0);
    }
    for(int i=0; i<lig; i++){
      g.addLink(in.nextInt(),in.nextInt(),in.nextInt());
    }
	  g.prim(1);
    FastPrint.out.close();
  }
}
