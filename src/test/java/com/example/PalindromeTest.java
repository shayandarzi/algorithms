package com.example;

import com.example.utils.LinkedListNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Elham
 * @since 6/2/2021
 */
public class PalindromeTest {
    private  Palindrome palindrome = new Palindrome();
    private LinkedListNode<String> head;


    @BeforeEach
    public void setUp() {
        LinkedListNode<String> node5 = new LinkedListNode<>("0");
        LinkedListNode<String> node4 = new LinkedListNode<>("1", node5);
        LinkedListNode<String> node3 = new LinkedListNode<>("2", node4);
        LinkedListNode<String> node2 = new LinkedListNode<>("1", node3);
        head = new LinkedListNode<>("0", node2);
    }

    @Test
    public void testPalindromeOddLength() {
        boolean result = palindrome.isPalindromeRecursive(head);
        assertTrue(result);
    }

    @Test
    public void testPalindromeEvenLength() {
        LinkedListNode<String> node3Prim = new LinkedListNode<>("2", head.getNext().getNext());
        head.getNext().setNext(node3Prim);
        boolean result = palindrome.isPalindromeRecursive(head);
        assertTrue(result);
    }

    @Test
    public void testNotPalindrome() {
        head.getNext().setData("3");
        boolean result = palindrome.isPalindromeRecursive(head);
        assertFalse(result);
    }
}
