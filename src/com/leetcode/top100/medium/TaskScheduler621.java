package com.leetcode.top100.medium;

import java.util.Arrays;

import org.junit.Test;

/**
 * 给定一个用字符数组表示的 CPU 需要执行的任务列表。其中包含使用大写的 A - Z 字母表示的26
 * 种不同种类的任务。任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。 CPU 在任何一个单位时间内都可以执行一个任务，或者在待命状态。
 * 然而，两个相同种类的任务之间必须有长度为 n 的冷却时间， 因此至少有连续 n 个单位时间内 CPU
 * 在执行不同的任务，或者在待命状态。你需要计算完成所有任务所需要的最短时间。
 * 
 * @author hitomeng
 * @date 2019/12/25
 */
public class TaskScheduler621 {

    /**
     * 优先出现次数最多的任务，其后将剩下的插入到最多的间隔之中。如果，补不齐，那么就空闲。
     * 如n=2, A3 B2 C1: ABC AB# A## time = 3 + 3 + 1 = 7（最后一个，因为后面没有可插入的了，只占用一个单位时间）
     * 如何证明这样是最小的呢
     */
    public int leastInterval(char[] tasks, int n) {
        return 0;
    }

    /**
     * 排序后通过切的方式是不行的，因为要求冷却时间内无法执行相同的任务。
     */
    public int leastIntervalWrong(char[] tasks, int n) {
        int[] map = new int[26];
        for (char c : tasks)
            map[c - 'A']++;
        Arrays.sort(map);
        int i = -1;
        for (int j = 0; j < map.length; j++) {
            if(map[j] > 0){
                i = j;
                break;
            }
        }
        return i == -1 ? 0 :helper(map, i, n);
    }

    private int helper(int[] counts, int i, int cd){
        if(i < 0 || i > counts.length - 1){
            return 0;
        }
        if(i == counts.length-1){
            return counts[i] * (cd + 1); 
        }
        int time = 0;
        for (int j = i; j < counts.length; j++) {
           time++;
           counts[j]--; 
           if(counts[j] == 0){
               i++;
           }
        }
        return time + helper(counts,  i, cd);
    }

    @Test
    public void test() {
        char[] tasks = { 'A', 'A', 'A', 'B', 'B', 'B' };
        int time = leastInterval(tasks, 2);
        System.out.println(time);
    }
}