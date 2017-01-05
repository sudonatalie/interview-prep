public class Ch4 {
    public class Tree<T> {
        Tree left;
        Tree right;
        T data;

        int height() {
            leftHeight = this.left == null ? 0 : this.left.height();
            rightHeight = this.right == null ? 0 : this.right.height();
            return 1 + Math.max(leftHeight, rightHeight);
        }

        // 4.1
        // TODO O(n log n), make more efficient
        boolean isBalanced() {
            if (Math.abs(this.left.height() - this.right.height()) > 1)
                return false;
            else
                return this.left.isBalanced() && this.right.isBalanced();

        }

        // 4.5
        boolean isSorted() {

        }
    }

    public class Graph<T> {
        public class Vertex<T> {
            T data;
        }

        public class Edge<T> {
            Vertex<T> from, to;
        }

        private List<Vertex<T>> vertices;
        private List<Edge<T>> edges;
        private Vertex<T> root;
    }


}