package com.offer.sword.think;

import com.leetcode.struct.TreeNode;

/**
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 */
public class Mirror27{
    public void Mirror(TreeNode root) {
        if(root == null){
            return;
        }
        // 交换左右子树
        TreeNode temNode = root.left;
        root.left = root.right;
        root.right = temNode;

        Mirror(root.left);
        Mirror(root.right);
    }
}