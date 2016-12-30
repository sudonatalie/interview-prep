import java.util.*;

public class Ch2 {

    static class Node {
        Node next = null;
        int data;

        public Node(int d) {
            data = d;
        }

        void appendToTail(int d) {
            Node end = new Node(d);
            Node n = this;
            while (n.next != null) {
                n = n.next;
            }
            n.next = end;
        }
    }

    static Node deleteNode(Node head, int d) {
        Node n = head;

        if (n.data == d) {
            return head.next; // move head
        }

        while (n.next != null) {
            if (n.next.data == d) {
                n.next = n.next.next; // delete node
                // if C/C++ we would also deallocate
                return head;
            }
            n = n.next;
        }
        return head;
    }

    // Q2.1
    static void removeDuplicates(Node n) {
        HashSet<Integer> values = new HashSet<Integer>();
        values.add(n.data);

        while (n.next != null) {
            if (values.contains(n.next.data)) {
                // remove duplicate
                n.next = n.next.next;
            }
            else {
                // remember new value
                values.add(n.next.data);
            }
            n = n.next;
        }
    }

    // Q2.2
    static int kthLast(Node n, int k) {
        assert(k > 0);

        Node p1 = n;
        Node p2 = n; // keep (k-1) nodes behind p1

        for (int i = 1; i <= k - 1; i++) {
            p1 = p1.next;
            assert(p1 != null || i >= k - 1);
        }

        while (p1.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p2.data;
    }

    static void test2() {
        Node empty = null;

        // [1]
        Node singleton = new Node(1);

        // [1] -> [2]
        Node two = new Node(1);
        Node two2 = new Node(2);
        two.next = two2;

        // [0] -> [1] -> [2]
        Node three = new Node(0);
        three.next = two;

        assert(kthLast(singleton, 1) == 1);
        assert(kthLast(two, 1) == 2);
        assert(kthLast(two, 2) == 1);
        assert(kthLast(three, 3) == 0);
        assert(kthLast(three, 2) == 1);

    }

    public static void main(String[] args) {
        test2();
    }
}