import java.util.Scanner;

public class DAA014 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        long[][] encomendas = new long[N][3];

        for(int i=0;i<N;i++){
            encomendas[i][0] = in.nextLong();
            encomendas[i][1] = in.nextLong();
            encomendas[i][2] = i + 1; //store the original index of the order
        }

        mergesort(encomendas, 0, N-1);

        for (int i = 0; i < N; i++) {
            if(i!=N-1){
                System.out.print(encomendas[i][2] + " ");
            }else{
                System.out.println(encomendas[i][2]);
            }

        }
    }
    public static void mergesort(long[][] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;

            mergesort(arr, l, m);
            mergesort(arr, m + 1, r);

            merge(arr, l, m, r);
        }
    }
    public static void merge(long[][] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        long[][] L = new long[n1][3];
        long[][] R = new long[n2][3];

        for (int i = 0; i < n1; i++) {
            L[i] = arr[l + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = arr[m + 1 + j];
        }

        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            if (L[i][0] * R[j][1] <= R[j][0] * L[i][1]) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }

        while (i < n1) {
            arr[k++] = L[i++];
        }

        while (j < n2) {
            arr[k++] = R[j++];
        }
    }
}