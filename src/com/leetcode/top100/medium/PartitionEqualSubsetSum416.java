package com.leetcode.top100.medium;

import java.util.List;

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
     * 数组和一定是偶数才能被拆分成两个子数组。两个和相等的子数列，那么只需要找到和为
     * 总数和的一半的子数列，那么就可以被拆分
     * 
     * @param nums
     * @return can partition or not
     */
    public boolean canPartition(int[] nums) {
        return false;
    }

    public List<Integer> helper(int target, int[] source, List<Integer> subset){
       if(target == 0){
           return subset;
       }else if(target < 0){
           return null;
       } 
        return null;
    }
}