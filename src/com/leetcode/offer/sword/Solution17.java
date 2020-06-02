package com.leetcode.offer.sword;

import java.util.Arrays;

import org.junit.Test;

public class Solution17 {
    public int[] printNumbers(int n) {
        int numCount = (int) Math.pow(10, n) - 1;
        int[] nums = new int[numCount];
        for (int i = 0; i < numCount; i++) {
            nums[i] = i + 1;
        }
        return nums;
    }

    @Test
    public void test() {
        System.out.println(Arrays.toString(printNumbers(3)));
    }
}