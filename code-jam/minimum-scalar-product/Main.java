import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt();

        for (int i = 1; i <= cases; i++) {
            // Vector length
            int n = in.nextInt();

            // Capture vector coordinates
            long[] v1 = new long[n];
            long[] v2 = new long[n];
            for (int j = 0; j < n; j++) {
                v1[j] = in.nextLong();
            }
            for (int j = 0; j < n; j++) {
                v2[j] = in.nextLong();
            }

            // Sort arrays
            Arrays.sort(v1);
            Arrays.sort(v2);

            // Calculate min scalar product
            long prod = 0;
            for (int j = 0; j < n; j++) {
                prod += v1[j] * v2[n - 1 - j];
            }

            // Output
            System.out.println("Case #" + i + ": " + prod);
        }
    }
}