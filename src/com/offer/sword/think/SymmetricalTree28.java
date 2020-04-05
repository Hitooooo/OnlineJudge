package com.offer.sword.think;

import com.leetcode.struct.TreeNode;

/**
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 * 
 * @author hitomeng
 * @date 2020-04-05 15:37:05
 */
public class SymmetricalTree28 {
    boolean isSymmetrical(TreeNode pRoot) {
        if(pRoot == null){
            return true;
        }
        return isSymmetricalRe(pRoot, pRoot);
    }

    private boolean isSymmetricalRe(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null){
            return true;
        }
        if(t1 == null || t2 == null){
            return false;
        }
        if(t1.val == t2.val){
            return isSymmetricalRe(t1.left, t2.right) && isSymmetricalRe(t1.right, t2.left);
        }
        return false;
    }
}