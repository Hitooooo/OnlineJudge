package com.leetcode.top100.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

/**
 * Given a collection of intervals, merge all overlapping intervals. 合并区间。
 * <p>
 * Input: [[1,3],[2,6],[8,10],[15,18]] Output: [[1,6],[8,10],[15,18]]
 *
 * @author hitomeng
 * @since 2019/09/09
 */
public class MergeIntervals {


    public int[][] merge2(int[][] intervals) {
        // 1. 排序
        List<int[]> ranges = new ArrayList<>();
        if (intervals == null || intervals.length < 1) {
            return ranges.toArray(new int[0][]);
        }
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        int[] interval = intervals[0];
        ranges.add(interval);
        for (int[] range : intervals) {
            if(range[0] <= interval[1]){
                interval[1] = Math.max(interval[1], range[1]);
            }else {
                interval = range;
                ranges.add(interval);
            }
        }
        return ranges.toArray(new int[0][]);
    }


    /**
     * 如何合并两个区间a[i][]和a[j][]呢？ 1. 确保a[i]的左面小于a[j]的左面 2. 如果a[j]的左面小于a[i]的右面,那么是有重叠的
     * 3. 合并区间 a[i]的左面到 max(a[i]的右面,a[j]的右面)
     */
    public int[][] merge(int[][] intervals) {
        // 1. 排序
        List<int[]> ranges = new ArrayList<>();
        if (intervals == null || intervals.length < 1) {
            return ranges.toArray(new int[0][]);
        }
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        //
        int i = 0;
        while (i < intervals.length) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            int j = i + 1;
            while (j <= intervals.length - 1 && intervals[j][0] <= right) {
                right = Math.max(right, intervals[j][1]);
                j++;
            }
            ranges.add(new int[]{left, right});
            i = j  ;
        }
        return ranges.toArray(new int[0][]);
    }

    @Test
    public void test() {
        int[][] intervals = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] result = merge2(intervals);

        int[][] intervals2 = new int[][]{{1, 4}, {4, 5}};
        int[][] result2 = merge(intervals2);
        System.out.println(result2.length);
    }
}