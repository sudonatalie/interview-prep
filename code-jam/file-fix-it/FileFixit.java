import java.io.*;
import java.util.*;


//
public class FileFixit {

    public static class Directory {
        String name;
        Directory parent;
        ArrayList<Directory> children;

        public Directory() {
            name = null;
            parent = null;
            children = new ArrayList();
        }

        public Directory(String name) {
            Directory();
            this.name = name;
        }

        public Directory(String name, Directory parent) {
            Directory(name);
            this.parent = parent;
            parent.children.add(this);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        // Number of test cases
        int tests = in.nextInt();

        int n = in.nextInt();
        int m = in.nextInt();

        // Test cases
        for (int t = 1; t <= test; t++) {

            in.nextLine();

            Directory root = new Directory;
            root.name = "";
            root.parent = null;
            root.children = new ArrayList();

            // Iterate over existing dirs
            for (int i = 0; i < n; i++) {
                String path = in.nextLine();
                String[] paths = path.splitAt("/");

                Directory lastDir = root;
                for(String dirName : paths) {
                    Directory dir = new Directory(dirName, lastDir);
                    lastDir = dir;
                }
            }
            // Iterate over dirs to create
            for (int i = 0; i < m; i++) {
                String path = in.nextLine();

            }
        }
    }
}