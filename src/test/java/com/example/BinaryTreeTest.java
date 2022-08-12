package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Elham
 * @since 6/2/2021
 */
public class BinaryTreeTest {
    private BinaryTree<Integer> binaryTree;


    @BeforeEach
    public void setUp() {
        BinaryNode<Integer> left = new BinaryNode<>(1);
        BinaryNode<Integer> right = new BinaryNode<>(3);
        BinaryNode<Integer> root = new BinaryNode<>(2, left, right);
        binaryTree = new BinaryTree<>(root);
    }

    @Test
    public void testInOrderTraversal() {
        List<Integer> inOrderList = binaryTree.inOrder();
        assertEquals(inOrderList.size(), 3);
        assertEquals(inOrderList.get(0), 1);
        assertEquals(inOrderList.get(1), 2);
        assertEquals(inOrderList.get(2), 3);
    }

    @Test
    public void testLevelOrderTraversal() {
        List<Integer> inOrderList = binaryTree.levelOrderTraversal();
        assertEquals(inOrderList.size(), 3);
        assertEquals(inOrderList.get(0), 2);
        assertEquals(inOrderList.get(1), 1);
        assertEquals(inOrderList.get(2), 3);
    }
}
