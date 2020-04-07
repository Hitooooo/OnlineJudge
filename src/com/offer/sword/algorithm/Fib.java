package com.offer.sword.algorithm;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author hitomeng
 * @date 2020/02/13
 */
public class Fib {
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fib(n - 2) + fib(n - 1);
    }

    public int fib2(int n) {
        int front = 1;
        int beforFront = 1;

        if (n <= 0) {
            return 0;
        }
        if (n <= 2) {
            return front;
        }
        int current = 0;
        for (int i = 3; i <= n; i++) {
            current = front + beforFront;
            beforFront = front;
            front = current;
        }
        return current;
    }

    @Test
    public void testFib() {
        assertEquals(fib(0), fib2(0));
        assertEquals(fib(2), fib2(2));
        assertEquals(fib(8), fib2(8));
        assertEquals(fib(5), fib2(5));
    }
}