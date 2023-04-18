import java.util.*;
public class DAA009 {
    public static class Pair implements Comparable<Pair>{
        char letter;
        int count;
        int firstIndex;


        public Pair(char letter){
            this.letter=letter;
            this.count=0;
            this.firstIndex=-1;
        }
        public void add(int index){
            if (count==0) firstIndex=index;
            count++;
        }
        public int getCount() {
            return count;
        }
        @Override
        public String toString() {
            return letter +" "+ count;
        }

        @Override
        public int compareTo(Pair p) {
            if (p.count<count) return -1;
            if (count<p.count) return 1;
            if (firstIndex<p.firstIndex) return -1;
            if (p.firstIndex<firstIndex) return 1;
            return 0;
        }
    }

    public static Pair[] inicialize(){
        Pair[] list = new Pair[26];
        for (int i=0;i<26;i++){
            list[i]=new Pair((char)('A'+i));
        }
        return list;
    }

    public static void main(String[] args) {
        FastScanner in = new FastScanner(System.in);
        String line = in.nextLine();
        Pair[] list = inicialize();

        for (int i=0;i<line.length();i++){
            int pos = line.charAt(i) - 'A';
            list[pos].add(i);
        }

        Arrays.sort(list);

        for (Pair pair : list) {
            if (pair.getCount() > 0) {
                System.out.println(pair);
            }
        }


    }
}
