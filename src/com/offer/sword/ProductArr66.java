package com.offer.sword;

import java.util.Arrays;

import org.junit.Test;

/**
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 * （注意：规定B[0] = A[1] * A[2] * ... * A[n-1]，B[n-1] = A[0] * A[1] * ... * A[n-2];）
 */
public class ProductArr66 {
    public int[] multiply(int[] a) {
        if(a == null || a.length < 1){
            return a;
        }
        int[] res = new int[a.length];
        res[0] = 1;
        for(int i= 1;i < res.length;i++){
            res[i] = res[i-1]*a[i-1];
        }
        int temp = 1;
        for(int j = res.length - 2; j>=0;j--){
            temp *= a[j+1];
            res[j] *= temp;
        }
        return res;
    }

    @Test
    public void test(){
        int[] res = multiply(new int[]{1,2,3,4,5});
        System.out.println(Arrays.toString(res));
    }
}