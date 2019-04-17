package com.leetcode;

import java.util.HashMap;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 *
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 *
 * @author HitoM
 * @date 2019/3/16 21:13
 */
public class LongestSubstring {

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int max = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0, j = 0; i < s.length(); i++) {
            // j代表出现重复时，新的可用起始位置。
            if (map.keySet().contains(s.charAt(i))) {
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - j + 1);
        }

        return max;
    }
}
