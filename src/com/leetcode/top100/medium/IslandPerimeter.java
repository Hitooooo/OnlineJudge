package com.leetcode.top100.medium;

/**
 * 463. 岛屿的周长
 * 
 * @author hitomeng
 * @since 2019/09/20
 */
public class IslandPerimeter {

    /**
     * 遍历每个位置，如果四个方向中某个方向是岛屿，那么那个方向上就不参加周长计算
     */
    public int islandPerimeter(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        int length = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    int left = j - 1 >= 0 && grid[i][j - 1] == 1 ? 0 : 1;
                    int rigth = j + 1 < grid[i].length && grid[i][j + 1] == 1 ? 0 : 1;
                    int up = i - 1 >= 0 && grid[i - 1][j] == 1 ? 0 : 1;
                    int bottom = i + 1 < grid.length && grid[i + 1][j] == 1 ? 0 : 1;
                    length += left + rigth + up + bottom;
                }
            }
        }
        return length;
    }
}