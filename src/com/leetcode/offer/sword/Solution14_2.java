package com.leetcode.offer.sword;

import org.junit.Test;

public class Solution14_2 {
    public int cuttingRope(int n) {
        if (n <= 0) {
            return n;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        int timesOf3 = n / 3;
        if (n - timesOf3 * 3 == 1) {
            timesOf3--;
        }
        int timesOf2 = (n - timesOf3 * 3) / 2;
        double tempRes = fastPow(3, timesOf3) * fastPow(2, timesOf2);
        return (int)(tempRes %  1000000007);
    }
    private int mod = (int)1e9 + 7;
    public long fastPow(int a, int b) {
        if (b == 0)
            return 1;
        if (b == 1)
            return a;
        long half = fastPow(a, b / 2);
        return b % 2 == 0 ? half * half % mod : half * half * a % mod;
    }

    @Test
    public void test() {
        System.out.println(cuttingRope(120));
        ;
    }
}