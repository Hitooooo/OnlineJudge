package com.offer.sword.efficiency;

import java.util.Arrays;

import org.junit.Test;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 * 
 * @author hitomeng
 * @date 2020-04-29 20:01:01
 */
public class InversePairs51 {

    /**
     * 在完成归并排序的工程中，统计逆序对个数
     * 
     * @param array
     * @return
     */
    public int inversePairs(int[] array) {
        if (array == null || array.length < 1) {
            return 0;
        }
        int[] temp = Arrays.copyOf(array, array.length);
        return mergeSort(array, 0, array.length - 1, temp);
    }

    private int mergeSort(int[] arr, int start, int end, int[] temp) {
        if (start == end) {
            temp[start] = arr[start];
            return 0;
        }
        int halfLen = (end - start) / 2;
        int left = mergeSort(arr, start, start + halfLen, temp);
        int right = mergeSort(arr, start + halfLen + 1, end, temp);
        // merge
        int i = start + halfLen;
        int j = end;
        int k = end;
        int count = 0;
        while ((i >= start) && (j >= start + halfLen + 1)) {
            int current;
            if (arr[i] > arr[j]) {
                count += j - (start + halfLen + 1) + 1;
                current = arr[i];
                i--;
            } else {
                current = arr[j];
                j--;
            }
            temp[k--] = current;
        }
        while (i >= start) {
            temp[k--] = arr[i--];
        }
        while (j >= start + halfLen + 1) {
            temp[k--] = arr[j--];
        }
        k = end;
        // 将temp中的元素全部拷贝到原数组中
        while (start <= end) {
            arr[end--] = temp[k--];
        }
        return left + right + count;
    }

    @Test
    public void test() {
        int[] arr = { 4,5,6,7,0,1 };
        int c = inversePairs(arr);
        System.out.println(c);
    }
}