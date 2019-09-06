package com.leetcode.top100.medium;

import org.junit.Test;

/**
 * You are given an n x n 2D matrix representing an image. Rotate the image by
 * 90 degrees (clockwise). 顺时针旋转二维数组
 * 
 * @author hitomeng
 * @date 2019/09/06
 */
public class RotateImage {

    /**
     * 顺时针旋转 1. 对换行 2. 转置
     */
    public void rotate(int[][] matrix) {
        int i = 0;
        int j = matrix.length - 1;
        while (i < j) {
            int[] tem = matrix[i];
            matrix[i] = matrix[j];
            matrix[j] = tem;
            i++;
            j--;
        }

        // 转置
        for (int k = 0; k < matrix.length; k++) {
            for (int l = k + 1; l < matrix[0].length; l++) {
                int temp = matrix[k][l];
                matrix[k][l] = matrix[l][k];
                matrix[l][k] = temp;
            }
        }
    }

    /**
     * 逆时针旋转.只需要反转顺时针的操作就行了。Magic！
     * 1. 置换  2. 对换行
     */
    public void antiRotate(int[][] matrix) {
        // 转置
        for (int k = 0; k < matrix.length; k++) {
            for (int l = k + 1; l < matrix[0].length; l++) {
                int temp = matrix[k][l];
                matrix[k][l] = matrix[l][k];
                matrix[l][k] = temp;
            }
        }

        int i = 0;
        int j = matrix.length - 1;
        while (i < j) {
            int[] tem = matrix[i];
            matrix[i] = matrix[j];
            matrix[j] = tem;
            i++;
            j--;
        }
    }

    @Test
    public void test() {
        int[][] arr = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        rotate(arr);
        System.out.println(arr);
        antiRotate(arr);
        System.out.println(arr);
    }
}