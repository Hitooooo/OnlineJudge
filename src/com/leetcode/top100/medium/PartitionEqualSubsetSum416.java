package com.leetcode.top100.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

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
        int[] reverseArr = IntStream.rangeClosed(1, nums.length).map(i -> nums[nums.length - i]).toArray();
        return canPartition(sum / 2, reverseArr, 0);
    }

    /**
     * 一个数组中是都存在 和为目标值的子数组 每一个元素，只有两种可能，取或者不取，遍历这些状态就可以了。 取：target减小，判断余下是否可继续分割 不取:
     * target不变，
     * 
     * @param target 目标
     * @param source 原数组
     * @param index  i
     * @return can or not
     */
    private boolean canPartition(int target, int[] source, int index) {
        // 数组做了降序处理
        // 如果一个数大于target，显然它不应该在子数组中，其构成的所有子数组都不可能是解数组
        if (index >= source.length || target < source[index] ) {
            return false;
        }

        if (target == source[index]) {
            return true;
        }
        // 为什么或的关系，换个位置就会超时呢？
        // 对于值都是一样的数组用例，一直无法弹栈，时间复杂度 n!
        return canPartition(target - source[index], source, index + 1) || canPartition(target, source, index + 1) ;
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
                if (next != null) {
                    return next;
                }
            }
        }
        return null;
    }

    @Test
    public void test() {
        int[] arr = {100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100 };

        boolean res = canPartition(arr);
        System.out.println(res);
    }
}