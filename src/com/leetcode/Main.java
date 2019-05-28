package com.leetcode;


import com.leetcode.struct.TreeNode;
import com.leetcode.top100.ConvertBST;

/**
 * @author Mht
 */
public class Main {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(13);

        root.left = left;
        root.right = right;
        ConvertBST convertBST = new ConvertBST();
        System.out.println(convertBST.sum(root));
    }
}
