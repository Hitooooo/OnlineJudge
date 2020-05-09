package com.offer.sword;

import org.junit.Test;

/**
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
 * 同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。例如，“student. a am I”。
 * 后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。
 * Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 * 
 * @author hitomeng
 * @date 2020-05-09 11:45:35
 */
public class ReverseSentence58 {

    /**
     * 全部字符翻转一次，然后每个单词翻转一次
     * @param str
     * @return
     */
    public String solution(String str) {
        if (str == null || str.length() < 1) {
            return str;
        }
        char[] sentenceChars = str.toCharArray();
        char[] revSen = reverse2(sentenceChars, 0, sentenceChars.length - 1);
        int left = 0;
        int right = 0;
        for (int i = 0; i < revSen.length; i++) {
            // 仅一个单词
            if (revSen.length - 1 == i) {
                reverse2(revSen, left, right);
            } else if (revSen[i] == ' ') {
                // 由于循环里面的right与i保持了一致，所以需要-1
                reverse2(revSen, left, right - 1);
                left = i + 1;
                right = left;
            } else {
                right++;
            }
        }
        return new String(revSen);
    }

    private char[] reverse2(char[] chars, int left, int right) {
        while (left < right) {
            char temp = chars[left];
            chars[left++] = chars[right];
            chars[right--] = temp;
        }
        return chars;
    }

    // 无法解决空格问题
    public String reverseSentence(String str) {
        if (str == null || str.length() < 1) {
            return "";
        }
        String rev = reverse(str);
        String[] words = rev.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(reverse(word)).append(" ");
        }
        return sb.toString().trim();
    }

    // why not inplace
    private String reverse(String str) {
        char[] chars = str.toCharArray();
        char[] newChars = new char[chars.length];
        for (int i = 0; i < chars.length; i++) {
            newChars[i] = chars[chars.length - i - 1];
        }
        return new String(newChars);
    }

    @Test
    public void test() {
        System.out.println(solution("Wonderful"));
    }
}