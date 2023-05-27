import java.util.Scanner;

public class DAA025 {
    static int n;              // Numero de nos do grafo
    static boolean[][] adj;    // Matriz de adjacencias
    static boolean[] visited;  // Que nos ja foram visitados?

    static void dfs(int v) {
        visited[v] = true;
        for (int i=1; i<=n; i++)
            if (adj[v][i] && !visited[i])
                dfs(i);
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        adj = new boolean[n+1][n+1];
        visited = new boolean[n+1];

        int edges = in.nextInt();
        for (int i=0; i<edges; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            adj[a][b] = adj[b][a] = true;
        }

        int count=0;
        for (int i=1;i<=n;i++){
            if (!visited[i]) count++;
            dfs(i);
        }

        System.out.println(count);

    }



}
