package binarytree;


import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BinaryTreeTest {

    private static BinaryTree binaryTree;

    @BeforeClass
    public static void testBinaryTree() {
        binaryTree = new BinaryTreeImpl();
    }

    @Test
    public void testDepthOfBinaryTree() {
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
    public void testDepthOfValueInBinaryTree() {
        binaryTree.accept(10);
        binaryTree.accept(6);
        binaryTree.accept(18);
        binaryTree.accept(4);
        binaryTree.accept(8);
        binaryTree.accept(15);
        binaryTree.accept(21);

        int maxDepth = binaryTree.depth(4);
        assertEquals(3, maxDepth);
    }

    @Test
    public void testAcceptingOfValues() {
        Assertions.assertAll("acceptValues",
                () -> assertTrue(binaryTree.accept(10)),
                () -> assertTrue(binaryTree.accept(6)),
                () -> assertTrue(binaryTree.accept(18)),
                () -> assertTrue(binaryTree.accept(4)),
                () -> assertTrue(binaryTree.accept(8)),
                () -> assertTrue(binaryTree.accept(15)),
                () -> assertTrue(binaryTree.accept(21))
        );
    }


}