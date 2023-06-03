import java.util.LinkedList;
import java.util.Scanner;

public class DAA030 {


    static class Node {
        public LinkedList<Integer> adj; // Lista de adjacencias
        public boolean visited;         // Valor booleano que indica se foi visitado numa pesquisa
        public int distance;            // Distancia ao no origem da pesquisa

        Node() {
            adj = new LinkedList<>();
        }
    }

    // Classe que representa um grafo
    static class Graph {
        int n;           // Numero de nos do grafo
        Node[] nodes;    // Array para conter os nos

        Graph(int n) {
            this.n = n;
            nodes  = new Node[n+1]; // +1 se nos comecam em 1 ao inves de 0
            for (int i=1; i<=n; i++)
                nodes[i] = new Node();
        }

        public void addLink(int a, int b) {
            nodes[a].adj.add(b);
            nodes[b].adj.add(a);
        }

        // Algoritmo de pesquisa em largura
        public int[] bfs(int v) {
            int[] dists = new int[n];

            LinkedList<Integer> q = new LinkedList<>();
            for (int i=1; i<=n; i++) nodes[i].visited = false;

            q.add(v);
            nodes[v].visited = true;
            nodes[v].distance = 0;

            while (q.size() > 0) {
                int u = q.removeFirst();
                dists[u-1]=nodes[u].distance;
                for (int w : nodes[u].adj)
                    if (!nodes[w].visited) {
                        q.add(w);
                        nodes[w].visited  = true;
                        nodes[w].distance = nodes[u].distance + 1;
                    }
            }
            return dists;
        }
    }

    static void print(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <N; j++) {
                System.out.print(dist[i][j]);
            }
            System.out.println();
        }
    }

    static int N;
    static int[][] dist;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        N = in.nextInt();
        Graph g = new Graph(N);
        int E = in.nextInt();

        dist = new int[N][N];

        for (int i=0; i<E; i++)
            g.addLink(in.nextInt(), in.nextInt());

        for (int i=0;i<N;i++){
            dist[i]=g.bfs(i+1);
        }

        print();

        System.exit(0);

        int[] ext = new int[N];
        int d = (int) Double.NEGATIVE_INFINITY;
        int r = (int) Double.POSITIVE_INFINITY;
        int[] nc_r = new int[N];
        int[] np_d = new int[N];

        for (int i = 0; i < N; i++) {
            int max=0;
            for (int j = 0; j < N; j++) {
                max=Math.max(dist[i][j],max);
            }
            ext[i]=max;
        }

        for (int i = 0; i < N; i++) {
            d = Math.max(ext[i],d);
            r = Math.min(ext[i],r);
        }

        for (int i=0;i< ext.length;i++) {
            if (ext[i]==d){
                np_d[i]=i+1;
            }
            if (ext[i]==r){
                nc_r[i]=i+1;
            }
        }
        System.out.println(d);
        System.out.println(r);

        int count=0;
        for (int j : nc_r) {
            if (j != 0 && count != 0) System.out.print(" " + j);
            if (count == 0 && j != 0) {
                System.out.print(j);
                count++;
            }
        }
        System.out.println();

        count=0;
        for (int j : np_d) {
            if (j != 0 && count != 0) System.out.print(" " + j);
            if (count == 0 && j != 0) {
                System.out.print(j);
                count++;
            }
        }
        System.out.println();
    }
}
