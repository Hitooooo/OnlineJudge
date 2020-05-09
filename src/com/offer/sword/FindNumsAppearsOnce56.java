package com.offer.sword;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * 一个数组中，除了一个数出现一次，其他数字都出现了三次，找到这个数
 * 
 * @author hitomeng
 * @date 2020-05-09 09:20:24
 */
public class FindNumsAppearsOnce56 {

    /**
     * 将数组中的每个数都用二进制表示，然后统计各位上1的个数。如果某位上的1个数能被3整除，那么说明目标数在此位置上
     * 必然是0，因为其他数字在此位置的个数和必为3的倍数，相反地，如果不能被3整除那么目标数在此位置上必然是1
     */
    public int solution(int[] arr) {
        if (arr == null || arr.length < 1) {
            throw new RuntimeException();
        }
        // int类型，32位
        int[] bitCount = new int[32];
        for (int i = 0; i < arr.length; i++) {
            int bitMask = 1;
            for (int j = 0; j < bitCount.length; j++) {
                int temp = arr[i] >> j;
                if((temp & bitMask) == 1){
                    bitCount[j] += 1;
                }
            }            
        }
        int res = 0;
        for (int i = 0; i < bitCount.length; i++) {
           if(bitCount[i] % 3 != 0){
                res += Math.pow(2, i);
           } 
        }
        
        // 如果想用位移方式计算，bitCount中顺序要注意
        // for (int i = 0; i < bitCount.length ; ++i) {
        //     res = res << 1;
        //     res += bitCount[i] % 3;
        // }
        return res;
    }

    @Test
    public void test(){
        assertEquals(1, solution(new int[]{1,2,2,2,3,3,3}));
        assertEquals(4, solution(new int[]{4, 3, 3, 2, 2, 2, 3}));
        assertEquals(7, solution(new int[]{4, 4, 1, 1, 1, 7, 4}));
    }
}