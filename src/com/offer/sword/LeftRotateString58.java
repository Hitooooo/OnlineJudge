package com.offer.sword;

import org.junit.Test;

/**
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它
 * 
 * @author hitomeng
 * @date 2020-05-09 16:02:16
 */
public class LeftRotateString58 {
    public String solution(String str, int n) {
        if (str == null || str.length() < 1) {
            return str;
        }
        int step = n % str.length();
        String tail = str.substring(0, step);
        String head = str.substring(step, str.length());
        // String revStr = reverseStr(tail);
        return head + tail;
    }

    private String reverseStr(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            char temp = chars[i];
            chars[i] = chars[chars.length - i - 1];
            chars[chars.length - i - 1] = temp;
        }
        return new String(chars);
    }

    @Test
    public void test(){
        String s = solution("abcXYZdef", 3);
        System.out.println(s);
    }
}