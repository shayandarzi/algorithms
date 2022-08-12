package com.example;

import com.example.utils.LinkedListNode;
import com.example.utils.NodeUtil;

/**
 * @author Shayan
 * @since 6/11/2021
 */
public class Palindrome {

    public boolean isPalindromeRecursive(LinkedListNode<String> head) {
        int length = NodeUtil.getLength(head);
        Result result = isPalindromeUtil(head, length);
        return result.isPalindrome;
    }

    private Result isPalindromeUtil(LinkedListNode<String> head, int length) {
        if (head == null || length <= 0) {
            return new Result(true, head);
        }
        Result result = isPalindromeUtil(head.getNext(), length - 2);
        if (result.node == null || !result.isPalindrome) {
            return result;
        }
        result.isPalindrome = result.node.getData().equals(head.getData());
        result.node = result.node.getNext();
        return result;
    }

    static class Result {
        boolean isPalindrome;
        LinkedListNode<String> node;

        public Result(boolean result, LinkedListNode<String> node) {
            this.isPalindrome = result;
            this.node = node;
        }
    }
}
