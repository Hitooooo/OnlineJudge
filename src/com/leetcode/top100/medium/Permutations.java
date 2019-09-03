package com.leetcode.top100.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

/**
 * Given a collection of distinct integers, return all possible permutations.
 * 给出一组不重复的整数，打印所有的排列组合
 * 
 * @author hitomeng
 * @date 2019/09/03
 */
public class Permutations {
    /**
     * 回溯法了解一下？
     */
    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        backtrace(result, temp, nums);
        return result;
    }

    private void backtrace(List<List<Integer>> result, List<Integer> temp, int[] nums) {
        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (temp.contains(nums[i])) {
                continue;
            }
            // 传到下一层的nums应该是减去当前已经add过的了，但是可以通过判断是否包含的方式，巧妙的将其过滤
            temp.add(nums[i]);
            backtrace(result, temp, nums);
            temp.remove(temp.size() - 1);
        }
    }

    /**
     * Runtime: 38 ms, faster than 5.01% of Java online submissions 😂
     * 
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        return helper(list);
    }

    private List<List<Integer>> helper(List<Integer> nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.size() == 1) {
            result.add(nums);
            return result;
        }
        for (Integer i : nums) {
            ArrayList<Integer> dest = new ArrayList<>(nums);
            dest.remove(i);
            List<List<Integer>> next = helper(dest);

            for (List<Integer> integers : next) {
                integers.add(i);
                result.add(integers);
            }
        }
        return result;
    }

    @Test
    public void test() {
        List<List<Integer>> result = permute(new int[] { 1, 2, 3 });
        System.out.println(result);
    }

    @Test
    public void test2() {
        List<List<Integer>> result = permute2(new int[] { 1, 2, 3 });
        System.out.println(result);
    }
}