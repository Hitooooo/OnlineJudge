package com.leetcode.top100.medium;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible
 * letter combinations that the number could represent.A mapping of digit to
 * letters (just like on the telephone buttons) is given below. Note that 1 does
 * not map to any letters. 
 * 用递归实现，result(digits) = letters(digits[0]) +
 * result(digits.substring(1)) = ....
 * 
 * @author hitomeng
 * @date 2019/08/13
 */
public class LetterCombination {
  private String[] mapping = new String[] { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

  public List<String> letterCombinations(String digits) {
    ArrayList<String> result = new ArrayList<>();
    if (digits == null || digits.length() == 0) {
      return result;
    }
    return find(digits);
  }

  public List<String> find(String digits) {
    ArrayList<String> result = new ArrayList<>();
    String s = mapping[digits.charAt(0) - '0'];
    if (digits.length() == 1) {
      for (int i = 0; i < s.length(); i++) {
        result.add(s.charAt(i) + "");
      }
      return result;
    } else {
      for (int i = 0; i < s.length(); i++) {
        List<String> next = find(digits.substring(1));
        for (String nextItem : next) {
          result.add(s.charAt(i) + nextItem);
        }
      }
    }
    return result;
  }

  @Test
  public void test(){
    List<String> res = letterCombinations("23");
    System.out.println(res);
  }
}