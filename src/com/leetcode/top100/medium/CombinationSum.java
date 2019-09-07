package com.leetcode.top100.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的数字可以无限制重复被选取。 PS:解集不重复
 * 
 * @author hitomeng
 * @date 2019/09/06
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        // Arrays.sort(candidates);
        helper(result, new ArrayList<Integer>(), candidates, 0, target);
        return result;
    }

    /**
     * 
     * @param result     最终的结果
     * @param temp       一个可用条件
     * @param candidates 可选的计算数
     * @param target     目的 和值
     */
    private void helper(List<List<Integer>> result, List<Integer> temp, int[] candidates, int start, int tempTarget) {
        // 如何处理不重复问题？重复是因为从某个数j可能被前面的数i使用过了，当循环到j的时候，j人会使用i来凑target。每个j只用自己之后的数来计算就行了
        // 排序后记住下一个起始的index
        if (tempTarget == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }

        // 
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] <= tempTarget) {
                temp.add(candidates[i]);
                // start = i，因为可以重复使用某个数
                helper(result, temp, candidates, i, tempTarget - candidates[i]);
                temp.remove(temp.size() - 1);
            }
        }
    }

    @Test
    public void test() {
        int[] arr = new int[] { 2, 3, 6, 7 };
        List<List<Integer>> result = combinationSum(arr, 7);
        System.out.println(result.toString());
    }
}