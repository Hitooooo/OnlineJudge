package com.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * 杨辉三角。输入k，返回k层的数值列表。
 * 
 * @author hitomeng
 * @date 2020/01/20
 */
public class PascalTriangle2 {
    public List<Integer> getRow(int rowIndex) {
        if (rowIndex < 0) {
            return new ArrayList<Integer>();
        }
        Integer[] dp = new Integer[rowIndex + 1];
        Arrays.fill(dp, 1);
        // 第一层已被填充
        // 多少层，外层就遍历多少次。每循环完成一次，生成一层杨辉三角中一层。
        for (int i = 2; i < rowIndex + 1; i++) {
            // 从后往前
            for (int j = i - 1; j >= 1; j--) {
                dp[j] = dp[j] + dp[j - 1];
            }

        }
        return Arrays.asList(dp);
    }

    @Test
    public void test() {
        System.err.println(getRow(2));

    }
}