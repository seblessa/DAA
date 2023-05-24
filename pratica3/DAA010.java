import java.util.Arrays;
import java.util.Scanner;

public class DAA010 {

    public static void print_array(int[] arr){
        for (int elem : arr){
            System.out.print(elem+" ");
        }
        System.out.println();
    }

    public static void binary_search(int[] S, int min, int max, int P){
        int mid=(min+max)/2;
        while (Math.abs(min-max)>1){

            if (P> S[mid]){
                min=mid;
                mid=(min+max)/2;

            } else if (P<S[mid]) {
                max=mid;
                mid=(min+max)/2;

            }else {
                System.out.println(S[mid]);
                return;
            }
        }
        if (mid==0){
            int dist_mid = Math.abs(S[mid] - P);
            int dist_front = Math.abs(S[mid+1] - P);
            if(dist_mid<dist_front){
                System.out.println(S[mid]);
            }
            else if (dist_mid==dist_front){
                System.out.println(S[mid]+" "+S[mid+1]);
            }else {
                System.out.println(S[mid+1]);
            }
            return;
        }
        if (mid==S.length-1){
            int dist_back = Math.abs(S[mid-1] - P);
            int dist_mid = Math.abs(S[mid] - P);

            if(dist_mid<dist_back){
                System.out.println(S[mid]);
            }
            else if (dist_mid==dist_back){
                System.out.println(S[mid]+" "+S[mid-1]);
            }else {
                System.out.println(S[mid-1]);
            }
            return;
        }

        int dist_back = Math.abs(S[mid-1] - P);
        int dist_mid = Math.abs(S[mid] - P);
        int dist_front = Math.abs(S[mid+1] - P);

        if (dist_back>dist_front){
            if(dist_mid<dist_front){
                System.out.println(S[mid]);
            }
            else if (dist_mid==dist_front){
                if (S[mid]!=S[mid+1]){
                    System.out.println(S[mid]+" "+S[mid+1]);
                }else {
                    System.out.println(S[mid+1]);
                }
            }else {
                System.out.println(S[mid+1]);
            }
        }else {
            if(dist_mid<dist_back){
                System.out.println(S[mid]);
            }
            else if (dist_mid==dist_back){
                if (S[mid]!=S[mid-1]){
                    System.out.println(S[mid]+" "+S[mid-1]);
                }else {
                    System.out.println(S[mid-1]);
                }
            }else {
                System.out.println(S[mid-1]);
            }
        }



    }


    public static int[] combine(int[] S){
        int length=0;
        for (int i=0;i<S.length;i++){
            for (int j=i+1;j<S.length;j++){
                length++;
            }
        }
        int[] new_arr = new int[length];
        int count=0;
        for (int i=0;i<S.length;i++){
            for (int j=i+1;j<S.length;j++){
                new_arr[count]=S[i]+S[j];
                count++;
            }
        }
        return new_arr;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int[] S = new int[N];

        for (int i=0;i<N;i++){
            S[i] = in.nextInt();
        }

        S=combine(S);

        Arrays.sort(S);

        // print_array(S);

       int Q = in.nextInt();

        for (int i=0;i<Q;i++){
            int P = in.nextInt();

            binary_search(S,0,S.length-1,P);
        }
        FastPrint.out.close();
    }
}