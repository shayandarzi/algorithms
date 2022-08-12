package com.example;

import com.example.utils.LinkedListNode;

/**
 * @author Shayan
 * @since 6/18/2021
 */

/**
 * Given a circular linked list, implement an algorithm that returns the node at the
 * beginning of the loop
 */
public class LoopDetection<T> {
    //    note: I think there is a simpler solution with o(n) space complexity. keep visited nodes in a set and check if it has been visited before or not
    public LinkedListNode<T> findLoop(LinkedListNode<T> head) {
        LinkedListNode<T> slower = head;
        LinkedListNode<T> faster = head;
        while (faster != null && faster.getNext() != null) {
            slower = slower.getNext();
            faster = faster.getNext().getNext();
            if (faster == slower) {
                break;
            }
        }

        if (faster == null || faster.getNext() == null) {
            return null;
        }
        slower = head;
        while (slower != faster) {
            slower = slower.getNext();
            faster = faster.getNext();
        }
        return slower;
    }
}
