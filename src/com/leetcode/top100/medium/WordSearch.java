package com.leetcode.top100.medium;

import org.junit.Test;

/**
 * Given a 2D board and a word, find if the word exists in the grid. The word
 * can be constructed from letters of sequentially adjacent cell, where
 * "adjacent" cells are those horizontally or vertically neighboring. The same
 * letter cell may not be used more than once.
 * 
 * @author hitomeng
 * @since 2019/09/17
 */
public class WordSearch {

  /**
   * 1.从每个位置开始都查找一次 2.使用回溯法，当前层处理后，将部分结果保存后，再进入下一层
   * 3.所有字符只能使用一次，那么需要在下一层计算的时候将board中的使用过字符设置为不可用 board[x][y] ^= 256
   */
  public boolean exist(char[][] board, String word) {
    char[] wordChars = word.toCharArray();
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (exist(board, i, j, wordChars, 0)) {
          return true;
        }
      }
    }
    return false;
  }

  /**
   * 
   * 
   * @param board 搜索范围
   * @param x     横坐标
   * @param y     纵坐标
   * @param word  待搜索词
   * @param index 带搜索字符
   * @return 是否找到
   */
  public boolean exist(char[][] board, int x, int y, char[] word, int index) {
    if (index == word.length) {
      return true;
    }
    if (x < 0 || y < 0 || x > board.length - 1 || y > board[x].length - 1) {
      return false;
    }
    if (board[x][y] != word[index]) {
      return false;
    }
    board[x][y] ^= 256;
    boolean exist = exist(board, x + 1, y, word, index + 1) 
                    || exist(board, x, y + 1, word, index + 1)
                    || exist(board, x - 1, y, word, index + 1) 
                    || exist(board, x, y - 1, word, index + 1);
    board[x][y] ^= 256;
    return exist;
  }

  @Test
  public void test() {
    char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
    boolean has = exist(board, "ABCCED");
    System.out.println(has);
  }
}