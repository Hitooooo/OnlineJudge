package com.offer.sword;

import java.util.Arrays;

import org.junit.Test;

/**
 * 一个整型数组里除了两个数字外，其它数字都出现了两次，请找出这两个只出现一次的数字，要求时间复杂度是O（n），空间复杂度是O（1）。
 * 比如输入数组：2,4,3,6,3,2,5,5，输出为4和6，因为只有4和6只出现一次，其它数字都出现了两次。
 *  
 * @author hitomeng
 * @date 2020-05-07 23:28:13
 */
public class FindNumsAppearsOne56 {

    /**
     * 一个数跟自己异或计算得0，0和其他数异或计算其他数不变。因此如果将数组拆为两个部分，只出现一次的两个数分布在
     * 两个数组中，两个数组内部的数分别进行异或计算，最终得出的两个数就是目标值.
     * 那如何将两个数分开呢？源数组所有数字一次异或，得到的结果是两个目标数的异或结果c,c = a ^ b,因a!=b，所以c的二进制表现中必然
     * 存在某位为1，我们就按照某位是否为1将数组分为两个，显然a和b自动会被分开
     * 
     * @param arr
     * @return
     */
    public int[] solution(int[] arr){
        if(arr == null || arr.length < 2){
            return null;
        }
        int[] res = new int[2];
        int k = getKthOne(arr);
        int a = 0;
        int b = 0;
        for (int i = 0; i < arr.length; i++) {
            if(isKthOne(arr[i], k)){
                a ^= arr[i];
            }else{
                b ^= arr[i];
            }
        }
        res[0] = a;
        res[1] = b;
        return res;
    }
    
    /**
     * 求两个不重复数异或结果的二进制表示中，为1的第k位。k=0表示最右面的第一位是1
     * @param arr
     * @return
     */
    public int getKthOne(int[] arr){
        int all = 0;
        for (int i = 0; i < arr.length; i++) {
            all = all ^ arr[i];
        }
        int k = 0;
        while((all & 1) != 1){
            all = all >> 1;
            k++;
        }
        return k;
    }

    /**
     * 判断一个数的第k位是不是1
     * @param num
     * @param k
     * @return
     */
    public boolean isKthOne(int num, int k){
        int newNum = num >> k;
        return (newNum & 1) == 1;
    }

    @Test
    public void test(){
        int[] arr = {1,2,2,3,4,4};
        int[] arr2 = {1,3};
        int k = getKthOne(arr);
        System.out.println(k);

        System.out.println(isKthOne(1, k));
        System.out.println(Arrays.toString(solution(arr)));
        System.out.println(Arrays.toString(solution(arr2)));
    }
}