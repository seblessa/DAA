import java.util.Scanner;

public class DAA031 {

    static int L;
    static int C;
    static char[][] grid;
    static char SMOKE ='#';
    static char AIRPORT='A';

    static char[][] create_grid(Scanner in){
        char[][] grid = new char[L][C];
        for (int i=0;i<L;i++){
            String line = in.nextLine();
            for (int j = 0; j < C; j++) {
                grid[i][j]=line.charAt(j);
            }
        }
        return grid;
    }

    static void expand(){
        char[][] new_grid=new char[L][C];
        for (int i = 0; i < L; i++) {
            for (int j = 0; j < C; j++) {
                if (grid[i][j]==SMOKE){
                    if (i-1>=0) new_grid[i-1][j]=SMOKE;
                    if (i+1<L) new_grid[i+1][j]=SMOKE;
                    if (j+1<C) new_grid[i][j+1]=SMOKE;
                    if (j-1>=0) new_grid[i][j-1]=SMOKE;
                }
            }
        }
        for (int i = 0; i < L; i++) {
            for (int j = 0; j < C; j++) {
                if (new_grid[i][j]!=SMOKE){
                    new_grid[i][j]=grid[i][j];
                }
            }
        }
        grid=new_grid;
    }

    static void print_grid(){
        for (int i = 0; i < L; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    static int get_airports(){
        int n=0;
        for (int i = 0; i < L; i++) {
            for (int j = 0; j < C; j++) {
                if (grid[i][j]==AIRPORT) n++;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        L = in.nextInt();
        C = in.nextInt();
        in.nextLine();

        grid = create_grid(in);

        int count=0;
        int first=0;

        int n_airports=get_airports();
        boolean flag=true;
        while(n_airports>0){
            expand();
            // print_grid();
            count++;
            if (get_airports()<n_airports && flag){
                first=count;
                flag=false;
            }
            n_airports=get_airports();
        }

        System.out.println(first+" "+count);

    }
}
