package com.example.utils;

/**
 * @author Shayan
 * @since 6/11/2021
 */
public class NodeUtil {
    public static int getLength(LinkedListNode<?> node) {
        int length = 0;
        while (node != null) {
            length++;
            node = node.getNext();
        }
        return length;
    }
}
