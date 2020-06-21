package com.leetcode.offer.sword;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import javax.sound.sampled.SourceDataLine;

import com.offer.sword.quality.Regex19;

import org.junit.Test;

/**
 * 请实现一个函数用来匹配包含'. '和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"和"ab*a"均不匹配。
 */
public class Soltion19 {

    public boolean isMatchDp(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        int n = s.length();
        int w = p.length();
        if (w == 0) {
            return n == 0;
        }
        boolean[][] dp = new boolean[n + 1][w + 1];
        for (int i = 0; i < dp.length; i++) {
            // 匹配串为空，待匹配不为空，必定不匹配 但同时为空满足
            dp[i][0] = i == 0;
        }
        for (int i = 0; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (p.charAt(j - 1) != '*') {
                    if ((i >= 1 && j >= 1) && (p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i - 1))) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                } else {
                    // 如果p当前是*

                    // 分为两种情况，满足一种情况即可。
                    if (i > 0 && j >= 2 && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j -2 ) == '.')) {
                        // 尝试使用星号匹配。若当前匹配，即p【*】前一位是【.】或前一位相同，那么由于多个匹配s=s[i-1]的匹配情况
                        dp[i][j] |= dp[i - 1][j];
                    } 
                    if (j >= 2) {
                        // 不适用星号，认为星号前字符个数为0，期望上一组匹配
                        dp[i][j] |= dp[i][j - 2];
                    }
                }
            }
        }
        return dp[n][w];
    }

    public boolean isMatch(String s, String p) {
        return isMatch2(s.toCharArray(), p.toCharArray(), 0, 0);
    }

    /**
     * 
     * @param s target
     * @param p pattern
     * @param i target start index
     * @param j pattern start index
     */
    private boolean isMatch2(char[] s, char[] p, int i, int j) {
        if (j == p.length && i == s.length) {
            return true;
        }
        // 让匹配字符走到低即可
        if (j == p.length && i != s.length) {
            return false;
        }
        /*
         * if (i == s.length && j != p.length) { return false; }
         */
        // p下一个的下一个字符是否是*，
        // 如果是，看当前是否匹配。不匹配，i不变
        // 如果不是，当前匹配就下一轮，否则false

        if (j < p.length - 1 && p[j + 1] == '*') {
            if (i < s.length && (s[i] == p[j] || p[j] == '.')) {
                // 当前
                return isMatch2(s, p, i, j + 2) || isMatch2(s, p, i + 1, j + 2) || isMatch2(s, p, i + 1, j);
            } else {
                // 如果不相等，也不是'.',期望后面存在*，覆盖掉本次不匹配
                return isMatch2(s, p, i, j + 2);
            }
        } else if (i < s.length && (p[j] == '.' || s[i] == p[j])) {
            return isMatch2(s, p, i + 1, j + 1);
        }

        return false;
    }

    @Test
    public void test() {
        // boolean res = isMatch("mississippi", "mis*is*p*.");
        // System.out.println(res);
        boolean resDp = isMatchDp("aaa", "ab*a*c*a");
        System.out.println(resDp);
        // boolean res2 = isMatch("aab", "c*a*b");
        // System.out.println(res2);
        // Regex19 regex = new Regex19();
        // boolean res3 = regex.match("mmississippi".toCharArray(),
        // "mis*is*p*".toCharArray());
        // System.out.println(res3);
    }
}