package com.offer.sword.quality;

import java.math.BigDecimal;

import org.junit.Test;

/**
 * 判断字符串是否是数值
 */
public class IsNumbericString20 {
    public boolean isNumberic(char[] str) {
        try {
            BigDecimal bd = new BigDecimal(str);
            System.out.println(bd.toString());
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Test
    public void test() {
        isNumberic("100".toCharArray());
    }
}
