package com.leetcode.readily;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class ExcelCol168 {
    public String mapping(int col) {
        char A = 'A';
        Map<Integer, Character> map = new HashMap<>();
        for (char i = A; i <= 'Z'; i++) {
            map.put(i - 65, i);
        }
        String res = "";
        while (col > 0) {
            col -= 1;
            int k = col % 26;
            res = map.get(k) + res;
            col = col / 26;
        }
        return  res;
    }
    // TODO 借1法
    
    @Test
    public void test() {
        String res = mapping(52);
        System.out.println(res);
    }
}