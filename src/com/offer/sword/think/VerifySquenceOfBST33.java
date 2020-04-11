package com.offer.sword.think;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 * 
 * @author hitomeng
 * @date 2020-04-11 11:59:35
 */
public class VerifySquenceOfBST33 {

    /**
     * 
     * @param sequence 后序遍历结果
     * @return yes or no
     */
    public boolean verifySquenceOfBST(int[] sequence) {
        if (sequence == null) {
            return false;
        }
        if (sequence.length == 0) {
            return false;
        }
        if (sequence.length <= 2) {
            return true;
        }

        return verify(sequence, 0, sequence.length - 1);
    }

    private boolean verify(int[] arr, int i, int j) {
        if (j - i <= 1) {
            return true;
        }
        int root = arr[j];
        int leftRoot = -1;
        for (int k = i; k < j; k++) {
            if (arr[k] < root) {
                leftRoot = k;
            } else {
                break;
            }
        }
        for (int k = leftRoot == -1 ? i : leftRoot + 1; k < j; k++) {
            if (arr[k] < root) {
                return false;
            }
        }
        if (leftRoot == -1) {
            return verify(arr, i, j - 1);
        } else {
            return verify(arr, i, leftRoot) && verify(arr, leftRoot + 1, j - 1);
        }
    }

    @Test
    public void test() {
        boolean res = verifySquenceOfBST(new int[] { 1, 2, 4, 3, 6, 8, 7, 5 });
        boolean res2 = verifySquenceOfBST(new int[] { 7, 4, 6, 5 });
        System.out.println(res);
        System.out.println(res2);
        assertTrue(verifySquenceOfBST(new int[] { 5, 7, 6, 9, 11, 10, 8 }));
        assertFalse(verifySquenceOfBST(new int[] { 4, 6, 12, 8, 16, 14, 10 }));
    }

}