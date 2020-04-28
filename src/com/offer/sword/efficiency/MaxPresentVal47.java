package com.offer.sword.efficiency;

import org.junit.Test;

/**
 * 在一个 m*n 的棋盘中的每一个格都放一个礼物，每个礼物都有一定的价值（价值大于0）.
 * 你可以从棋盘的左上角开始拿各种里的礼物，并每次向右或者向下移动一格，直到到达棋盘的右下角。 
 * 给定一个棋盘及上面个的礼物，请计算你最多能拿走多少价值的礼物？
 * 
 * @author hitomeng
 * @date 2020-04-28 22:20:57
 */
public class MaxPresentVal47 {

    /**
     * 右下的最大值由 左面和上面的决定。dp即可 dp[i][j] = val[i][j] + Math.max(dp[i - 1][j], df[i][j - 1])
     * @param grid
     * @return
     */
    public int maxValue(int[][] grid) {
        if (grid == null || grid.length < 1) {
            return 0;
        }
        int[][] vals = new int[grid.length][grid[0].length];
        for (int i = 0; i < vals.length; i++) {
            for (int j = 0; j < vals[0].length; j++) {
                int left = j > 0 ? vals[i][j - 1] : 0;
                int up = i > 0 ? vals[i - 1][j] : 0;
                vals[i][j] = Math.max(left + grid[i][j], up + grid[i][j]);
            }
        }
        return vals[grid.length - 1][grid[0].length - 1];
    }


    @Test
    public void test(){
        int[][] arr = {{1,10,3,8},{12,2,9,6},{5,7,4,11},{3,7,16,5}};
        int res = maxValue(arr);
        System.out.println(res);
    }
}