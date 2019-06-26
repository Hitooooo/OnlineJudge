package com.leetcode;


import com.leetcode.struct.TreeNode;
import com.leetcode.top100.ConvertBST;
import com.leetcode.top100.FindUnsortedSubarray;

import java.util.Arrays;
import java.util.List;

/**
 * @author Mht
 */
public class Main {

    public static void main(String[] args) {
        int[] arr = {2, 6, 4, 8, 10, 9, 15};
        System.out.println(new FindUnsortedSubarray().findUnsortedSubarray(arr));
    }
}
