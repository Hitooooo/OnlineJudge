package com.leetcode.readily;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

/**
 * ???????????? Excel ??????????
 * 
 * @author hitomeng
 * @date 2020-04-15 23:29:35
 */
public class ExcelCol168 {

    /**
     * ?????????? 0 ????????? 26 ?????? 26 ? 1?????? 0?????? 26 ???? 26 ???? 27
     * ???????? 1?????? 1??? Z(26) ???????? A(1)A(1)?? 27 ?? AA?
     * 
     * @param n
     * @return
     */
    public String convertToTitle(int n) {
        String res = "";
        while (n > 0) {
            int c = n % 26;
            if (c == 0) {
                // ??????1?
                c = 26;
                n -= 1;
            }
            res = (char) ('A' + c - 1) + res;
            n = n / 26;
        }
        return res;
    }

    /**
     * ?????????????
     * 
     * @param col
     * @return
     */
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
        return res;
    }

    @Test
    public void test() {
        String res = convertToTitle(52);
        System.out.println(res);
    }
}