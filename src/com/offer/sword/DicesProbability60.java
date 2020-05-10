package com.offer.sword;

import java.util.Arrays;

import org.junit.Test;

/**
 * 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这
 * n 个骰子所能掷出的点数集合中第 i 小的那个的概率
 * 
 * @author hitomeng
 * @date 2020-05-10 14:17:19
 */
public class DicesProbability60 {

    /**
     * dp[n][j] = dp[n][j] + dp[n-1][j-i] 第N个色子可能出现点数j（指的是N个色子的点数和，不是单个色子）的个数 加等于
     * 第N-1个色子出现j-i的个数。其中i为1到6，当前色子可能出现的面
     */
    public double[] solution(int n) {
        if (n < 1) {
            return null;
        }
        int[][] dp = new int[n + 1][6 * n + 1];
        for (int i = 1; i <= 6; i++) {
            dp[1][i] = 1;
        }
        // n个色子
        for (int i = 2; i <= n; i++) {
            // 当前色子会出现的点数和 从 n到 6n
            for (int j = i; j <= 6 * i; j++) {
                // 出现的个数由上一个色子决定
                for (int curr = 1; curr <= 6; curr++) {
                    // 点数不可能由上一个组成，直接结束
                    if (j - curr <= 0) {
                        break;
                    }
                    dp[i][j] += dp[i - 1][j - curr];
                }
            }
        }
        double all = Math.pow(6, n);
        double[] res = new double[6 * n - n + 1];
        for (int i = 0; i < res.length; i++) {
            res[i] = dp[n][n + i] / all;
        }
        return res;
    }

    @Test public void test(){ 
        System.out.println(Arrays.toString(solution(2)));
    }
}