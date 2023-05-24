public class DAA005 {
    public static void main(String[] args) {
        FastScanner in = new FastScanner(System.in);
        int N=in.nextInt();
        int[] powers = new int[N];
        int[] sum_powers = new int[N+1];
        sum_powers[0]=0;
        for (int i=0;i<N;i++){
            powers[i]=in.nextInt();
            sum_powers[i+1]=sum_powers[i]+powers[i];
        }
        int n_photos=in.nextInt();
        for (int i=0;i<n_photos;i++){
            int start= in.nextInt();
            int finish= in.nextInt();
            FastPrint.out.println(sum_powers[finish]-sum_powers[start-1]);
        }
        FastPrint.out.close();
    }
}