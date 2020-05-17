package com.leetcode.contest;

import org.junit.Test;

/**
 * 
 */
public class ArrangeWords {
    public String arrangeWords(String text) {
        String[] strs = text.split(" ");
        for (int i = 1; i < strs.length; i++) {
            String insertStr = strs[i];
            int k = i - 1;
            while (k >= 0 && strs[k].length() > insertStr.length()) {
                strs[k + 1] = strs[k];
                k--;
            }

            strs[k + 1] = insertStr;
        }
        String res = "";
        for (int i = 0; i < strs.length; i++) {
            res += strs[i].toLowerCase();
            if (i != strs.length - 1) {
                res += " ";
            }
        }
        char firstLetter = res.charAt(0);
        if(firstLetter >= 'a' && firstLetter <= 'z'){
            firstLetter -= 32;
            res = firstLetter + res.substring(1);
        }

        
        return res;
    }

    @Test
    public void test(){
        System.out.println(arrangeWords("i am a boy is"));
    }
}