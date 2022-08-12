package com.example;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * @author Shayan
 * @since 6/18/2021
 */
/*
 * How would you design a stack which, in addition to push and pop, has a function min which returns the minimum
 * element? Push, pop and min should all operate in 0(1) time
 * */

/*solution from https://www.geeksforgeeks.org/design-a-stack-that-supports-getmin-in-o1-time-and-o1-extra-space/*/
public class StackWithMin extends Stack<Integer> {
    private Integer minEle;

    @Override
    public Integer push(Integer value) {
        if (super.isEmpty()) {
            minEle = value;
        }
        if (value < minEle) {
            super.push(2*value - minEle);
            minEle = value;
        } else {
            super.push(value);
        }
        return value;
    }

    @Override
    public synchronized Integer peek() {
        if (super.isEmpty()) {
            throw new EmptyStackException();
        }
        int value = super.peek();
        if (value < minEle) {
            return minEle;
        }
        return value;
    }

    @Override
    public synchronized Integer pop() {
        if (super.isEmpty()) {
            throw new EmptyStackException();
        }
//        Note: I can't use super.pop() here, because it's using peek() method and I overrode peek method here. So, when we have a value less that minEle, it will return minEle instead.
//        int value = super.pop();
        int value = super.peek();
        if (value < minEle) {
            int toBeReturn = minEle;
            minEle = 2*minEle - value;
            super.pop();
            return toBeReturn;
        }

        return super.pop();
    }

    public Integer min() {
        if (super.isEmpty()) {
            throw new EmptyStackException();
        }
        return minEle;
    }
}
