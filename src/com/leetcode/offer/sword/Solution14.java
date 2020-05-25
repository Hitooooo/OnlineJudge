package com.leetcode.offer.sword;

import org.junit.Test;

/**
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1）， 每段绳子的长度记为 k[0],k[1]...k[m-1]
 * 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 */
public class Solution14 {
    public int cuttingRope(int n) {
        if (n <= 0) {
            return n;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 4; i <= n; i++) {
            int max = 0;
            for (int j = 1; j <= i / 2; j++) {
                int temp = dp[j]*dp[i-j];
                if(temp > max){
                    max = temp;
                }
            }
            dp[i]=max;
        }
        return dp[n];
    }

    @Test
    public void test(){
        System.out.println(cuttingRope(10));
    }
}