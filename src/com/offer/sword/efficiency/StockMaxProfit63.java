package com.offer.sword.efficiency;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 */
public class StockMaxProfit63 {

    /**
     * 问题用一句话解释，从数组中找到差值最大的一组数。
     * 一个数记录遍历过元素中最小值，一个数记录遍历过元素中最大差值。
     * 遍历时更新两个值即可
     */
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2){
            return 0;
        }

        int minVal = prices[0];
        int maxDiff = 0;
        for (int i = 1; i < prices.length; i++) {
            int currentDiff = prices[i] - minVal;
            if(currentDiff > maxDiff){
                maxDiff = currentDiff;
            }
            if(prices[i] < minVal){
                minVal = prices[i];
            }
        }
        return maxDiff;
    }

    @Test
    public void test(){
        assertEquals(5, maxProfit(new int[]{7,1,5,3,6,4}));
        assertEquals(0, maxProfit(new int[]{7,6,4,3,1}));
    }
}