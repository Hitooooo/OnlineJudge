package com.leetcode.top100.medium;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * 找到一个数组的非重复子集，包括空集
 * 
 * @author hitomeng
 * @since 2019/09/17
 */
public class Subset {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        helper(nums, 0, result, new ArrayList<Integer>());
        return result;
    }

    private void helper(int[] nums, int index, List<List<Integer>> result, List<Integer> temp) {
        result.add(new ArrayList<Integer>(temp));
        for(int i = index;i < nums.length; i++){
            temp.add(nums[i]);
            helper(nums, i+1, result, temp);
            temp.remove(temp.size() - 1);
        }
    }

    @Test
    public void test(){
       int[] arr = new int[]{1,2,3};
       List<List<Integer>> result = subsets(arr);
       System.out.println(result);
    }
}