package com.leetcode.top100.medium;

/**
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性： 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 * 
 * @author hitomeng
 * @date 2019/10/17
 */
public class SearchIn2DMatrix {
    /**
     * 这个数组是由很强的规律性的，如果我们能找到合适的遍历起点，就可以事半功倍. 从右上角开始遍历，大了就往左，小了就往下
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int x = 0;
        int y = matrix[0].length - 1;
        while (x < matrix.length && y >= 0 && matrix[x][y] != target) {
            if (matrix[x][y] > target) {
                y--;
            } else if (matrix[x][y] < target) {
                x++;
            } else {
                return true;
            }
        }

        return x < matrix.length && y >= 0 && matrix[x][y] == target;
    }

    public boolean searchMatrixOptimize(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int x = 0;
        int y = matrix[0].length - 1;
        while (x < matrix.length && y >= 0) {
            if (matrix[x][y] > target) {
                y--;
            } else if (matrix[x][y] < target) {
                x++;
            } else {
                return true;
            }
        }

        return false;
    }
}