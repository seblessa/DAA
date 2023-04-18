import java.util.Scanner;

import static java.lang.Character.isAlphabetic;

public class DAA003 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N= in.nextInt();
        in.nextLine();

        for (int i = 0; i < N; i++)
        {
            String[] line= in.nextLine().split(" ");
            String m1 = line[0];
            String m2 = line[1];

            System.out.println(Math.abs(number(m1)-number(m2)));
        }
    }

    public static int getInt(char letter) {
        letter-='A';

        if (letter>'K')  letter--;
        if (letter>'W')  letter--;
        if (letter>'Y')  letter--;

        return letter;
    }

    public static int generation(String m){
        if (isAlphabetic(m.charAt(0)))
        {
            if (isAlphabetic(m.charAt(7)))
            {
                return 4;
            }else{
                return 1;
            }

        }else{
            if (isAlphabetic(m.charAt(3)))
            {
                return 3;
            }else{
                return 2;
            }
        }


    }

    static int getNumber(String str, int pos){
        return str.charAt(pos)-'0';
    }


    static int number(String m){
        int g = generation(m);
        if (g==1)
        {
            int a= getInt(m.charAt(0))*23*10000;
            int b= getInt(m.charAt(1))*10000;
            int c= getNumber(m,3)*1000;
            int d= getNumber(m,4)*100;
            int e= getNumber(m,6)*10;
            int f= getNumber(m,7);

            return a+b+c+d+e+f;

        }else if (g==2)
        {
            int a= getInt(m.charAt(6))*23*10000;
            int b= getInt(m.charAt(7))*10000;
            int c= getNumber(m,0)*1000;
            int d= getNumber(m,1)*100;
            int e= getNumber(m,3)*10;
            int f= getNumber(m,4);


            return a+b+c+d+e+f+5290000;
        }else if (g==3)
        {
            int a= getInt(m.charAt(3))*23*10000;
            int b= getInt(m.charAt(4))*10000;
            int c= getNumber(m,0)*1000;
            int d= getNumber(m,1)*100;
            int e= getNumber(m,6)*10;
            int f= getNumber(m,7);

            return a+b+c+d+e+f+(5290000*2);
        }else if (g==4)
        {
            int a= getInt(m.charAt(0))*23*23*23*100;
            int b= getInt(m.charAt(1))*23*23*100;
            int c= getInt(m.charAt(6))*23*100;
            int d= getInt(m.charAt(7))*100;
            int e= getNumber(m,3)*10;
            int f= getNumber(m,4);

            return a+b+c+d+e+f+(5290000*3);
        }else{
            return 0;
        }
    }
}