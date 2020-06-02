package com.leetcode.offer.sword;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class Solution16 {
    public double myPow(double x, int n) {
        if (x == 0) {
            throw new RuntimeException();
        }
        if (n == 0) {
            return 1;
        }
        int pow = 0;
        boolean negative = false;
        if (n < 0) {
            pow = -n;
            negative = true;
        } else {
            pow = n;
        }
        double num = fastPow(x, pow);
        return negative ? (1.0 / num) : num;
    }

    private double fastPow(double n, int k) {
        if (k == 0) {
            return 1;
        }
        if (k == 1) {
            return n;
        }
        double half = fastPow(n, k / 2);
        return (k % 2) == 0 ? half * half : half * half * n;
    }

    @Test
    public void test() {
        System.out.println(Double.compare(myPow(2, 10), Math.pow(2, 10)));
    }
}