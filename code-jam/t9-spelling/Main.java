import java.util.*;
import java.io.*;

public class Main {
    private static class Seq {
        public final int key;
        public final int reps;
        public Seq(int key, int reps) {
            this.key = key;
            this.reps = reps;
        }
    }

    private static HashMap<Character, Seq> t9Map;

    private static void initT9Map() {
        t9Map = new HashMap<Character, Seq>();

        t9Map.put(' ', new Seq(0, 1));
        int key = 2;
        for (char letter = 'a'; letter <= 'r'; key++) {
            int reps = 1;
            t9Map.put(letter++, new Seq(key, reps++));
            t9Map.put(letter++, new Seq(key, reps++));
            t9Map.put(letter++, new Seq(key, reps++));
        }
        t9Map.put('s', new Seq(7, 4));
        for (char letter = 't'; letter <= 'y'; key++) {
            int reps = 1;
            t9Map.put(letter++, new Seq(key, reps++));
            t9Map.put(letter++, new Seq(key, reps++));
            t9Map.put(letter++, new Seq(key, reps++));
        }
        t9Map.put('z', new Seq(9, 4));

    }

    public static void main(String[] args) {
        initT9Map();

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt();
        in.nextLine();

        for (int i = 1; i <= cases; i++) {
            System.out.print("Case #" + i + ": ");
            int lastKey = -1;
            String message = in.nextLine();
            for(char letter : message.toCharArray()) {
                Seq seq = t9Map.get(letter);
                if (seq.key == lastKey)
                    System.out.print(" ");
                lastKey = seq.key;
                for (int j = 0; j < seq.reps; j++)
                    System.out.print(seq.key);
            }
            System.out.println();
        }
    }
}

