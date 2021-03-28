package binarytree;


import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinaryTreeTest {

    private static BinaryTree binaryTree;

    @BeforeClass
    public static void testBinaryTree() {
        binaryTree = new BinaryTreeImpl();
    }

   @Test
    public void testNode() {
        binaryTree.accept(10);
        binaryTree.accept(6);
        binaryTree.accept(18);
        binaryTree.accept(4);
        binaryTree.accept(8);
        binaryTree.accept(15);
        binaryTree.accept(21);

        int maxDepth = binaryTree.treeDepth();
        assertEquals(3, maxDepth);
    }

    @Test
    public void testDepth() {
        binaryTree.accept(10);
        binaryTree.accept(6);
        binaryTree.accept(18);
        binaryTree.accept(4);
        binaryTree.accept(8);
        binaryTree.accept(15);
        binaryTree.accept(21);

        int depth = binaryTree.depth(8);
        assertEquals(3, depth);
    }
}