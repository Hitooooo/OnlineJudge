package com.offer.sword.algorithm;


import org.junit.Test;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数据的旋转。输入一个递增有序的数组的一个旋转，输出
 * 旋转数组的最小元素。例如，数组｛3，4，5，1，2｝为｛1，2，3，4，5｝的一个旋转，该数组的最小值为1.这里的
 * 旋转描述的不太准确，应该是切割然后交换。
 * 
 * @author hitomeng
 * @date 2020-03-24
 */
public class MinInRotateSortedArr {

    /**
     * 直接循环最简单也不会出错，但是时间复杂度是可以小于o(n)的。
     * 运用二分法模板。 Wrong
     * @param arr 旋转后的数组
     * @return 最小值
     */
    @Deprecated
    public int min(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new RuntimeException("Input param error!");
        }
        if(arr.length == 1){
            return arr[0];
        }
        // 1. 确定二分边界
        int left = 0;
        int right = arr.length - 1;
        while(left < right){
            // 2.根据奇偶性时中位数的性质，确定中位数。先随便选中一种。
            int mid = (left + right) >> 1;    
            // 3.1 根据第二步中的中位数，想办法排除这个中位数。
            // 3.2 考虑只剩下两个数时，分析mid取左和取右两种情况下，选择仍能统一3.1中的排除操作的一种取中位数情况
            if(arr[mid] >= arr[right]){
                // 上面的判断条件为什么要等于呢？如{0,1,1,1}的旋转{1，1，0，1}，存在等值的情况
                left = mid + 1;
            }else{
                right = mid;
            }
        }       
        // 4. 分析二分查找结束时夹逼到的数，正确返回即可
        return arr[left];
    }

    @Test
    public void test(){
        int[] arr = new int[]{6501,6828,6963,7036,7422,7674,8146,8468,8704,8717,9170,9359,9719,9895,9896,9913,9962,154,293,334,492,1323,1479,1539,1727,1870,1943,2383,2392,2996,3282,3812,3903,4465,4605,4665,4772,4828,5142,5437,5448,5668,5706,5725,6300,6335};
        System.out.println(min(arr));
    }
}