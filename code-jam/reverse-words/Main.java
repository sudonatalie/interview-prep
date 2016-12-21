import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt();
        in.nextLine();
        for (int i = 1; i <= cases; i++) {
            String line = in.nextLine();
            String[] word = line.split(" ");
            System.out.print("Case #" + i + ":");
            for (int j = word.length - 1; j >= 0; j--) {
                System.out.print(" " + word[j]);
            }
            System.out.println();
        }
    }
}