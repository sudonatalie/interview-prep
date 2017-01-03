import java.util.*;

public class Ch3 {
    /*
    static class Node {
        Node next = null;
        Object data;

        public Node(Object d) {
            data = d;
        }
    }

    static class Queue {
        Node first, last;

        void enqueue(Object item) {
            if (first == null) {
                last = new Node(item);
                first = last;
            }
            else {
                last.next = new Node(item);
                last = last.next;
            }
        }

        Object dequeue() {
            if (first != null) {
                Object item = first.data;
                first = first.next;
                if (first == null) last = null; // empty queue
                return item;
            }
            return null;
        }
    }

    static class Stack {
        Node top;

        Object pop() {
            if (top != null) {
                Object item = top.data;
                top = top.next;
                return item;
            }
            return null;
        }

        void push(Object item) {
            Node t = new Node(item);
            t.next = top;
            top = t;
        }

        Object peek() {
            return top.data;
        }
    }
    */

    // TODO Q3.3

    // Q3.4
    /*
    public class TowersOfHanoi {
        int n; // Number of disks

        // Pegs
        // Integer represents size of disk on stack
        Stack<Integer> src = new Stack<Integer>();
        Stack<Integer> dst = new Stack<Integer>();
        Stack<Integer> aux = new Stack<Integer>();

        // Only push if top is larger
        private void hanoiPush(Stack stack, Integer disk) {
            Integer top = stack.peek();
            assert(top == null || top > disk);
            stack.push(disk);
        }

        public TowersOfHanoi(int n) {
            this.n = n;

            // Push all disks onto src stack in descending order
            for (int i = n; i > 0; i--) {
                src.push(i);
            }
        }

        // Move disks from src to dst stack
        public moveDisks() {
            Integer top = src.pop();
            if (top == 0) {
                // Move to destination
                dst.push(top);
            }
            else {

            }
        }
    }
    */

    // 3.5
    public class MyQueue<T> {
        Stack<T> stack;
        Stack<T> aux;

        public MyQueue() {
            stack = new Stack<T>();
            aux = new Stack<T>();
        }

        void enqueue(T item) {
            T top = stack.pop();

            // Reverse "queue" stack onto auxiliary stack
            while (top != null) {
                aux.push(top);
                top = stack.pop();
            }

            // Put new element at bottom of stack
            stack.push(item);

            // Re-reverse rest of elements back onto the "queue" stack
            top = aux.pop();
            while (aux != null) {
                stack.push(top);
                top = aux.pop();
            }
        }

        T dequeue() {
            return stack.pop();
        }
    }

    // 3.6
    // TODO Test 3.6
    static void sort(Stack<T> stack) {
        Stack<T> aux = new Stack<T>();

        while(!stack.isEmpty()) {
            if (aux.isEmpty() || stack.peek() < aux.peek())
                aux.push(stack.pop());
            else {
                Integer tmp = stack.pop();
                while(!aux.isEmpty() && aux.peek() < tmp) {
                    stack.push(aux.pop());
                }
                aux.push(tmp);
            }
        }
    }

    // TODO 3.7
}