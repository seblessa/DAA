import java.util.Scanner;

public class DAA026 {

    static char ALIVE = '#';
    static int L;
    static int C;
    static int counter;
    static char[][] cells;
    static boolean[][] visited;
    static char[][] create_matrix(Scanner in) {
        char[][] matrix = new char[L][C];

        for (int i=0;i<L;i++){
            String str = in.nextLine();
            for (int j=0;j<C;j++) {
                matrix[i][j] = str.charAt(j);
            }
        }
        return matrix;
    }

    static void dfs(int i,int j) {
        if (i>=0 && i<L && j>=0 && j<C){
            if (!visited[i][j] && cells[i][j]==ALIVE){
                visited[i][j] = true;
                counter++;
                dfs(i+1,j);
                dfs(i+1,j+1);
                dfs(i,j+1);
                dfs(i-1,j);
                dfs(i-1,j+1);
                dfs(i-1,j-1);
                dfs(i,j-1);
                dfs(i+1,j-1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();

        for (int i=0;i<N;i++){
            L = in.nextInt();
            C = in.nextInt();
            in.nextLine();

            cells = create_matrix(in);
            visited = new boolean[L][C];

            int max_counter=0;
            for (int n=0;n<L;n++){
                for (int m=0;m<C;m++){
                    if (!visited[n][m]) dfs(n,m);
                    max_counter=Math.max(max_counter,counter);
                    counter=0;
                }
            }

            System.out.println(max_counter);

        }
    }
}
