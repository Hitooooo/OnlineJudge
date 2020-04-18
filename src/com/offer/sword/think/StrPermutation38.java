package com.offer.sword.think;

import java.util.ArrayList;
import java.util.TreeSet;
import java.util.Set;

import org.junit.Test;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 
 * @author hitomeng
 * @date 2020-04-18 21:04:34
 */
public class StrPermutation38 {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        if (str == null || str.length() < 1) {
            return res;
        }
        // 保持有序
        TreeSet<String> set = new TreeSet<>();
        permutation(str.toCharArray(), 0, set);
        res.addAll(set);
        return res;
    }

    /**
     * 把字符分成两个部分，第一个字符和第一个字符之后的所有字符
     * 第一步是求所有可能出现在第一个位置的字符，即把第一个字符和后面所有字符交换
     * 第二步是固定住第一个字符，求后面所有字符的排列
     *  
     * 其中求第二个部分搜索排列又是跟原问题相同的子问题，递归。
     * @param chars 需要排列的字符数组
     * @param i 第一个字符（当前问题或者子问题）
     * @param set TreeSet 保证顺序
     */
    private void permutation(char[] chars, int i, Set<String> set) {
        if (i == chars.length) {
            return;
        }
        if (i == chars.length - 1) {
            // 第二部分没有了，直接把当前的排列加入
            set.add(new String(chars));
        } else {
            // 循环加交换，实现不同的字符在第一位
            for (int j = i; j <= chars.length - 1; j++) {
                swip(chars, i, j);
                // 再排列后面的可能情况
                permutation(chars, i + 1, set);
                // 重排后恢复顺序，保证不影响另一个字符换到第一位时的可能情况
                swip(chars, j, i);
            }
        }
    }

    private void swip(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    @Test
    public void test() {
        ArrayList<String> res = Permutation("ABC");
        System.out.println(res);
    }
}