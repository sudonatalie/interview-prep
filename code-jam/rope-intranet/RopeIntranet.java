import java.io.*;
import java.util.*;

public class RopeIntranet {

    public static class Wire {
        public int a;
        public int b;

        public Wire(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    static int t; // number of test cases
    static int n; // number of wires

    static Wire[] wire;

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        t = in.nextInt();

        for (int i = 1; i <= t; i++) {
            n = in.nextInt();

            wire = new Wire[n];

            for (int j = 0; j < n; j++) {
                int a = in.nextInt();
                int b = in.nextInt();
                wire[j] = new Wire(a, b);
            }

            // Every combination of 2 wires, j and k
            int counter = 0;

            for (int j = 0; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (wiresCross(wire[j], wire[k])) counter++;
                }
            }

            System.out.println("Case #" + i + ": " + counter);
        }
    }

    static boolean wiresCross(Wire wire1, Wire wire2) {
        int sign1 = Integer.signum(wire1.a - wire2.a);
        int sign2 = Integer.signum(wire1.b - wire2.b);
        return (sign1 != sign2);
    }
}