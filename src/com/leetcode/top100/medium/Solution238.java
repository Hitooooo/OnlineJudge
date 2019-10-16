package com.leetcode.top100.medium;

/**
 * 给定长度为 n 的整数数组 nums，其中 n > 1， 返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i]
 * 之外其余各元素的乘积。
 * 
 * @author hitomeng
 * @date 2019/10/16
 */
public class Solution238 {

    /**
     * result[i] = nums(0-->i-1)的积乘于nums(i+1 --> nums.length)的积
     * 1. 用一个数组记录前缀积
     * 2. 从后往前遍历，计算i后面的乘积
     * 3. 计算i的结果
     */
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] pres = new int[len];
        pres[0] = 1;
        for (int i = 1; i < len; i++) {
            pres[i] = pres[i -1] * nums[i -1];
        }

        int tempRight = 1;   // 循环利用，右面计算后的值
        for (int j = len - 1; j > -1; j--) {
            pres[j] = tempRight * pres[j];
            tempRight = tempRight * nums[j];
        }
        return pres;
    }
}