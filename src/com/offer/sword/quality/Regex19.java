package com.offer.sword.quality;


import org.junit.Test;

/**
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 * 
 * @author hitomeng
 * @date 2020-04-04 17:39:02
 */
public class Regex19 {

    /**
     * 
     * 
     * @param str     target
     * @param pattern 模式串
     * @return 是否匹配
     */
    public boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null) {
            return false;
        }
        return matchRecursive(str, pattern, 0, 0);
    }

    /**
     * 递归判断字符是否匹配
     * 
     * @param str     target
     * @param pattern 模式串
     * @param i       带验证字符指针
     * @param j       模式串中待匹配字符指针
     * @return true if match
     */
    private boolean matchRecursive(char[] str, char[] pattern, int i, int j) {
        if (i == str.length && j == pattern.length) {
            return true;
        }

        if (i != str.length && j == pattern.length) {
            return false;
        }

        // 如果下一个字符是*号，表示待匹配串当前可不匹配或者匹配多次
        // 我们可以分匹配和不匹配两种情况讨论
        if (j < pattern.length - 1 && pattern[j + 1] == '*') {
            if (i < str.length && (str[i] == pattern[j] || pattern[j] == '.')) {
                return matchRecursive(str, pattern, i, j + 2) // 忽略当前待匹配a*，也许会满足下一轮匹配
                        || matchRecursive(str, pattern, i + 1, j + 2)// 已满足匹配串需要，进入下一个待匹配
                        || matchRecursive(str, pattern, i + 1, j); // 以满足匹配串需要，但是也许匹配多个
            } else {
                return matchRecursive(str, pattern, i, j + 2);
            }
        }
        // 如果下一个字符不是*
        // 匹配
        if (i < str.length && (str[i] == pattern[j] || pattern[j] == '.')) {
            return matchRecursive(str, pattern, i + 1, j + 1);
        }
        return false;
    }

    @Test
    public void test(){
        boolean res = match("aaa".toCharArray(), "ab*ac*a".toCharArray());
        System.out.println(res);
    }

}