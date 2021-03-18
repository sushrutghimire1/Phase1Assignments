package binarytree;

public class Node {
    private final int data;
    private Node left;
    private Node right;
    private static int depth = 0;

    Node(int value) {
        this.data = value;
    }

    public boolean accept(int value) {
        if (value == data)
            return false;
        if (value > data) {
            if (right == null) {
                right = new Node(value);
                return true;
            } else {
                return right.accept(value);
            }
        }
        if (left == null) {
            left = new Node(value);
            return true;
        } else {
            return left.accept(value);
        }
    }

    public int maxDepth(Node node) {
        if (node == null) {
            return (0);
        } else {
            int leftDepth = maxDepth(node.left);
            int rightDepth = maxDepth(node.right);
            if (leftDepth > rightDepth) {
                return (leftDepth + 1);
            } else {
                return (rightDepth + 1);
            }
        }
    }

    public int depth(Node node, int value) {
        if (node == null) {
            return 0;
        }
        if (node.data == value) {
            return depth + 1;
        } else {
            depth++;
            if (value < node.data)
                return depth(node.left, value);
            else
                return depth(node.right, value);
        }
    }

}
