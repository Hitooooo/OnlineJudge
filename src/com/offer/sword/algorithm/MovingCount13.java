package com.offer.sword.algorithm;

import org.junit.Test;

/**
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 =
 * 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 * 
 * @author hitomeng
 * @date 2020年3月28日 20:56:29
 */
public class MovingCount13 {
    /**
     * 
     * @return
     */
    private int movingCount(int threshold, int rows, int cols) {
        if (threshold < 0 || rows <= 0 || cols <= 0) {
            return 0;
        }
        boolean[] visited = new boolean[rows * cols];
        for (int i = 0; i < rows * cols; i++) {
            visited[i] = false;
        }
        int count = backtrace(visited, threshold, rows, cols, 0, 0);
        return count;
    }

    /**
     * 可用数量 = 当前是否可用 + 上下左右可用。用一个数组记录访问过的位置，防止重复计数。
     * @param visited
     * @param threshold
     * @param rows
     * @param cols
     * @param startX
     * @param startY
     * @return
     */
    private int backtrace(boolean[] visited, int threshold, int rows, int cols, int startX, int startY) {
        if (startX < 0 || startY < 0 || startX >= rows || startY >= cols) {
            return 0;
        }
        int count = 0;
        if (available(visited, threshold, rows, cols, startX, startY)) {
            visited[startX * cols + startY] = true;
            count = 1 + backtrace(visited, threshold, rows, cols, startX + 1, startY)
                    + backtrace(visited, threshold, rows, cols, startX - 1, startY)
                    + backtrace(visited, threshold, rows, cols, startX, startY + 1)
                    + backtrace(visited, threshold, rows, cols, startX, startY - 1);
        }
        return count;
    }

    private boolean available(boolean[] visited, int threshold, int rows, int cols, int x, int y) {
        boolean res =  x >= 0 && x < rows && y >= 0 && y < cols && !visited[x * cols + y]
                && (getDigitSum(x) + getDigitSum(y) <= threshold);
        System.out.println(String.format("x=%s,y=%s,threshold=%s,可用=%b", x, y,threshold,res));
        return res;
    }

    private int getDigitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num = num / 10;
        }
        return sum;
    }

    @Test
    public void test() {
        int count = movingCount(15, 100, 1);
        System.out.println(count);
    }
}