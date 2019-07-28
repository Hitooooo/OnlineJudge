package com.leetcode.top100.easy;

/**
 * Given an array nums, write a function to move all 0's
 * to the end of it while maintaining the relative order of the non-zero elements.
 *
 * @author HitoM
 * @date 2019/4/12 19:19
 **/
public class MoveZeroes {
    /**
     * 将非零往前移，记录下非零个数。将余下位置全部置为零。
     *
     * @param nums numbers
     */
    public void moveZeroes(int[] nums) {
        int position = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[position] = num;
                position++;
            }
        }
        for (int i = position; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
