package com.leetcode.top100.medium;

import org.junit.Test;

/**
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 * 
 * @author hitomeng
 * @since 2019/09/18
 */
public class DiffBSTCount {

    /**
     * 找到数字之间的关系，而不是局限于树结构上的问题。 G(n) = f(1)+f(2)+...+f(n); G(n):
     * 长度为n的序列的不同二叉搜索树个数，f(n):以某个数为根节点的二叉排序树个数 f(i) = G(i-1) * G(n-i) G(n) =
     * G(n) = G(0)*G(n-1) + G(1)*G(n-2) +...+G(n-1)*G(0)
     */
    public int numTrees(int n) {
        // 因为下标是从1开始的
        int[] dp = new int[n + 1];
        // 注意0个整数的时候，为空也是一种情况
        // dp[0] = 0;
        dp[0] = 1;
        dp[1] = 1;
        // 求n个数，每个数的可能二叉树个数
        for (int i = 2; i <= n; i++) {
            // 计算G(n) 注释中n = i, 注释中i = j
            for (int j = 1; j <= i; j++) {
                dp[i] = dp[i] + dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }

    @Test
    public void test(){
        System.out.println(numTrees(3));
    }
}