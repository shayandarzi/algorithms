package com.example;

import com.example.utils.LinkedListNode;

/**
 * @author Shayan
 * @since 6/18/2021
 */

/*
* Intersection: Given two (singly) linked lists, determine if the two lists intersect. Return the
intersecting node. Note that the intersection is defined based on reference, not value. That is, if the
kth node of the first linked list is the exact same node (by reference) as the jth node of the second
linked list, then they are intersecting
* */
public class IntersectionFinder<T> {

    public LinkedListNode<T> findIntersection(LinkedListNode<T> list1, LinkedListNode<T> list2) {
        if (list1 == null || list2 == null) {
            return null;
        }
        Result result1 = getTailAndLength(list1);
        Result result2 = getTailAndLength(list2);
        if (result1.tail != result2.tail) {
            return null;
        }
        LinkedListNode<T> longer = result1.length > result2.length ? list1 : list2;
        LinkedListNode<T> shorter = result1.length > result2.length ? list2 : list1;
        longer = getKthNode(longer, Math.abs(result1.length - result2.length));
        while (longer != shorter) {
            longer = longer.getNext();
            shorter = shorter.getNext();
        }
        return longer;
    }

    private LinkedListNode<T> getKthNode(LinkedListNode<T> head, int k) {
        LinkedListNode<T> current = head;
        while (current != null && k > 0) {
            current = current.getNext();
            k--;
        }
        return current;
    }

    private Result getTailAndLength(LinkedListNode<T> head) {
        LinkedListNode<T> current = head;
        int length = 0;
        while (current.getNext() != null) {
            length++;
            current = current.getNext();
        }
        return new Result(current, length);
    }

    class Result {
        LinkedListNode<T> tail;
        int length;

        public Result(LinkedListNode<T> tail, int length) {
            this.tail = tail;
            this.length = length;
        }
    }
}
