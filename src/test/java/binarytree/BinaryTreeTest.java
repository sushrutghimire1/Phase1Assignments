package binarytree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinaryTreeTest {

    private BinaryTree binaryTree;

    @BeforeEach
    void testBinaryTree(){
        binaryTree=new BinaryTreeImpl();
    }

    @Test
    void testNode() {
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
    void testDepth() {
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