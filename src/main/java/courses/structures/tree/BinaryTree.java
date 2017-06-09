package courses.structures.tree;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree<E extends Comparable> {
    Node<E> root;

    public void add(E element) {
        if (root == null) {
            root = new Node<>(element);
        } else {
            root.add(element);
        }
    }

    public boolean search(E element) {
        return searchIn(root, element);
    }


    public List<E> depthFirstTraversal() {
        List<E> res = new ArrayList<>();
        depthFirst(root, res);
        return res;
    }

    private void depthFirst(Node<E> node, List<E> res) {
        if (node == null) return;
        res.add(node.data);
        depthFirst(node.left, res);
        depthFirst(node.right, res);
    }

    public List<E> breadthFirstTraversal() {
        List<E> res = new ArrayList<>();
        Queue<Node<E>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node<E> node = queue.remove();
            res.add(node.data);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return res;
    }

    private static boolean searchIn(Node node, Comparable element) {
        if (node == null) {
            return false;
        }
        return node.search(element);
    }

    static class Node<E extends Comparable> {
        E data;

        Node<E> left = null;
        Node<E> right = null;

        Node(E data) {
            this.data = data;
        }

        public void add(E element) {
            if (data.compareTo(element) > 0) {
                // to the left branch
                if (left == null) {
                    left = new Node<>(element);
                } else {
                    left.add(element);
                }
            } else {
                // to the right branch
                if (right == null) {
                    right = new Node<>(element);
                } else {
                    right.add(element);
                }
            }
        }

        public boolean search(E element) {
            if (data.equals(element)) {
                return true;
            }
            if (data.compareTo(element) > 0) {
                // to the left branch
                return searchIn(left, element);
            } else {
                // to the right branch
                return searchIn(right, element);
            }
        }

    }
}
