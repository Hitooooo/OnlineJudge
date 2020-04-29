package com.offer.sword.efficiency;

import org.junit.Test;

/**
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回
 * -1（需要区分大小写）.（从0开始计数）
 * 
 * @author hitomeng
 * @date 2020-04-29 16:18:57
 */

public class FirstNotRepeatingChar50 {
    public int firstNotRepeatingChar(String str) {
        if (str == null || str.length() == 0) {
            return -1;
        }
        int[] map = new int[256];
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            map[chars[i]] += 1;
        }
        for (int i = 0; i < chars.length; i++) {
            if (map[chars[i]] == 1) {
                return i;
            }
        }
        return -1;
    }

    @Test
    public void test() {
        int i = firstNotRepeatingChar("1233216@$%6");
        System.out.println(i);
    }
}