package com.leetcode.readily;

import org.junit.Test;

import java.util.HashMap;

/**
 * 罗马符号转数字
 *
 * @author htmeng
 * @date 2020/8/17
 */
public class Roman2Integer {

    public int romanToInt(String s) {
        HashMap<String, Integer> dic = new HashMap<>();
        dic.put("I", 1);
        dic.put("V", 5);
        dic.put("X", 10);
        dic.put("L", 50);
        dic.put("C", 100);
        dic.put("D", 500);
        dic.put("M", 1000);
        dic.put("IV", 4);
        dic.put("IX", 9);
        dic.put("XL", 40);
        dic.put("XC", 90);
        dic.put("CD", 400);
        dic.put("CM", 900);


        char[] chars = s.toCharArray();
        int sum = 0;
        for (int i = 0; i < chars.length; i++) {
            String singleKey = chars[i] + "";
            StringBuilder doubleKey = new StringBuilder();
            if (i + 1 < chars.length) {
                doubleKey.append(chars[i]).append(chars[i + 1]);
            }
            if (dic.containsKey(doubleKey.toString())) {
                sum += dic.get(doubleKey.toString());
                i++;
            } else {
                sum += dic.get(singleKey);
            }
        }
        return sum;
    }

    @Test
    public void test(){
        System.out.println(romanToInt("LVIII"));
    }
}
