package com.offer.tree.ques;

import com.leetcode.struct.TreeNode;

/**
 * 二叉树的深度
 * 
 * @author hitomeng
 * @date 2020-05-07 08:05:37
 */
public class TreeDepth55 {

    /**
     * 二叉树，自然想到递归
     * 
     * @param root
     * @return
     */
    public int TreeDepth(TreeNode root) {
       if(root == null){
           return 0;
       } 
       int left = TreeDepth(root.left);
       int right = TreeDepth(root.right);
       return Math.max(left, right) + 1;
    }  
}