import java.util.*;
import java.io.*;

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

        public String toString() {
            StringBuffer str = new StringBuffer();
            Node n = this;
            while (n != null) {
                str.append(n.data);
                str.append("->");
                n = n.next;
            }
            str.append("⊥");
            return str.toString();
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

    // TODO Q2.3

    // TODO Q2.4

    // Q2.5
    static Node sumWithCarry(Node a, Node b, int carry) {
        Node head;
        if (a == null && b == null) {
            return null;
        }
        else if (a == null) {
            int val = b.data + carry;
            head = new Node(val % 10);
            head.next = sumWithCarry(null, b.next, val / 10);
        }
        else if (b == null) {
            int val = a.data + carry;
            head = new Node(val % 10);
            head.next = sumWithCarry(null, a.next, val / 10);
        }
        else {
            int val = a.data + b.data + carry;
            head = new Node(val % 10);
            head.next = sumWithCarry(a.next, b.next, val / 10);
        }
        return head;
    }

    static Node sum(Node a, Node b) {
        return sumWithCarry(a, b, 0);
    }

    static void test5() {
        Node empty = null;

        // 1
        Node singleton = new Node(1);

        // 21
        Node two = new Node(1);
        Node two2 = new Node(2);
        two.next = two2;

        // 210
        Node three = new Node(0);
        three.next = two;

        // Test: () + 1 = 1
        System.out.println(empty + " + " + singleton + " = " + sum(empty, singleton));

        // Test: 21 + () = 21
        System.out.println(two + " + " + empty + " = " + sum(two, empty));

        // Test: 21 + 1 = 22
        System.out.println(two + " + " + singleton + " = " + sum(two, singleton));

        // Test: (210 + 1) + 21 = 232
        System.out.println("(" + three + " + " + singleton + ") + " + two + " = " + sum(sum(three, singleton), two));

    }

    // TODO Q2.6

    // TODO Q2.7

    public static void main(String[] args) {
        test2();
        test5();
    }
}