import java.util.Scanner;

public class DAA017 {
    public static long[][] create_matrix(int N){
        long[][] matrix = new long[N][N];
        for (int i=0;i<N;i++){
            for (int j=0;j<N;j++){
                if (i>=j){
                    matrix[i][j]=1;
                }
            }
        }
        return  matrix;
    }
    public static void fill_matrix(long[][] matrix, int f){
        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix.length;j++){
                matrix[i][j]=f;
            }
        }
    }
    public static void print_matrix(long[][] m){
        for (int i=0;i<m.length;i++){
            for (int j=0;j< m[0].length;j++){
                System.out.print(m[i][j]);
            }
            System.out.println();
        }
    }
    public static long n_paths(long[][] matrix){
        long[][] cache = new long[matrix.length][matrix.length];
        fill_matrix(cache,-1);
        return reaches_bottom(matrix,cache,0,0);
    }
    public static long reaches_bottom(long[][] matrix,long[][] cache, int i,int j){
        if (i>=matrix.length) return 1;
        if (matrix[i][j]==1){
            if (cache[i][j]!=-1){
                return cache[i][j];
            }
            cache[i][j] = reaches_bottom(matrix,cache, i+1,j)+reaches_bottom(matrix,cache,i+1,j+1);
            return cache[i][j];
        }
        return 0;
    }
    public static void main(String[] args) {
        Scanner in =  new Scanner(System.in);
        int N = in.nextInt();
        int D = in.nextInt();

        long[][] M = create_matrix(N);

        for (int i=0;i<D;i++){
            int C = in.nextInt();
            int P = in.nextInt();
            M[N-C][P-1]=0;
        }

        // print_matrix(M);

        System.out.println(n_paths(M)/2);

    }
}