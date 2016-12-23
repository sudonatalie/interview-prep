import java.io.*;
import java.util.*;

public class AlienLanguage {

    static int l; // word length
    static int d; // dictionary size
    static String[] dictionary;

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        // Capture language metadata
        l = in.nextInt();
        d = in.nextInt();

        // Number of test cases
        int n = in.nextInt();

        // Populate dictionary
        dictionary = new String[d];
        in.nextLine();
        for (int i = 0; i < d; i++) {
            dictionary[i] = in.nextLine();
        }

        // Test cases
        for (int i = 1; i <= n; i++) {
            String pattern = in.nextLine().trim();
            String regex = pattern.replace('(', '[').replace(')', ']');

            int counter = 0;

            // Iterate over dictionary
            for (String word : dictionary) {
                if (word.matches(regex)) counter++;
            }

            System.out.println("Case #" + i + ": " + counter);
        }
    }
}