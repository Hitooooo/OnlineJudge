package com.leetcode.dp;

import org.junit.Test;

public class Solution647 {
    public int countSubstrings(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }
        int n = s.length();
        int res = 0;
        boolean[][] dp = new boolean[n][n];
        // 因为依赖于dp[i+1][j-1]，所以i降序 j增序遍历
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                // 如果s[i] == s[j] 只需要 dp[i+1][j-1]为true 或者（j-i<2)即可。对应 a aa的情况
                if (s.charAt(i) == s.charAt(j) && (j - i < 2 || (j > 0 && i < n - 1 && dp[i + 1][j - 1]))) {
                    dp[i][j] = true;
                    res++;
                }
            }
        }
        return res;
    }

    @Test
    public void test() {
        int res = countSubstrings("aba");
        System.out.println(res);
    }
}