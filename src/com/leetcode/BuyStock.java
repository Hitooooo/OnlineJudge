package com.leetcode;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock),
 * design an algorithm to find the maximum profit.Note that you cannot sell a stock before you buy one.
 * <p>
 * Input: [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Not 7-1 = 6, as selling price needs to be larger than buying price.
 *
 * @author HitoM
 * @date 2019/4/8 16:31
 */
public class BuyStock {
    /**
     * 动态规划
     * f(n) = Max(f(n-1), prices[n] - min(prices[0], prices[n-1]))
     */
    public static int maxProfit(int[] prices) {
        // 边界值
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int result = 0;
        int min = prices[0];

        for (int price : prices) {
            min = Math.min(min, price);
            result = Math.max(result, price - min);
        }

        return result;
    }
}
