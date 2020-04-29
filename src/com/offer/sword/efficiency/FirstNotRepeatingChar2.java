package com.offer.sword.efficiency;

import org.junit.Test;

/**
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * 
 * @author hitomeng
 * @date 2020-04-29 19:07:25
 */
public class FirstNotRepeatingChar2 {

    // 受50题启发，这里我们同样用一个数组实现Map功能
    // 但是key是字符，value却是字符出现的位置。如果出现多次，就不可能是目标字符，置为-1
    private int[] map = new int[256];

    // index用来记录位置，理解为插入的顺序，越大插入越靠后。因为数组默认值是0，位置就从1开始
    private int index = 1;

    // Insert one char from stringstream
    public void Insert(char ch) {
        // 字符没有出现过，可能是目标值，记录出现位置
        if(map[ch] == 0){
            map[ch] = index++;
        }else{
            // 出现多次，直接置为-1，表示不可用
            map[ch] = -1;
        }
    }

    /**
     * 遍历每一个字符，如果值>0说明出现过而且没有重复出现
     * 找到Map中值大于零的最小值，所对应的key，就是第一个不重复字符
     */
    public char FirstAppearingOnce() {
        int minPos = Integer.MAX_VALUE;
        char c = '#';
        for (int i = 0; i < map.length; i++) {
            if(map[i] > 0 && map[i] < minPos){
                minPos = map[i];
                c = (char) i;
            }
        }
        return c;
    }


    @Test
    public void test(){
        char[] cs = "123329016a@$%6@".toCharArray();
        for (int i = 0; i < cs.length; i++) {
            Insert(cs[i]);
        }
        char c = FirstAppearingOnce();
        System.out.println(c);
    }
}