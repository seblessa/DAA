import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class DAA025 {
    static int n;              // Numero de nos do grafo
    static boolean[][] adj;    // Matriz de adjacencias
    static boolean[] visited;  // Que nos ja foram visitados?

    public static String dfs(int v) {
        StringBuilder sb = new StringBuilder();
        sb.append(v).append(" ");
        visited[v] = true;
        for (int i = 1; i <= n; i++) {
            if (adj[v][i] && !visited[i]) {
                sb.append(dfs(i));
            }
        }
        return sb.toString().toString();
    }

    public static int[] toIntlist(String str){
        String[] arr_str = str.split(" ");

        int[] arr = new int[arr_str.length];

        for (int i=0;i< arr.length;i++){
            arr[i]=Integer.parseInt(arr_str[i]);
        }

        return arr;
    }


    public static boolean check(int[][] m,int n){
        for (int[] num0:m){
            for (int num1:num0){
                if (num1==0) return false;
                if (num1==n) return true;
            }
        }
        return false;
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
        boolean[] visited = new boolean[n];
        boolean flag=true;

        for (int i=1;i<=n;i++){
            int[] out = toIntlist(dfs(i));
            for (int n:out){
                if (!visited[n-1]){
                    visited[n-1]=true;
                    if (flag){
                        count++;
                        flag=false;
                    }
                }
            }
            flag=true;
        }

        System.out.println(count);

    }



}
