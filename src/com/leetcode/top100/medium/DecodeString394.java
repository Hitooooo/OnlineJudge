package com.leetcode.top100.medium;

import java.util.LinkedList;

import javax.sound.sampled.SourceDataLine;

import org.junit.Test;

/**
 * s = "3[a]2[bc]", 返回 "aaabcbc". s = "3[a2[c]]", 返回 "accaccacc". s =
 * "2[abc]3[cd]ef", 返回 "abcabccdcdcdef"
 * 
 * @author hitomeng
 * @date 2019/11/07
 */
public class DecodeString394 {
    public String decodeString(String s) {
        return helper(s, 0, s.length() - 1);
    }

    /**
     * 将字符串分割成一个个的子问题后合并
     * 2[a]3[c]ddd4[5f] = 2(a)+3(c)+ddd+4(5(f))
     * 
     * @param word encode string
     * @param start start index 0 
     * @param end end index
     * @return
     */
    private String helper(String word, int start, int end) {
        if(word == null || word.length() == 0){
            return "";
        }
        char[] chars = word.toCharArray();
        StringBuilder sb = new StringBuilder();
        if (chars[start] < '0' || chars[start] > '9') {
            sb.append(chars[start]);
            start++;
        }
        // 用来确定[]所在的位置，里面的String又是相同的问题
        LinkedList<Character> charStack = new LinkedList<>();
        int i = start;
        while (i <= end) {
            if (chars[i] >= '0' && chars[i] <= '9') {
                // 处理数字是大于10的情况
                int count = 0;
                int k = i;
                while(chars[k] >= '0' && chars[k] <= '9'){
                    count = 10 * count + (chars[k] - '0');
                    k++;
                }
                // 确定[]的下标
                int startSym = k;
                int endSym = k;
                for (int j = k; j <= end; j++) {
                    if (chars[j] == '[') {
                        charStack.push('[');
                    } else if (chars[j] == ']') {
                        charStack.pop();
                    }
                    if (charStack.isEmpty()) {
                        endSym = j - 1;
                        break;
                    }
                }
                // 拼接子问题
                String tmp = helper(word, startSym + 1, endSym);
                while (count > 0) {
                    sb.append(tmp);
                    count--;
                }
                i = endSym + 2;
            }else{
                // 拼接正常的字符
                sb.append(chars[i]);
                i++;
            }
        }

        return sb.toString();
    }

    @Test
    public void test() {
        String s = decodeString("3[a2[c]]");
        System.out.println(s);
        String s1 = decodeString("20[abc]3[cd]ef");
        System.out.println(s1);
    }
}