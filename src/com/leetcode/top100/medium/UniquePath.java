package com.leetcode.top100.medium;

import org.junit.Test;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in
 * the diagram below). The robot can only move either down or right at any point
 * in time. The robot is trying to reach the bottom-right corner of the grid
 * (marked 'Finish' in the diagram below). How many possible unique paths arethere? 
 * mxn的矩阵，从左上角到右下角有几种不同的路径，注意只能往下/往左走。 
 * 1. 数学思想：总共走了m+n-2步，选择其中n-1步是往下走的，也就是从m+n-2中选择n-1个的组合问题。C(m+n-2, n-1)
 * 2. DP
 * 
 * @author htmeng
 * @since 2019/09/16
 */
public class UniquePath {

    /**
     * dp: dp[i][j] = dp[i][j-1] + dp[i-1][j]
     * dp[i][j]的可能步数跟左面和上面的有关。
     */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 1;
                }else{
                    dp[i][j] = dp[i][j-1] + dp[i-1][j];
                }
            }
        }
        return dp[n-1][m-1];
    }

    @Test
    public void test(){
        int path = uniquePaths(3, 18);
        System.out.println(path);
    }
}