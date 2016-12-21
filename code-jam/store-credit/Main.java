import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt();
        for (int i = 1; i <= cases; i++) {
            int credit = in.nextInt();
            int items = in.nextInt();

            int price[] = new int[items];
            for (int j = 0; j < items; j++) {
                price[j] = in.nextInt();
            }

            System.out.print("Case #" + i + ": ");
            printPair(credit, items, price);
        }
    }

    private static void printPair(int credit, int items, int[] price) {
        for (int j = 0; j < items; j++) {
            int match = credit - price[j];
            for (int k = j + 1; k < items; k++) {
                if (price[k] == match) {
                    if (j < k)
                        System.out.println((j + 1) + " " + (k + 1));
                    else
                        System.out.println((k + 1) + " " + (j + 1));
                    return;
                }
            }
        }

        System.out.println("No solution found");
    }
}