package com.offer.sword.efficiency;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * 给定一个数字，按如下规则翻译成字符串： 0->a;1->b;...25->z; 因此一个数字可能有多个翻译，如12258
 * 'bccfi','bwfi','bczi','mcfi','mzi'.编程计算一个数字有多少种 不同的翻译方法.
 * 
 * @author hitomeng
 * @date 2020-04-25 20:09:57
 */
public class TranslateNum2Str46 {
    /**
     * f(i) = f(i+1) + g(i,i+1)*f(i+2); 其中g()表示是否可以两位表示一个字母
     * 
     * @param num
     * @return 多少种可能
     */
    public int getTranslationCount(int num) {
        if (num <= 0) {
            return 0;
        }
        return count(num + "", 0);
    }

    private int count(String str, int i) {
        int len = str.length();
        if(i >= len){
            return 0;
        }
        if (i == len - 1) {
            return 1;
        }
        int g = Integer.parseInt(str.substring(i, i + 2));
        if (g > 0 && g < 26) {
            return count(str, i + 1) + count(str, i + 2);
        }else{
            return count(str, i + 1);
        }
    }

    @Test
    public void test(){
        assertEquals(getTranslationCount(-1), 0);
        assertEquals(getTranslationCount(12258), 5);
        assertEquals(getTranslationCount(101), 2);
        assertEquals(getTranslationCount(100), 2);
        assertEquals(getTranslationCount(426), 1);
    }
}