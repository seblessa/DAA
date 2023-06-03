import java.util.Scanner;

public class DAA029 {

    static int N_LETTER = 26;
    static boolean[][] adj;
    static String[] words;
    static boolean[] letters;
    static int OFFSET = 65;

    public static void print_string(int i){
        if (letters[i]){
            for (int k = 0; k < adj.length; k++) {
                if (adj[i][k]){
                    System.out.println((char)(i + OFFSET));
                    print_string(k);
                    return;
                }
            }
        }
    }

    public static void dfs(int i, int j){
        if (i<words.length-1 && j<words[i].length()){
            int index = words[i].charAt(j) - OFFSET;
            int index_next = words[i + 1].charAt(j) - OFFSET;
            if (letters[index]) {
                if (words[i].charAt(j) != words[i+1].charAt(j)) {
                    adj[i][j] = true;
                    System.out.println((char) (i + OFFSET));
                    System.out.println((char) (j + OFFSET));
                } else {
                    dfs(i, j + 1);
                }
            }
            dfs(i + 1, j);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        in.nextLine();

        words = new String[n];
        for (int i=0;i<n;i++) {
            words[i] = in.nextLine();
        }

        letters = new boolean[N_LETTER];
        adj = new boolean[N_LETTER][N_LETTER];

        dfs(0,0);

        print_string(0);

    }
}
