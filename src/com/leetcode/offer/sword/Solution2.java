package com.leetcode.offer.sword;

import org.junit.Test;

/**
 * 找出数组中重复的数字。
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 */
public class Solution2 {
    public int findRepeatNumber(int[] nums) {
        if(nums == null || nums.length < 2){
            return -1;
        }
        for (int i = 0; i < nums.length; i++) {
            
            while(nums[i] != i){
                if(nums[i] == nums[nums[i]]){
                    return nums[i];
                }
                int pos = nums[i];

                int tmp = nums[i];
                nums[i] = nums[nums[i]];
                nums[pos] = tmp;
            }
          
        }
        return -1;
    }

    @Test
    public void test(){
        int r = findRepeatNumber(new int[]{0, 1, 2, 3, 4, 11, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15});
        System.out.println(r);
    }
}