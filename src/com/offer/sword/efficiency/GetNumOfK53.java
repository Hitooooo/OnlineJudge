package com.offer.sword.efficiency;

import org.junit.Test;

/**
 * 统计一个数字在排序数组中出现的次数
 * 
 * @author hitomeng
 * @date 2020-05-06 08:48:34
 */
public class GetNumOfK53 {
    public int getNumOfK(int[] arr, int k) {
        if (arr == null || arr.length < 1) {
            return 0;
        }
        int first = getFirstK(arr, k, 0, arr.length - 1);
        int last = getLastK(arr, k, 0, arr.length - 1);
        if(first != -1 && last != -1){
            if(first == last){
                return 1;
            }else{
                return last - first + 1;
            }
        }
        return 0;
    }

    /**
     * 找到第一个·
     * @param arr 数组 
     * @param target 目标值
     * @param start 查找起始
     * @param end 查找结束
     * @return 起始位置
     */
    private int getFirstK(int[] arr, int target, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = start + (end - start) / 2;
        if (arr[mid] == target) {
            if ((mid > 0 && arr[mid - 1] != target) || mid == 0) {
                return mid;
            } else {
                end = mid - 1;
            }
        } else if (arr[mid] > target) {
            end = mid - 1;
        } else {
            start = mid + 1;
        }
        return getFirstK(arr, target, start, end);
    }

    /**
     * 找到结束位置 
     */
    private int getLastK(int[] arr, int target, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = start + (end - start) / 2;
        if (arr[mid] == target) {
            if ((mid < end && arr[mid + 1] != target) || mid == end) {
                return mid;
            } else {
                start = mid + 1;
            }
        } else if (arr[mid] > target) {
            end = mid - 1;
        } else {
            start = mid + 1;
        }
        return getLastK(arr, target, start, end);
    }

    @Test
    public void test(){
        int[] arr = {1,22,22,3,3,3,3};
        int c= getNumOfK(arr, 3);
        System.out.println(c);
    }
}