package com.leetcode.dp;

import org.junit.Test;

/**
 * 股票问题 https://labuladong.gitbook.io/algo/dong-tai-gui-hua-xi-lie/tuan-mie-gu-piao-wen-ti
 *
 * @author HitoM
 * @date 2020/7/14 10:53
 **/
public class Stock {

    /**
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
     * <p>
     * 定义三维数组 dp[i][k][x] i表示天数 k表示可买卖次数 x表示当前股票状态持有或未持有两种状态
     * dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i]) // 昨天未持有；昨日持有今天卖了，昨日可用的k减一
     * dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])  // 昨天就持有；昨天未持有，今天买
     * <p>
     * 上面K为什么卖减一，但是买却不，因为买卖一次算一次交易，算其中一个就行
     * <p>
     * base case 怎么定义
     * i=0 dp[0][k][0] = 0 dp[0][k][1] = -无穷
     * k=0 dp[i][k][0] = 0 dp[i][0][1]= -无穷
     *
     * @param prices 股票每日价格
     * @return 最大收益
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int[][] dp = new int[prices.length + 1][2];

        for (int i = 0; i < dp.length; i++) {
            if (i == 0) {
                dp[i][0] = 0;
                dp[i][1] = Integer.MIN_VALUE;
            } else {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i - 1]);
                dp[i][1] = Math.max(dp[i - 1][1], -prices[i - 1]);
            }
        }
        return dp[dp.length - 1][0];
    }

    /**
     * 状态只与相邻有关，无需定义二维数组，优化下空间复杂度
     *
     * @param prices 价格
     * @return 最大收益
     */
    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int dp_0_1 = Integer.MIN_VALUE;
        int dp_0_0 = 0;

        for (int i = 1; i <= prices.length; i++) {
            dp_0_0 = Math.max(dp_0_0, dp_0_1 + prices[i - 1]);
            dp_0_1 = Math.max(dp_0_1, -prices[i - 1]);
        }
        return dp_0_0;
    }

    /**
     * 如果不限制交易次数，可获得的最大收益。我们认为k与k-1的情况可视为相同情况
     * dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
     * dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
     * = max(dp[i-1][k][1], dp[i-1][k][0] - prices[i])
     * 也就是无需关心k
     * dp[i][0] = max(dp[i-1][0], dp[i-1][1]+prices[i])
     * dp[i][1] = max(dp[i-1][1], dp[i-1][0]-prices[i])
     */
    public int maxProfitInfiniteK(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int dp_i_1 = Integer.MIN_VALUE;
        int dp_i_0 = 0;
        for (int i = 1; i <= prices.length; i++) {
            int temp = dp_i_0;
            dp_i_0 = Math.max(temp, dp_i_1 + prices[i - 1]);
            dp_i_1 = Math.max(dp_i_1, temp - prices[i - 1]);
        }
        return dp_i_0;
    }

    /**
     * 如果不限制交易次数，我只需要第二天涨了我就今天买，明天卖。避过降价，命中涨价
     */
    public int maxProfitInfiniteK2(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int money = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1]) {
                money += prices[i + 1] - prices[i];
            }
        }
        return money;
    }

    /**
     * 买卖股票3，指定k为2，只能买卖2次的最大收益
     */
    public int maxProfitKEqualsTwo(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int[][][] dp = new int[prices.length][3][2];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0) {
                    dp[i][j][0] = 0;
                    dp[i][j][1] = -prices[i]; // Math.max(dp[-1][j][1], dp[-1][j - 1][0] - prices[i])
                    continue;
                }
                if (j == 0) {
                    dp[i][j][0] = 0;
                    dp[i][j][1] = Integer.MIN_VALUE;
                    continue;
                }
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }

        return dp[dp.length - 1][2][0];
    }

    /**
     * 买卖股票3，指定k为2，只能买卖2次的最大收益
     */
    public int maxProfitKToBeDefine(int[] prices, int k) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        if (k >= prices.length / 2) {
            // 如果K大于天数的一半，说明可以买一天卖一天，退化成可交易无数次
            return maxProfitInfiniteK2(prices);
        }
        int[][][] dp = new int[prices.length][k + 1][2];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0) {
                    dp[i][j][0] = 0;
                    dp[i][j][1] = -prices[i]; // Math.max(dp[-1][j][1], dp[-1][j - 1][0] - prices[i])
                    continue;
                }
                if (j == 0) {
                    dp[i][j][0] = 0;
                    dp[i][j][1] = Integer.MIN_VALUE;
                    continue;
                }
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }

        return dp[dp.length - 1][k][0];
    }

    /**
     * 最佳买卖股票时机含冷冻期.卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
     * dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
     * 买入的时候， dp[i-2]而不是dp[i-1]
     * dp[i][k][1] = max(dp[i-1][k][1], dp[i-2][k-1][0] - prices[i])
     * 可以交易无数次，那么忽略k的影响
     * <p>
     * dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
     * dp[i][1] = max(dp[i-1][1], dp[i-2][0] - prices[i])
     */
    public int maxProfitCoolDown(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int[][] dp = new int[prices.length][2];
        for (int i = 0; i < dp.length; i++) {
            if (i == 0) {
                dp[i][0] = 0;
                dp[i][1] = -prices[i]; // dp[i][1] = max(dp[i-1][1], dp[i-2][0] - prices[i])
            } else {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                int dp_i_2_0 = i >= 2 ? dp[i - 2][0] : 0;
                dp[i][1] = Math.max(dp[i - 1][1], dp_i_2_0 - prices[i]);
            }
        }
        return dp[dp.length - 1][0];
    }

    /**
     * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。
     * 相当于买入股票的价格升高了
     * dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
     * dp[i][1] = max(dp[i-1][1], dp[i-1][0] - prices[i] - fee)
     */
    public int maxProfitFee(int[] prices, int fee) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int[][] dp = new int[prices.length][2];
        for (int i = 0; i < dp.length; i++) {
            if (i == 0) {
                dp[i][0] = 0;
                dp[i][1] = -prices[i] - fee; // dp[i][1] = max(dp[i-1][1], dp[i-2][0] - prices[i] - fee)
            } else {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i] - fee);
            }
        }
        return dp[dp.length - 1][0];
    }

    @Test
    public void test() {
        int[] arr = {1, 2, 3, 0, 2};
        System.out.println(maxProfitCoolDown(arr));
    }
}
