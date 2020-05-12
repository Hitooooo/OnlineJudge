package com.offer.sword;

import org.junit.Test;

/**
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
 * 
 * @author hitomeng
 * @date 2020-05-12 21:27:59
 */
public class StrToInt67 {

    public int str2Int(String str) {
        if (str == null) {
            return 0;
        }
        str = str.trim();
        if (str.length() < 1) {
            return 0;
        }
        int len = str.length();
        int i = 0;
        boolean nagitive = false;
        int limit = -Integer.MAX_VALUE;
        char[] s = str.toCharArray();
        char firstChar = s[0];
        if (firstChar < '0') {
            if (firstChar == '-') {
                nagitive = true;
                limit = Integer.MIN_VALUE;
            } else if (firstChar != '+') {
                return 0;
            }
            if (len == 1) {
                return 0;
            }
            i++;
        }
        int res = 0;
        int multmin = limit / 10;
        boolean isOver = false;
        while (i < len) {
            int val = s[i++] - '0';
            if (val > 9 || val < 0) {
                break;
            }
            // 溢出。multmin除以10，为了下面的每次乘10做准备
            if (res < multmin) {
                isOver = true;
                break;
            }
            res = res * 10;
            // 超出范围 一定不能是 res - val < limit 因为如果溢出了，就一定不满足小于。程序错误!
            if (res < limit + val) {
                isOver = true;
                break;
            }
            res -= val;
        }
        if (isOver) {
            return nagitive ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
        return nagitive ? res : -res;
    }

    @Test
    public void test() {
        int res = str2Int("42");
        System.out.println(res);
    }
}