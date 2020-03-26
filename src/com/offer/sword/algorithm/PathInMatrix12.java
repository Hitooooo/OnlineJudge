package com.offer.sword.algorithm;

import java.util.Arrays;

import org.junit.Test;

/**
 * 通过回溯法确定 一个矩阵中是否含有一条包含某字符串全部字符的路径。
 */
public class PathInMatrix12 {
    public boolean hasPath(char[][] matrix, String str) {
        if (str == null || matrix == null) {
            return false;
        }
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (helper(matrix, visited, 0, str, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 
     * @param matrix   搜索矩阵
     * @param visited  记录访问过的位置
     * @param strIndex 字符串中下一个带搜索下标
     * @param str      某字符串
     * @return 是否
     */
    private boolean helper(char[][] matrix, boolean[][] visited, int strIndex, String str, int x, int y) {
        if(strIndex == str.length()){
            return true;
        }
        if (x >= matrix.length || y >= matrix[0].length || x < 0 || y < 0 || visited[x][y]) {
            return false;
        }
        visited[x][y] = true;
        if(matrix[x][y] != str.charAt(strIndex)){
            return false;
        }
        strIndex++;

        return helper(matrix, visited, strIndex, str, x - 1, y) || helper(matrix, visited, strIndex, str, x + 1, y)
                || helper(matrix, visited, strIndex, str, x, y - 1) || helper(matrix, visited, strIndex, str, x, y + 1);
    }

    @Test
    public void test(){
        char[][] matrix = {{'a','b','c'},{'d','e','f'},{'g','h','i'}};
        boolean res = hasPath(matrix, "acf");
        System.out.println(res);
    }
}