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

    /**
     * 动态规划的方式来解 对于起始地址i，结束地址为j的子串，用二维数组dp[i,j]表示，那么 如果 dp[i, j] = dp[i+1, j-1] &
     * s[i]=s[j]; j - i > 1 true ; i == j s[i] == s[j] ; j - i =1
     * 
     * @return
     */
    public String longestDynamic(String s) {
        // 边界值
        if (s == null || s.length() <= 1) {
            return s;
        }

        // 声明备忘录
        boolean[][] dp = new boolean[s.length()][s.length()];

        String result = s.substring(0, 1);
        // 为什么这样不行，i是以来与i+1的，这种写法没有先计算i+1
        /* for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1]);
                if (dp[i][j]) {
                    if (j - i + 1 > result.length()) {
                        result = s.substring(i, j + 1);
                    }
                }
            }
        } */
        for (int j = 0; j < s.length(); j++){
            // 这样，就会先计算 dp[i+1][j-1]
            for (int i = 0; i <= j; i++){
                dp[i][j] = s.charAt(i) == s.charAt(j) &&(j - i <= 2 || dp[i+1][j-1]);
                // 与暂时最长进行比较
                if (dp[i][j]){
                    if (j - i + 1 > result.length()){
                        result = s.substring(i, j + 1);
                    }
                }
            }
        }
        return result;
    }
}