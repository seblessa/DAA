import java.util.Scanner;

public class DAA013 {

    public static class Segment{
        int l;
        int r;

        public Segment(int l, int r) {
            this.l = l;
            this.r = r;
        }

        @Override
        public String toString() {
            return l + " " + r;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int M = in.nextInt();
        int N = in.nextInt();
        Segment[] seg_arr = new Segment[N];


        for (int i=0;i<N;i++){
            int l = in.nextInt();
            int r = in.nextInt();
            seg_arr[i] = new Segment(l,r);
        }

        int covered = 0;
        int count = 0;

        while (covered < M) {
            int maxRight = covered;
            for (int i = 0; i < N; i++) {
                if (seg_arr[i].l <= covered && seg_arr[i].r > maxRight) {
                    maxRight = seg_arr[i].r;
                }
            }
            covered = maxRight;
            count++;
        }
        System.out.println(count);


    }
}
