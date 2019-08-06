package com.leetcode.top100.easy;

import static org.junit.Assert.assertArrayEquals;

import java.util.HashMap;

import org.junit.Test;

/**
 * Given an array of integers,return indices of the two numbers such that they
 * add up to a specific target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may
 * not use the same element twice.
 *
 * @author HitoM
 * @date 2019/3/3 0:07
 */
public class TwoNum {

    public int[] solution(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (hm.containsKey(target - nums[i])) {
                result[1] = i;
                result[0] = hm.get(target - nums[i]);
                return result;
            }
            hm.put(nums[i], i);
        }
        return result;
    }

    @Test
    public void test2Sum(){
        // exactly one solution  you may not use the same element twice
        assertArrayEquals(new int[]{1,1}, twoSum(new int[]{2,2,2}, 4));
    }
}
