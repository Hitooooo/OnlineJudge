package com.leetcode.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * 杨辉三角递归实现
 * 
 * @author hitomeng
 * @date 2020/01/20
 */
public class Triangle {
    public List<List<Integer>> generate(int numRows) {
        if (numRows <= 0) {
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result.add(Arrays.asList(1));
        return helper(result, 0, numRows - 1);
    }

    private List<List<Integer>> helper(List<List<Integer>> result, int layer, int allLayer) {
        if (layer < allLayer) {
            List<Integer> preList = result.get(layer);
            List<Integer> currList = new ArrayList<>(preList.size() + 1);
            for (int i = 0; i < preList.size() + 1; i++) {
                currList.add(-1);
            }
            for (int i = 0; i < currList.size(); i++) {
                int topLeft = i - 1 < 0 ? 0 : preList.get(i - 1);
                int topRight = i >= preList.size() ? 0 : preList.get(i);
                currList.set(i, topLeft + topRight);
            }
            result.add(currList);
            return helper(result, layer + 1, allLayer);
        } else {
            return result;
        }
    }

    @Test
    public void test() {
        List<List<Integer>> res = generate(6);
        System.out.println(res);
    }
}