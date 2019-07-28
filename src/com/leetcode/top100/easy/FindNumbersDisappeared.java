package com.leetcode.top100.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * nums[1,n]中，数组中没有出现的[1-n]中的数字
 * Input:
 * [4,3,2,7,8,2,3,1]
 *
 * Output:
 * [5,6]
 *
 * @author HitoM
 * @date 2019/4/25 21:38
 **/
public class FindNumbersDisappeared {

    /**
     * 如果值val出现了，那么就将nums[val]置为负，这样既可以判断值出现，而且可以通过绝对值的方式获取原本的值
     * nums[nums[i] -1] = -nums[nums[i]-1]
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            // 为什么减一，因为值是从1开始的，防止index越界
            int val = Math.abs(nums[i]) - 1;
            if (nums[val] > 0) {
                nums[val] = -nums[val];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                integers.add(i + 1);
            }
        }

        return integers;
    }
}
