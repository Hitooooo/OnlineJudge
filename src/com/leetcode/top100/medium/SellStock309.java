package com.leetcode.top100.medium;

/**
 * 最佳买卖股票时间.在满足以下约束条件下，你可以尽可能地完成更多的交易. 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 
 * @author hitomeng
 * @date 2019/10/28
 */
public class SellStock309 {

    /**
     * dp.i:第i天，k：可用交易数 0/1:持有或不持有 dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] +
     * prices[i]) dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
     * 
     * 对于此题，卖出后会被冷冻。递推公式如下： dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1]
     * +prices[i]) dp[i][k][1] = max(dp[i-1][k][1], dp[i-2][k-1][0] - prices[i])
     * 尽可能多的交易，可以不考虑K dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i]) dp[i][1]
     * =max(dp[i-1][1], dp[i-2][0] - prices[i])
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int length = prices.length;
        int[][] dp = new int[length + 1][2];
        // 还没有开始买卖，未持有的价值为0，-无穷表示持有
        dp[0][0] = 0;
        dp[0][1] = Integer.MIN_VALUE;
        // 第一天，持有的话，只有买入
        dp[1][0] = Math.max(dp[0][0], dp[0][1] + prices[0]);
        dp[1][1] = Math.max(dp[0][1], 0 - prices[0]);
        for (int i = 2; i < dp.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i - 1]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i - 1]);
        }
        // 最后肯定是不持有才是最大值
        return dp[dp.length - 1][0];
    }
}