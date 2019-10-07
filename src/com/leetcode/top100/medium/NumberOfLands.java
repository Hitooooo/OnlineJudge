package com.leetcode.top100.medium;

import java.util.HashSet;

import org.junit.Test;

/**
 * @author hitomeng
 * @date 2019/10/06
 */
public class NumberOfLands {

    public int numIslands2(char[][] grid) {
        int number = 0;
        if (grid == null || grid.length == 0) {
            return number;
        }
        int[][] status = new int[grid.length][grid[0].length];
        for (int i = 0; i < status.length; i++) {
            for (int j = 0; j < status[i].length; j++) {
                // 发现未探索的格子，带着新岛屿编号去探索。可能新编号未找到岛屿，全部是水，编号还是会增长
                if (status[i][j] == 0) {
                    dfs(i, j, status, grid, ++number);
                }
            }
        }
        // 计算标记正确的岛屿编号个数
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < status.length; i++) {
            for (int j = 0; j < status[i].length; j++) {
                if (status[i][j] > 0) {
                    set.add(status[i][j]);
                }
            }
        }
        return set.size();
    }

    /**
     * 为相连的岛屿编号
     **/ 
    private void dfs(int x, int y, int[][] status, char[][] grid, int number) {
        if (grid[x][y] == '0') {
            status[x][y] = -1;
            return;
        }
        // 没有经过探索，并且是陆地的设置岛屿编号
        if (grid[x][y] == '1') {
            status[x][y] = number;
        }
        if (x - 1 >= 0 && status[x - 1][y] == 0) {
            dfs(x - 1, y, status, grid, number);
        }
        if (x + 1 < grid.length && status[x + 1][y] == 0) {
            dfs(x + 1, y, status, grid, number);
        }
        if (y - 1 >= 0 && status[x][y - 1] == 0) {
            dfs(x, y - 1, status, grid, number);
        }
        if (y + 1 < grid[x].length && status[x][y + 1] == 0) {
            dfs(x, y + 1, status, grid, number);
        }
    }

    /**
     * Wrong anwser
     */
    public int numIslands(char[][] grid) {
        int count = 0;
        if (grid == null || grid.length == 0) {
            return count;
        }
        Type[][] status = new Type[grid.length][grid[0].length];
        for (int i = 0; i < status.length; i++) {
            for (int j = 0; j < status[i].length; j++) {
                status[i][j] = Type.UNKNOW;
            }

        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '0') {
                    status[i][j] = Type.OCEAN;
                    continue;
                } else {
                    status[i][j] = Type.LAND;
                    if ((i - 1 >= 0 && status[i - 1][j] == Type.LAND) || (j - 1 >= 0 && status[i][j - 1] == Type.LAND)
                            || (i + 1 <= grid.length - 1 && status[i + 1][j] == Type.LAND)
                            || (j + 1 <= grid[i].length - 1 && status[i][j + 1] == Type.LAND)) {
                        continue;
                    } else {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    enum Type {
        LAND, OCEAN, UNKNOW
    }

    @Test
    public void test() {
        char[][] arr = { { '1', '0', '1' }, { '0', '0', '0' }, { '1', '1', '1' } };
        int result = numIslands2(arr);
        System.out.println(result);
    }
}