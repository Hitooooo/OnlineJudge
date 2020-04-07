package com.offer.sword.algorithm;

import org.junit.Test;

/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class CountOneInBinary15 {

    /**
     * 只能处理正数，如果输入负数的话,可能进入死循环。因为>>是有符号右移，负数一直是负数
     */
    public int count(int num) {
        int count = 0;
        while (num != 0) {
            int r = num & 1;
            if (r > 0) {
                count++;
            }
            num >>= 1;
        }
        return count;
    }

    /**
     * 换个思路。位移操作比较数，而不是原数字
     * 
     * @param num
     * @return
     */
    public int count2(int num) {
        int count = 0;
        int flag = 1;
        // 超过int的bit范围之后，int的值就会变为0.因为32位都是零
        while (flag != 0) {
            System.out.println(flag);
            if((num & flag) != 0){
                count ++;
            }
            flag <<= 1;
        }
        return count;
    }

    @Test
    public void test() {
        int res = count2(-2147483648);
        System.out.println(res);
    }
}