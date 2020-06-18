package com.leetcode.dp;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Solution1143 {
    public int maxLenSameSubStr(String s1, String s2){
        if(s1 == null || s2 == null){
            return 0;
        }
        int n = s1.length();
        int w = s2.length();
        int[][] dp = new int[n+1][w+1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][w];
    }    

    @Test
    public void test(){
        assertEquals(1, maxLenSameSubStr("abc", "cde"));
    }
}