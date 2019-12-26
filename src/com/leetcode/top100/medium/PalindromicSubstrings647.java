package com.leetcode.top100.medium;

/**
 * Given a string, your task is to count how many palindromic substrings in this
 * string. The substrings with different start indexes or end indexes are
 * counted as different substrings even they consist of same characters.
 * 
 * @author hitomeng
 * @date 2019/12/26
 */
public class PalindromicSubstrings647 {

    public int dp(String s) {
        if (s == null) {
            return 0;
        }
        if(s.length() <= 1){
            return s.length();
        }
        int count = 0;
        // 二维数据，dp[i][j]表示i到j是否是回文子串
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
           for(int j = i;j>=0;j--){
                if(s.charAt(i)==s.charAt(j) && (i-j<2||dp[j+1][i-1])){
                    dp[j][i] = true;
                    count++;
                }
           } 
        } 
        return count;
    }

    /**
     * 统计回文子串的个数.回忆最长回文子串。 单个字符也是一个回文子串，那就遍历每一个字符，然会向两边扩张。注意由于aa
     * bb这样的回文存在，不仅需要遍历字符，还要遍历中间 两个字符中间的位置总共 n + n - 1 = 2n-1.
     */
    public int countSubstrings(String s) {
        if (s == null || s.length() <= 1) {
            return s.length();
        }
        int n = s.length();
        int count = 0;
        for (int i = 0; i <= 2 * n - 1; i++) {
            int left = i / 2; // 保证下标在字母上，而不是空格上，相比较插入一个符号，这更聪明，但是不容易想到
            int right = left + i % 2;
            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                count++;
                left--;
                right++;
            }
        }
        return count;
    }
}