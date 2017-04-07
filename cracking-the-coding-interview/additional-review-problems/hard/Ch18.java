import java.io.*;
import java.util.*;

public class Ch18 {
    public static int add(int a, int b) {
        return add(a, b, 0);
    }

    public static int add(int a, int b, int carry) {
        if (a == 0 && b == 0) {
            return carry;
        }
        if (a == 0 && carry == 0) {
            return b;
        }
        if (b == 0 && carry == 0) {
            return a;
        }

        int a1 = a & 1;
        int b1 = b & 1;

        if (carry == 0) {
            return add(a >> 1, b >> 1, (a1 & b1)) << 1 | (a1 ^ b1);
        }
        else {
            return add(a >> 1, b >> 1, (a1 | b1)) << 1 | (a1 == b1 ? 1 : 0);
        }
    }

    public static void main(String[] args) {
        int[][] tests = { {0, 0}, {0, 1}, {1, 0}, {1, 1}, {10, 10}, {4223, 23}};

        for (int i = 0; i < tests.length; i++) {
            int a = tests[i][0];
            int b = tests[i][1];
            System.out.println(a + " + " + b + " = " + add(a, b));
        }
    }
}