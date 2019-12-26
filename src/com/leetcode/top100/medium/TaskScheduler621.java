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
     * 如何证明这样是最小的呢?保证了最容易产生冷却时间的task分开，剩下的可能产生cd的task也保证了可插入位置，不会
     * 产生cd。这样保证了产生的cd最小，用时也是最小的。
     * 1.统计最多的任务,注意次数max最多的任务可能出现多次maxCount,那就看作一个整体,中间可插入位置减少
     * 2.计算可插入位置个数,(max-1)*partLength; 一般partLength=n.但是若maxCount>1 partLength=n-(maxCount-1)
     * 3.计算可用于插入的task个数 taskLength-max*maxCount
     * 4.如果未填满,就用idle来填充.
     */
    public int leastInterval(char[] tasks, int n) {
        int[] counter = new int[26];
        int max = 0;
        int maxCount = 0;
        for(char task : tasks) {
            counter[task - 'A']++;
            if(max == counter[task - 'A']) {
                maxCount++;
            }else if(max < counter[task - 'A']) {
                max = counter[task - 'A'];
                maxCount = 1;
            }
        }
        int partCount = max - 1;
        int partLength = n - (maxCount - 1);
        int slotCount = partCount * partLength;
        int availableTask = tasks.length - max * maxCount;
        // 如果空闲为负,说明全部填满后,还有未插入的task.这不要紧,虽然插满了,但还是可以插入的
        // A3B3C3D3 n=2; ABC|ABC|ABC,此时仍可插入 ABCD|ABCD|ABCD,不影响计算结果
        int idle = Math.max(0, slotCount - availableTask);

        return tasks.length + idle;
    }

    /**
     * 排序后通过切的方式是不行的，因为要求冷却时间内无法执行相同的任务。
     * 如n=2, A3 B3  ABABAB是行不通的，因为运行完A后的两个单位时间内都不可再运行A
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