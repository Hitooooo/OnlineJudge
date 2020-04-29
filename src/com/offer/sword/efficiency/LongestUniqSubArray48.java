package com.offer.sword.efficiency;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import java.util.HashSet;
import org.junit.Test;

/**
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 * 
 * @author hitomeng
 * @date 2020-04-28 23:06:50
 */
public class LongestUniqSubArray48 {

    /**
     * dp[i] = dp[i-1];                             char[i]出现过，而且出现的位置在dp[i-1]最长不重复子串的外面
     * dp[i] = char[i]当前位置 - char[i]上一次出现位置; char[i]出现过，而且出现的位置在dp[i-1]最长不重复子串的里面
     * dp[i] = dp[i-1] + 1;                         char[i]前面未出现过
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        // 记录字符最后一次出现的位置 
        int[] pos = new int[256];
        Arrays.fill(pos, -1);
        char[] chars = s.toCharArray();
        // 每个位置结尾的子串计算完毕后，判断是否最大
        int maxLen = 0;
        // 上一个的最长值
        int lastMaxLen = 0;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            int lastPos = pos[(int)c];
            int len;
            // 当前字符出现过
            if (lastPos > -1) {
                // 判断与重复字符之间的距离
                int distance = i - lastPos;
                if (distance > lastMaxLen) {
                    // 距离大于上一个的最长值，说明当前字符不在上一个最长子串中，直接加1
                    len = lastMaxLen + 1;
                } else {
                    // 当前字符是上一个字符结尾的最长不重复子串，如abcb
                    len = distance;
                }
            } else {
                // 没有出现过，直接在前一个基础加1就行
                len = lastMaxLen + 1;
            }
            pos[(int)c] = i;
            lastMaxLen = len;
            maxLen = len > maxLen ? len : maxLen;
        }
        return maxLen;
    }

    @Deprecated
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();
        HashSet<Character> set = new HashSet<>();
        set.add(chars[0]);
        int maxLen = 1;
        for (int i = 1; i < chars.length; i++) {
            set.add(chars[i]);
            if (set.size() > maxLen) {
                maxLen = set.size();
            }
        }
        return maxLen;
    }

    @Test
    public void test() {
        assertEquals(3, lengthOfLongestSubstring2("dvdf"));
        assertEquals(3, lengthOfLongestSubstring2("abcabcbb"));
        assertEquals(4, lengthOfLongestSubstring2("arabcacfr"));
    }
}