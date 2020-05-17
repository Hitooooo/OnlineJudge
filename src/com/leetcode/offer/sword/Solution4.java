package com.leetcode.offer.sword;

import org.junit.Test;

/**
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数
 */
public class Solution4 {

    /**
     * 从右上或者左下角开始遍历
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return false;
        }
        int row = matrix.length;
        int column = matrix[0].length;
        int x = 0;
        int y = matrix.length - 1;
        while (x < column && y >= 0) {
            if (matrix[y][x] == target) {
                return true;
            } else if (matrix[y][x] < target) {
                x++;
            } else {
                y--;
            }
        }
        return false;
    }

    @Test
    public void test(){
        boolean res = findNumberIn2DArray(new int[][]{{1,1}}, 2);
        System.out.println(res);
    }
}