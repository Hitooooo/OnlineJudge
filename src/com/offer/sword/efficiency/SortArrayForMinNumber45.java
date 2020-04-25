package com.offer.sword.efficiency;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.Test;

/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
 * 打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 * 
 * @author hitomeng
 * @date 2020-04-25 19:17:16
 */
public class SortArrayForMinNumber45 {

    /**
     * 3 32 ：332>323-->3放在32前面
     * 
     * @param numbers
     * @return
     */
    public String printMinNumber(int[] numbers) {
        if (numbers == null || numbers.length < 1) {
            return "";
        }
        String[] strs = new String[numbers.length];
        for (int i = 0; i < strs.length; i++) {
            strs[i] = numbers[i] + "";
        }
        Arrays.sort(strs, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                String o1o2 = o1 + o2;
                String o2o1 = o2 + o1;
                return o1o2.compareTo(o2o1);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            sb.append(strs[i]);
        }
        return sb.toString();
    }

    @Test
    public void test() {
        int numbers[] = { 3, 5, 1, 4, 2 };
        String s = printMinNumber(numbers);
        System.out.println(s);
    }
}