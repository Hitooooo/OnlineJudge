package com.offer.sword.think;

import java.util.ArrayList;

import org.junit.Test;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12
 * 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 * 
 * @author hitomeng
 * @date 2020-04-05 16:30:10
 */
public class PrintMatrixClock29 {
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length < 1) {
            return res;
        }
        int x = matrix.length;
        int y = matrix[0].length;
        int clockCount = (Math.min(x, y) + 1) / 2;
        int row1 = 0;
        int row2 = x - 1;
        int col1 = 0;
        int col2 = y - 1;
        for (int i = 0; i < clockCount; i++) {
            for (int j = col1; j <= col2; j++) {
                res.add(matrix[row1][j]);
            }
            if (++row1 > row2){
                break;
            } 
            for (int j = row1; j <= row2; j++) {
               res.add(matrix[j][col2]);
            }
            if(--col2 < col1){
                break;
            }
            for (int j = col2; j >= col1; j--) {
               res.add(matrix[row2][j]) ;
            }
            
            if(--row2 < row1){
                break;
            }
            for (int j = row2; j >= row1; j--) {
               res.add(matrix[j][col1]) ;
            }
            if(++col1 > col2){
                break;
            }
        }
        return res;
    }

    @Test    
    public void test(){
        int[][] arr = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] arr2= {{1},{2},{3},{4},{5}};
        System.out.println(printMatrix(arr));
        System.out.println(printMatrix(arr2));
    }
}