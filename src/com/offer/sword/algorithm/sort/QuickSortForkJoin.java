package com.offer.sword.algorithm.sort;

import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveAction;

import org.junit.Test;

/**
 * 使用fork/join实现快排
 */
public class QuickSortForkJoin extends RecursiveAction {
    private static final long serialVersionUID = 1L;

    private int[] data;
    private int left;
    private int right;

    public QuickSortForkJoin(int[] data, int left, int right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    @Override
    protected void compute() {
        if (left < right) {
            int pivot = partition(data, left, right);
            invokeAll(new QuickSortForkJoin(data, left, pivot - 1),
                    new QuickSortForkJoin(data, pivot + 1, right));
        }
    }

    private int partition(int[] data, int left, int right) {
        int pivotVal = data[left];
        int l = left;
        int r = right;
        while (l < r) {
            while (data[r] >= pivotVal && l < r) {
                r--;
            }
            while (data[l] <= pivotVal && l < r) {
                l++;
            }
            swap(data, l, r);
        }
        swap(data, left, l);
        return l;
    }

    private void swap(int[] data, int a, int b) {
        int temp = data[a];
        data[a] = data[b];
        data[b] = temp;
    }

    public static void main(String[] args) {
        int count = 10000;
        int[] data = new int[count];
        for (int i = count; i > 0; i--) {
            data[i - 1] = (int) (Math.random() * count);
        }
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        Future<Void> result = forkJoinPool.submit(new QuickSortForkJoin(data, 0, count - 1));
        try {
            result.get();
            System.out.println(Arrays.toString(data));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}