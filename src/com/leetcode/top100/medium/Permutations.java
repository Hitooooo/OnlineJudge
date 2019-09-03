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
     * Runtime: 38 ms, faster than 5.01% of Java online submissions 😂
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
}