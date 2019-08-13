package com.leetcode.top100.medium;

import java.util.LinkedList;
import java.util.List;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 *
 * @author HitoM
 * @date 2019/8/13 23:09
 **/
public class LetterCombinations {

    /**
     * 链表保存前一个数字的可能的数字关系，下一个数字获取后拼接自己可能的字母。
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        LinkedList<String> result = new LinkedList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        result.add("");
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        for (int i = 0; i < digits.length(); i++) {
            int index = Character.getNumericValue(digits.charAt(i));
            while (result.peek().length() == i) {
                // 获取前一个数字对应字母
                String remove = result.remove();
                for (char c : mapping[index].toCharArray()) {
                    result.add(remove + c);
                }
            }
        }
        return result;
    }
}
