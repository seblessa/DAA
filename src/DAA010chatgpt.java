import java.util.Arrays;

public class DAA010chatgpt {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner(System.in);

        int n = sc.nextInt();
        int[] s = new int[n];
        for (int i = 0; i < n; i++) {
            s[i] = sc.nextInt();
        }

        Arrays.sort(s);

        int q = sc.nextInt();
        int[] p = new int[q];
        for (int i = 0; i < q; i++) {
            p[i] = sc.nextInt();
        }

        for (int i = 0; i < q; i++) {
            int pi = p[i];
            int left = 0; // Índice do menor número de S que é maior ou igual a Pi/2
            int right = n - 1; // Índice do maior número de S que é menor ou igual a Pi/2
            while (left < right) {
                int mid = (left + right + 1) / 2;
                if (s[mid] <= pi / 2) {
                    left = mid;
                } else {
                    right = mid - 1;
                }
            }
            int sum1, sum2;
            if (left == 0) {
                sum1 = Integer.MIN_VALUE; // Sinaliza que não há nenhum número anterior a s[left] que possa ser somado
            } else {
                sum1 = s[left] + s[left - 1]; // Soma dos dois números mais próximos à esquerda de Pi/2
            }
            if (right == n - 1) {
                sum2 = Integer.MAX_VALUE; // Sinaliza que não há nenhum número posterior a s[right] que possa ser somado
            } else {
                sum2 = s[right] + s[right + 1]; // Soma dos dois números mais próximos à direita de Pi/2
            }
            int diff1 = Math.abs(pi - sum1); // Distância entre Pi e sum1
            int diff2 = Math.abs(pi - sum2); // Distância entre Pi e sum2
            if (diff1 < diff2 || (diff1 == diff2 && sum1 < sum2)) {
                System.out.println(sum1);
            } else if (diff2 < diff1 || sum2 < sum1) {
                System.out.println(sum2);
            } else {
                System.out.println(sum1 + " " + sum2);
            }
        }
    }
}
