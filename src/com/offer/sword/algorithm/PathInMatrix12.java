package com.offer.sword.algorithm;

import org.junit.Test;

/**
 * 通过回溯法确定 一个矩阵中是否含有一条包含某字符串全部字符的路径。
 */
public class PathInMatrix12 {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (str == null || matrix == null) {
            return false;
        }
        char[][] newM = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                newM[i][j] = matrix[i * cols + j];
            }
        }
        boolean[][] visited = new boolean[rows][cols];
        for (int i = 0; i < newM.length; i++) {
            for (int j = 0; j < newM[0].length; j++) {
                if (helper(newM, visited, 0, str, i, j)) {
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
    private boolean helper(char[][] matrix, boolean[][] visited, int strIndex, char[] str, int x, int y) {
        if (strIndex == str.length) {
            return true;
        }
        if (x >= matrix.length || y >= matrix[0].length || x < 0 || y < 0 || visited[x][y]) {
            return false;
        }
        boolean hasPath = false;
        if (matrix[x][y] == str[strIndex]) {
            visited[x][y] = true;
            strIndex++;
            hasPath = helper(matrix, visited, strIndex, str, x - 1, y)
                    || helper(matrix, visited, strIndex, str, x + 1, y)
                    || helper(matrix, visited, strIndex, str, x, y - 1)
                    || helper(matrix, visited, strIndex, str, x, y + 1);
            // 此路不通，需要将记录访问置为未访问，不影响下一趟回溯结果
            if (!hasPath) {
                strIndex--;
                visited[x][y] = false;
            }
        }

        return hasPath;
    }

    @Test
    public void test() {
        char[] matrix = "ABCEHJIGSFCSLOPQADEEMNOEADIDEJFMVCEIFGGS".toCharArray();
        boolean res = hasPath(matrix, 5, 8, "SLHECCEIDEJFGGFIE".toCharArray());
        System.out.println(res);
    }
}