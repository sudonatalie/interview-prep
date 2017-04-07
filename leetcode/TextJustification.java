import java.io.*;
import java.util.*;

public class TextJustification {
    public static void main(String[] args) {
        String[] test = {"This", "is", "an", "example", "of", "text", "justification."};
        List<String> justified = fullJustify(test, 16);
    }

    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> out = new ArrayList<String>();

        if (words == null || words.length == 0) {
            return out;
        }

        int i = 0;
        while(i < words.length) {
            int lineLength = 0;
            int wordsInLine = 0;
            int firstWordInLine = i;

            StringBuilder str = new StringBuilder();

            while (i < words.length && lineLength + words[i].length() <= maxWidth) {
                str.append(words[i]);
                str.append(' ');
                lineLength += words[i].length() + 1;
                wordsInLine++;
                i++;
            }

            lineLength--;
            str.setLength(lineLength);
            String line = str.toString();

            System.out.println("unpadded line: " + line);

            if (lineLength != maxWidth) {
                int padding = maxWidth - lineLength;
                int spaces = wordsInLine - 1;


                System.out.println("lineLength " + lineLength);
                System.out.println("maxWidth " + maxWidth);
                System.out.println("wordsInLine " + wordsInLine);

                // Only one word in line
                if (spaces == 0) {
                    line += repeat(' ', padding);
                }
                else {
                    // For each space gap
                    int gapLoc = 0;
                    for (int j = 0; j < spaces; j++) {
                        gapLoc += words[firstWordInLine].length() + 1;
                        int spacesToAdd = padding / spaces + (j < padding % spaces ? 1 : 0);
                        line = line.substring(0, gapLoc) + repeat(' ', spacesToAdd) + line.substring(gapLoc);
                        gapLoc += spacesToAdd;
                        firstWordInLine++;
                    }
                }
            }

            System.out.println(line);
            out.add(line);
        }

        return out;
    }

    public static String repeat(char c, int n) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < n; i++)
            str.append(c);
        return str.toString();
    }
}