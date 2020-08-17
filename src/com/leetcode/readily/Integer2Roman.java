package com.leetcode.readily;

import java.util.*;

/**
 * 整数转罗马数字
 *
 * @author htmeng
 * @date 2020/8/17
 */
public class Integer2Roman {

    private String int2Roman(int val) {
        if (val < 0) {
            return "";
        }
        Map<Integer, String> dic = new TreeMap<>((o1, o2) -> o2 - o1);
        dic.put(1, "I");
        dic.put(5, "V");
        dic.put(10, "X");
        dic.put(50, "L");
        dic.put(100, "C");
        dic.put(500, "D");
        dic.put(1000, "M");
        dic.put(4, "IV");
        dic.put(9, "IX");
        dic.put(40, "XL");
        dic.put(90, "XC");
        dic.put(400, "CD");
        dic.put(900, "CM");


        return "";
    }
}
