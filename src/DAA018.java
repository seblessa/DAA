import java.util.Scanner;

public class DAA018 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int[] moedas = new int[N];

        for (int i=0;i< moedas.length;i++){
            moedas[i]=in.nextInt();
        }

        int Q = in.nextInt();

        for (int it = 0; it <Q; it++){
            int P=in.nextInt();
            int[] usados = new int[P+1];
            int[] use = new int[P+1];

            usados[0]=0;
            use[0]=-1;
            for (int i=1;i<=P;i++){
                usados[i]=Integer.MAX_VALUE;
                for (int j = 0; j < moedas.length; j++) {
                    if (moedas[j] <= i && 1 + usados[i - moedas[j]] < usados[i]) {
                        usados[i] = 1 + usados[i - moedas[j]];
                        use[i] = moedas[j];
                    }
                }
            }
            System.out.print(P+": ["+ usados[P]+"] ");
            StringBuilder str= new StringBuilder();
            while(P!=0){
                str.append(use[P]).append(" ");
                P-=use[P];
            }
            System.out.println(str.deleteCharAt(str.length()-1));
        }
    }
}