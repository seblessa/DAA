import java.util.Scanner;

public class DAA015 {

    public static class Pair{
        int x;
        int y;

        public Pair(int x,int y){
            this.x=x;
            this.y=y;
        }
        public Pair(){

        }
    }

    public static Pair max_in(int[] array){
        Pair max = new Pair();
        int max_number=0;
        for (int i : array){
            if (array[i]>max_number){
                max.x=i;
                max.y=max_number;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();

        int[] baloes = new int[N];

        for(int i=0;i<N;i++){
            baloes[i]=in.nextInt();
        }

        int count=0;
        int min=N;

        for (int i=0;i<baloes.length;i++){

        }

    }


}
