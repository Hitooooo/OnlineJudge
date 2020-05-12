package com.offer.sword;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 * 
 * @author hitomeng
 * @date 2020-05-11 22:59:16
 */
public class Add65 {
    public int Add(int num1, int num2) {
        int sum = 0;
        int carry = 0;
        do {
            sum = num1 ^ num2;
            carry = (num1 & num2) << 1;

            num1 = sum;
            num2 = carry;
        } while (num2 != 0);
        return sum;
    }

    @Test
    public void test(){
        assertEquals(2, Add(1, 1));
        assertEquals(0, Add(1, -1));
    }
}