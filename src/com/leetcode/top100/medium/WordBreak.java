package com.leetcode.top100.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.junit.Test;

/**
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 * 说明：拆分时可以重复使用字典中的单词。你可以假设字典中没有重复的单词。
 * 
 * @author hitomeng
 * @since 2019/09/23
 */
public class WordBreak {

    public boolean wordBreakDP(String s, List<String> wordDict) {
        HashSet<String> dic = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && dic.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    /**
     * 一个字符串由 w1 w2..wn组成，是否能够拆分，确定一个单词后，结果由剩下的字母确定
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        return helper(s, wordDict, 0);
    }

    private boolean helper(String words, List<String> wordDict, int index) {
        // 错误答案,见测试用例，而且for循环更好
        /**
         * if (start == s.length()) { return true; } for (int end = start + 1; end <=
         * s.length(); end++) { if (wordDict.contains(s.substring(start, end)) &&
         * word_Break(s, wordDict, end)) { return true; } } return false;
         */
        if (index == words.length()) {
            return true;
        }
        int end = index + 1;
        while (end <= words.length()) {
            String temp = words.substring(index, end);
            if (wordDict.contains(temp)) {
                break;
            }
            end++;
        }
        if (end == words.length()) {
            return true;
        } else if (end < words.length()) {
            return helper(words, wordDict, end);
        } else {
            return false;
        }
    }

    @Test
    public void test() {
        String s = "aaaaaaa";
        List<String> dic = Arrays.asList("aaaa", "aaa");
        boolean result = wordBreak(s, dic);
        System.out.println(result);
    }
}