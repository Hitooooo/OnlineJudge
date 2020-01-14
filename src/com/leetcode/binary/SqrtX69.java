package com.leetcode.binary;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * 计算并返回 x 的平方根，其中 x 是非负整数。 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * 
 * @author hitomeng
 * @date 2020/01/14
 */
public class SqrtX69 {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        int left = 1;
        int right = x / 2;
        while (left < right) {
            int mid = (left + right + 1) >> 1;
            if (x / mid < mid) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }

        return left;
    }

    @Test
    public void test() {
        assertEquals(mySqrt(2147395599), 46339);
        assertEquals(mySqrt(8), 2);
    }
}