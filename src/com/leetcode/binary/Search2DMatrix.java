package com.leetcode.binary;

import org.junit.Test;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties: Integers in each row are sorted
 * from left to right. The first integer of each row is greater than the last
 * integer of the previous row.
 * 
 * @author hitomeng
 * @date 2020/01/15
 */
public class Search2DMatrix {
    /**
     * 虽然是二维数组，但是可以展开成一维看待.那么就成了 0 -> m*n-1的一维数组。
     * 时间复杂度log2(m+n)
     * 
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = n * m - 1;
        while (left < right) {
            int mid = (left + right) >> 1;
            int col = mid % n;
            int row = mid / n;
            if (matrix[row][col] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return matrix[left / n][left % n] == target;
    }

    @Test
    public void test(){
        int[][] arr = {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
        boolean r = searchMatrix(arr, 55);
        System.err.println(r);
    }
}