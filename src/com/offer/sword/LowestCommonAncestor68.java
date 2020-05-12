package com.offer.sword;

import com.leetcode.struct.TreeNode;

/**
 * 树的最低公共祖先
 * 
 */
public class LowestCommonAncestor68 {
    /**
     * 二叉搜索树中的最低公共祖先结点
     */
    public TreeNode lowestCommonAncestorInBSTree(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if(root.val > p.val && root.val > q.val){
            return lowestCommonAncestorInBSTree(root.left, p, q);
        }else if(root.val < p.val && root.val < q.val){
            return lowestCommonAncestorInBSTree(root.right, p, q);
        }
        return root;
    }

    /**
     * 一个普通二叉树
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 如果p或q是根节点，那么直接返回
        if(root == null || root == p || root == q){
            return root;
        }
        
        TreeNode left = lowestCommonAncestor(root.left, p, q);
       
        TreeNode right = lowestCommonAncestor(root.right, p,q);
        // 在左面吗
        if(left == null){
            return right;
        }
        // 在右面吗
        if(right == null){
            return left;
        }
        // 既不在左，也不在由，只能是根节点了
        return root;
    }
}