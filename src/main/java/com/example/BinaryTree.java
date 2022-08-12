package com.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Shayan
 * @since 6/3/2021
 */
public class BinaryTree<T> {

    BinaryNode<T> root;

    public BinaryTree(BinaryNode<T> root) {
        this.root = root;
    }

    public List<T> levelOrderTraversal() {
        if (root == null) {
            return null;
        }
        List<T> result = new ArrayList<>();
        Queue<BinaryNode<T>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryNode<T> node = queue.poll();
            result.add(node.data);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return result;
    }

    public List<T> inOrder() {
        List<T> inOrderList = new ArrayList<>();
        inOrder(root, inOrderList);
        return inOrderList;
    }

    private void inOrder(BinaryNode<T> node, List<T> inOrderList) {
        if (node.left != null) {
            inOrder(node.left, inOrderList);
        }
        inOrderList.add(node.data);
        if (node.right != null) {
            inOrder(node.right, inOrderList);
        }
    }
}
