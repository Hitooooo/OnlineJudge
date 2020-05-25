package com.leetcode.offer.sword;

import org.junit.Test;

/**
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，
 * 它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。 例如，当k为18时，机器人能够进入方格
 * [35,37] ，因为3+5+3+7=18。 但它不能进入方格 [35, 38]，因为3+5+3+8=19。 请问该机器人能够到达多少个格子？
 */
public class Solution13 {
    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        return move(m, n, 0, 0, k, visited);
    }

    private int move(int m, int n, int x, int y, int k, boolean[][] visited) {
        int count = 0;
        if (x < 0 || y < 0 || x > m - 1 || y > n - 1) {
            return count;
        }
        if (isCellOk(x, y, k) && !visited[x][y]) {
            visited[x][y] = true;
            count = 1 + move(m, n, x - 1, y, k, visited) + move(m, n, x + 1, y, k, visited)
                    + move(m, n, x, y - 1, k, visited) + move(m, n, x, y + 1, k, visited);
        }
        return count;
    }

    private boolean isCellOk(int m, int n, int k) {
        int sum = 0;
        while (m > 0) {
            sum += m % 10;
            m = m / 10;
        }
        while (n > 0) {
            sum += n % 10;
            n = n / 10;
        }
        return sum <= k;
    }

    @Test
    public void test() {
        System.out.println(movingCount(3, 1, 0));
    }

}