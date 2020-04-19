package com.offer.sword.think;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * 八皇后问题
 * 
 * @author hitomeng
 * @date 2020-04-19 14:32:21
 */
public class EightQueen {

    public List<List<String>> solveNQueens(int n) {
        List<int[]> numsList = new ArrayList<>();
        List<List<String>> res = new ArrayList<>();
        int[] permutation = new int[n];
        for (int i = 0; i < permutation.length; i++) {
            permutation[i] = i;
        }
        permutation(permutation, 0, numsList);
        // 判断排列是否满足N皇后要求
        for (int[] per : numsList) {
           if(ok(per)){
            res.add(arr2String(per));
           } 
        }
        return res;
    }

    // 计算出所有排列，保存再numList中
    private void permutation(int[] nums, int index, List<int[]> numList) {
        if(index == nums.length){
            return;
        }
        if(index == nums.length -1){
            // 必须复制新建，因为数组是引用型数据
            numList.add(Arrays.copyOf(nums, nums.length));
        }else{
            for (int i = index; i < nums.length; i++) {
               swap(nums, index, i); 
               permutation(nums, index + 1, numList);
               swap(nums, i, index);
            }
        }
    }

    /**
     * 将满足条件的数组转换成结果中需要的结构
     * @param nums
     * @return
     */
    private List<String> arr2String(int[] nums){
        List<String> res  = new ArrayList<>();
        int[][] arr2d = new int[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
           arr2d[i][nums[i]] = 1; 
        }
        for (int i = 0; i < arr2d.length; i++) {
            String temp = "";
            for (int j = 0; j < arr2d.length; j++) {
                if(arr2d[i][j] == 1){
                    temp += "Q";
                }else{
                    temp += ".";
                }
            }
            res.add(temp);
        }
        return res;
    }

    private void swap(int[] arr, int i, int j) {
       int temp = arr[i];
       arr[i] = arr[j];
       arr[j] = temp; 
    }

    // 判断一个组合是否满足N皇后要求
    private boolean ok(int[] queens) {
        for (int i = 0; i < queens.length; i++) {
            for (int j = i + 1; j < queens.length; j++) {
                // 设置的数组已经是 不同行不同列，只需要不在保证对角线
                if (j - i == Math.abs(queens[j] - queens[i])) {
                    return false;
                }
            }
        }
        return true;
    }

    @Test public void test(){ 
        solveNQueens(4);
    }
}