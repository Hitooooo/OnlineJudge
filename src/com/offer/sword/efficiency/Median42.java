package com.offer.sword.efficiency;

import java.util.Comparator;
import java.util.PriorityQueue;

import org.junit.Test;

/**
 * 求数据流中的中位数。
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，
 * 那么中位数就是所有数值排序之后中间两个数的平均值。我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 * 
 * @author hitomeng
 * @data 2020-04-25 10:40:31
 */
public class Median42 {

    private PriorityQueue<Integer> min = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    });

    private PriorityQueue<Integer> max = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            // 倒排
            return o2 - o1;
        }
    });

    /**
     * 流长度为偶数时插入到小根堆，奇数插入到大根堆
     * 
     * @param num 插入到流中的数
     */
    public void Insert(Integer num) {
        if (((max.size() + min.size()) & 1) == 0) {
            if (max.size() > 0 && max.peek() > num) {
                max.add(num);
                num = max.poll();
            }
            min.add(num);
        } else {
            if (min.size() > 0 && min.peek() < num) {
                min.add(num);
                num = min.poll();
            }
            max.add(num);
        }
    }

    public Double GetMedian() {
        double res = 0.0;
        if(min.size() == max.size()){
            res = (min.peek() + max.peek()) / 2.0;
        }else if(min.size()> max.size()){
            res = min.peek();
        }else{
            res = max.peek();
        }
        return res;
    }

    @Test
    public void test(){
        int[] arr = {1,2,3,45,6,78,9,1};
        for (int i = 0; i < arr.length; i++) {
           Insert(arr[i]); 
        }
        Double res = GetMedian();
        System.out.println(res);
    }
}