package com.offer.sword;

import java.util.ArrayList;

import org.junit.Test;

/**
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，
 * 如果有多对数字的和等于S，输出两个数的乘积最小的。
 */
public class TwoSumInSortedArr57 {

    /**
     * 1. 数组为null或大小为空 
     * 2. 确认数组是排好序的
     * 3. 如果有多组怎么办
     * 
     * @param array
     * @param sum
     * @return
     */
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        if(array == null || array.length < 1){
            return list;
        }
        int left = 0;
        int right = array.length - 1;
        while(left < right){
            int twoSum = array[left] + array[right];
            if(twoSum == sum){
                list.add(array[left]);
                list.add(array[right]);
                break;
            }else if(twoSum > sum){
                right--;
            }else{
                left++;
            }
        }
        return list;
    }

    @Test
    public void test(){
        ArrayList<Integer> res = FindNumbersWithSum(new int[]{1,2,3,4,5,6,9}, 8);
        System.out.println(res);
    }
}