package com.leetcode.top100.medium;

import java.util.Arrays;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume
 * that the maximum length of s is 1000.
 * 
 * Input: "babad" Output: "bab" Note: "aba" is also a valid answer.
 */
public class LongestPalindrome {

    /**
     * 以每一个字符为单位遍历，向两端同时扩展。 但是如果是偶数位的回文字符串如：abba，无法正确遍历，所以需要在字符中间插入空隙 a#b#b#a
     * 
     * @param s the origin string
     * @return the longest palindrome substring
     */
    public String longestPalindrome(String s) {
        // 边界值
        if (s == null || s.length() <= 1) {
            return s;
        }

        // 插入间隙符号
        char[] cArr = s.toCharArray();
        char[] temp = new char[cArr.length * 2 - 1];
        for (int i = 0; i < cArr.length; i++) {
            temp[i * 2] = cArr[i];
            if (2 * i + 1 < temp.length) {
                temp[2 * i + 1] = '#';
            }
        }

        String result = "";
        // 遍历新数组
        for (int i = 0; i < temp.length; i++) {
            int leftPoint = i;
            int rightPoint = i;
            while (leftPoint >= 0 && rightPoint <= temp.length - 1 && temp[leftPoint] == temp[rightPoint]) {
                leftPoint--;
                rightPoint++;
            }
            String sub = new String(Arrays.copyOfRange(temp, leftPoint + 1, rightPoint));
            String tempMaxSub = sub.replaceAll("#", "");
            if (tempMaxSub.length() > result.length()) {
                result = tempMaxSub;
            }
        }
        return result;
    }
}