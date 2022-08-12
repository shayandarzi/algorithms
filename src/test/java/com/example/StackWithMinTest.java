package com.example;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Elham
 * @since 7/24/2022
 */
public class StackWithMinTest {
    @Test
    public void testStackWithMin() {
        StackWithMin stackWithMin = new StackWithMin();
        stackWithMin.push(10);
        stackWithMin.push(2);
        assertEquals(stackWithMin.min(), 2);
        assertEquals(stackWithMin.pop(), 2);
        assertEquals(stackWithMin.min(), 10);
    }
}
