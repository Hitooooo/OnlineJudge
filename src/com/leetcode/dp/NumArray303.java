package com.leetcode.dp;

import java.util.Arrays;

import org.junit.Test;

/**
 * 给定一个整数数组 nums，求出数组从索引 i 到 j (i ≤ j) 范围内元素的总和，包含 i, j 两点。
 * 
 * @author hitomeng
 * @date 2020-04-07 23:49:31
 */
public class NumArray303 {

    private int[] prefixSum;

    public NumArray303(int[] nums) {
        if (nums != null && nums.length > 0) {
            prefixSum = new int[nums.length];
            prefixSum[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                prefixSum[i] = prefixSum[i - 1] + nums[i];
            }
        }
    }

    public int sumRange(int i, int j) {
        return i == 0 ? prefixSum[j] : prefixSum[j] - prefixSum[i - 1];
    }

    @Test
    public void test() {
        NumArray303 n = new NumArray303(new int[] { 1, 2, 3, 4, 5 });
        int res = n.sumRange(1, 2);
        System.out.println(res);
    }
}