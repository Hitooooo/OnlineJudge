package com.leetcode.dp;

import org.junit.Test;

public class Solution10 {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        int n = s.length();
        int w = p.length();
        if (p.length() == 0) {
            return s.length() == 0;
        }
        boolean[][] dp = new boolean[n + 1][w + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < w + 1; j++) {
                if (j == 0) {
                    dp[i][j] = i == 0;
                } else if (p.charAt(j - 1) == '*') {
                    if ( j >= 2 && i >= 1 &&  (p.charAt(j - 2) == '.' || p.charAt(j - 2) == s.charAt(i - 1))) {
                        dp[i][j] =  dp[i - 1][j] || dp[i][j - 2];
                    } else {
                        dp[i][j] = j >= 2 && dp[i][j - 2];
                    }
                } else {
                    dp[i][j] = (p.charAt(j - 1) == '.' && (i >= 1 && dp[i - 1][j - 1]))
                            || (i >= 1 && s.charAt(i - 1) == p.charAt(j - 1) && dp[i - 1][j - 1]);
                }
            }
        }
        return dp[n][w];
    }

    @Test
    public void test() {
        boolean res = isMatch("aa", ".*");
        System.out.println(res);
    }
}