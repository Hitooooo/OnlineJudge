package com.leetcode.offer.sword;

import org.junit.Test;

public class Solution12 {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length < 1 || word == null || word.length() < 1) {
            return false;
        }
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (find(board, visited, word.toCharArray(), 0, i, j)) {
                    return true;
                }
            }
        }

        return false;

    }

    private boolean find(char[][] board, boolean[][] visited, char[] word, int index, int x, int y) {
        if (board[x][y] == word[index] && !visited[x][y]) {
            visited[x][y] = true;
            if (index + 1 == word.length) {
                return true;
            }
            boolean left = y > 0 && find(board, visited, word, index + 1, x, y - 1);
            boolean right = y < board[0].length - 1 && find(board, visited, word, index + 1, x, y + 1);
            boolean top = x > 0 && find(board, visited, word, index + 1, x - 1, y);
            boolean bottom = x < board.length - 1 && find(board, visited, word, index + 1, x + 1, y);
            visited[x][y] = false;
            return left || right || top || bottom;
        }
        return false;
    }

    @Test
    public void test() {
        boolean res = exist(new char[][] { { 'a', 'b' }, { 'c', 'd' } }, "acdb");
        System.out.println(res);
    }
}