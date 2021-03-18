package binarytree;

public class BinaryTreeImpl implements BinaryTree {
    private Node root;

    @Override
    public boolean accept(int value) {
        if (root == null) {
            root = new Node(value);
            return true;
        }
        return root.accept(value);
    }

    @Override
    public int depth(int value) {
        return root.depth(root,value);
    }

    @Override
    public int treeDepth() {
        return root.maxDepth(root);
    }
}
