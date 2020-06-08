package com.leetcode.backtrace;

import java.util.Arrays;

import org.junit.Test;

public class Coin322 {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        minCount = amount / coins[0];
        return backtrace(coins, amount, 0);
    }

    int minCount;

    private int backtrace(int[] coins, int amount, int count) {
        if (amount == 0) {
            return count;
        }
        for (int i = coins.length - 1; i >= 0; i--) {
            if ((minCount - count) * coins[i] < amount) {
                break;
            }
            if (amount >= coins[i]) {
                minCount = Math.min(backtrace(coins, amount - coins[i], count + 1), minCount);
            }
        }
        return minCount == Integer.MAX_VALUE ? -1 : minCount;
    }

    @Test
    public void test() {
        int res = coinChange(new int[] { 2 }, 3);
        System.out.println(res);
    }
}