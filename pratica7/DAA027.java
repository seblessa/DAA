import java.util.Scanner;

public class DAA027 {
    static boolean flag;
    static int V;
    static int E;
    static boolean[][] adj;
    static int[] colours;
    static boolean[] visited;

    static void dfs(int v) {
        if (flag) return;

        for (int i=1;i<=V;i++){
            if (adj[v][i]){
                if(!visited[i]) {
                    visited[i]=true;
                    if (colours[v]==1) colours[i]=2;
                    if (colours[v]==2) colours[i]=1;
                    dfs(i);
                }else{
                    if (colours[v]==colours[i]) flag = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();

        for (int i=0;i<N;i++){
            flag = false;

            V = in.nextInt();
            E = in.nextInt();

            adj = new boolean[V+1][V+1];
            visited = new boolean[V+1];
            colours = new int[V+1];

            for (int j = 0; j <E; j++) {
                int a = in.nextInt();
                int b = in.nextInt();
                adj[a][b] = adj[b][a] = true;
            }

            colours[1]=1;
            for (int j = 1; j <=V; j++){
                if (!visited[j]) dfs(j);
            }

            if (flag){
                System.out.println("nao");
            }else {
                System.out.println("sim");
            }
        }
    }
}
