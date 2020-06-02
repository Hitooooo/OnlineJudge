package com.leetcode.offer.sword;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Solution15 {
    // 统计一个数二进制表示中1的个数
    public int hammingWeight(int n) {
        return Integer.bitCount(n);
    }

    public int hammingWeight2(int n) {
        int count = 0;
        while (n != 0) {
            count += n & 1;
            n = n >>> 1;
        }
        return count;
    }

    @Test
    public void test(){
        assertEquals(hammingWeight(-9), hammingWeight2(-9));
    }
}