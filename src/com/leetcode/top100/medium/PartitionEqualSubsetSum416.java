package com.leetcode.top100.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * Given a non-empty array containing only positive integers, find if the array
 * can be partitioned into two subsets such that the sum of elements in both
 * subsets is equal.
 * 
 * @author hitomeng
 * @date 2019/12/13
 */
public class PartitionEqualSubsetSum416 {
    /**
     * 数组和一定是偶数才能被拆分成两个子数组。两个和相等的子数列，那么只需要找到和为 总数和的一半的子数列，那么就可以被拆分
     * 
     * @param nums
     * @return can partition or not
     */
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0) {
            return false;
        }
        Arrays.sort(nums);
        List<Integer> subset = helper(sum / 2, nums, 0, new ArrayList<Integer>());
        return subset != null && subset.size() > 0;
    }

    /**
     * 寻找一个数组中可以凑成和为target的子数组.没有剪枝的回溯内存爆炸。
     * 
     * @param target 目标和
     * @param source 源数组
     * @param index  数组开始索引
     * @param subset 子数组集合
     * @return 可用数的集合
     */
    public List<Integer> helper(int target, int[] source, int index, List<Integer> subset) {
        if (target == 0) {
            return subset;
        } else if (target < 0 || index > source.length - 1) {
            return null;
        }
        for (int i = index; i < source.length; i++) {
            if (source[i] <= target) {
                subset.add(source[i]);
                index += 1;
                List<Integer> next = helper(target - source[i], source, index, subset);
                if(next != null){
                    return next;
                }
            }
        }
        return null;
    }

    @Test
    public void test() {
        int[] arr = { 1,2,3,5};

        boolean res = canPartition(arr);
        System.out.println(res);
    }
}