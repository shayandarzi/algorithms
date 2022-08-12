package com.example;

/**
 * @author Shayan
 * @since 6/2/2021
 */
public class BinaryNode<T> {
    T data;
    BinaryNode<T> left;
    BinaryNode<T> right;

    public BinaryNode(T data) {
        this.data = data;
        left = right = null;
    }

    public BinaryNode(T data, BinaryNode<T> left, BinaryNode<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
