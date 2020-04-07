package com.offer.sword.quality;

import com.leetcode.struct.TreeNode;

import org.junit.Test;

/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * 
 * @author hitomeng
 * @date 2020-04-05 09:29:50
 */
public class HasSubTree26 {

    /**
     * 二叉树自然想到递归。
     * @param root1
     * @param root2
     * @return
     */
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }
        // 遍历每一个结点
        boolean has = false;
        if(root1.val == root2.val){
            has =  same(root1.left, root2.left) && same(root1.right, root2.right);
        }
        // 当前结点不满足，判断左右子树是否满足
        return has ? has :HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }

    /**
     * 判断当前树是否跟匹配树一致
     * 
     * @param roo1 目标树 
     * @param root2 匹配树
     */
    private boolean same(TreeNode roo1, TreeNode root2) {
        // 匹配树为空，认为满足
        if (root2 == null) {
            return true;
        }
        // 匹配树不为空，但是目标树为空，不满足
        if(roo1 == null){
            return false;
        }
        // 两棵树都不为空，进行判断
        if (roo1.val == root2.val) {
            return same(roo1.left, root2.left) && same(roo1.right, root2.right);
        }
        return false;
    }

    @Test
    public void test(){
        TreeNode root = new TreeNode(8);
        TreeNode n8 = new TreeNode(8);
        TreeNode n7 = new TreeNode(7);
        TreeNode n9 = new TreeNode(9);
        TreeNode n2 = new TreeNode(2);

        root.left = n8;
        root.right = n7;
        n8.left = n9;
        n8.right = n2;

        TreeNode sub = new TreeNode(8);
        sub.left = new TreeNode(9);
        sub.right = new TreeNode(2);

        boolean res = HasSubtree(root, sub);
        System.out.println(res);
    }
}