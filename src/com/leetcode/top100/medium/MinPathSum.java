package com.leetcode.top100.medium;

import org.junit.Test;

/**
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * @author htmeng
 * @date 2019/9/16
 */
public class MinPathSum {

    /**
     * dp[i][j] = min(dp[i-1][j], dp[i][j-1]) + dp[i][j]; i>0,j>0
     * dp[i][j] = dp[i][j-1] + dp[i][j]; i=0,j>0
     * dp[i][j] = dp[i-1][j] + dp[i][j]; i>0,j=0
     */
    public int minPathSum(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (i == 0) {
                    grid[i][j] += grid[i][j - 1];
                } else if (j == 0) {
                    grid[i][j] += grid[i - 1][j];
                } else {
                    grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
                }
            }
        }

        return grid[grid.length - 1][grid[0].length - 1];
    }

    @Test
    public void test(){
        int[][] arr = {{1,3,1},{1,5,1},{4,2,1}};
        int i = minPathSum(arr);
        System.out.println(i);
    }
}
