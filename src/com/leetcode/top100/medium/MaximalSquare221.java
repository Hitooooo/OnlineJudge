package com.leetcode.top100.medium;

/**
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 * 
 * @author hitomeng
 * @date 2019/10/14
 */
public class MaximalSquare221 {

    /**
     * df[i][j] = min(dp[i-1][j], dp[i][i-1], dp[i-1][j-1]) + 1 ;matrix[i][j] == '1'
     * 可以通过创建横竖都多1的二位数组来存储dp值，就可以不用数组越界问题
     */
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int x = matrix.length;
        int y = matrix[0].length;
        int max = 0;
        // java整形数组的默认值为0
        int[][] dp = new int[x + 1][y + 1];
        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= y; j++) {
                if(matrix[i-1][j-1] == '1'){
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1])+1;
                    max = Math.max(max, dp[i][j] * dp[i][j]);
                }
            }
        }
        return max;
    }
}