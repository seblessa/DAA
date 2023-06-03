import java.util.*;

public class DAA035 {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int [][] matrix =new int[n][n];

        for(int i=0;i<n;i++){
            matrix[i][i]=1;

            String origin=in.next();
            int originIndex=origin.charAt(0)-'A';

            int m=in.nextInt();
            for(int j=0;j<m;j++){
                String destination=in.next();
                int destinationIndex=destination.charAt(0)-'A';
                matrix[originIndex][destinationIndex]=1;
            }
        }
        calc(matrix);
        System.out.print("  ");
        for (int i = 0; i < n; i++) {
            System.out.print((char) ('A' + i));
            if (i < n - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.print((char) ('A' + i) + " ");
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j]);
                if (j <n - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

    }

    public static void calc(int[][]matrix){
        int n=matrix.length;
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    matrix[i][j] = matrix[i][j] | (matrix[i][k] & matrix[k][j]);
                }
            }
        }
    }
}