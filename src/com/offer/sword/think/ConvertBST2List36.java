package com.offer.sword.think;

import com.leetcode.struct.TreeNode;

import org.junit.Test;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * 
 * @author hitomeng
 * @date 2020-04-18 16:45:36
 */
public class ConvertBST2List36 {
    /**
     * 
     *  
     * @param pRootOfTree 二叉排序树根节点
     * @return 双向链表
     */
    public TreeNode Convert(TreeNode pRootOfTree) {

        return convertPart(pRootOfTree);
    }

    /**
     * 整体看待，将一个树看成左子树、右子树和根节点三部分，正确连接三部分后返回头结点即可。
     * 此函数返回转换后的双向链表头结点。
     * 
     * @param root
     * @return
     */
    public TreeNode convertPart(TreeNode root){
        if(root == null){
            return null;
        }
        // 1. 递归找到左右子树的头节点
        TreeNode leftHead = null;
        if(root.left != null){
            leftHead = convertPart(root.left);
        }       
        TreeNode rightHead = null;
        if(root.right != null){
            rightHead = convertPart(root.right);
        }
        // 2.声明头结点，如果有左子树，那么头结点在左子树。否则头结点就是root
        TreeNode newHead = null;
        if(leftHead != null){
            newHead = leftHead;
            TreeNode node = leftHead;
            while(node.right != null){
                node = node.right;
            }
            // 找到左子树的最后一个节点，跟root连接起来
            node.right = root;
            root.left = node;
        }else{
            newHead = root;
        }        
        // 3.连接右子树
        root.right = rightHead;
         if(rightHead != null){
            rightHead.left = root;
        }
        return newHead;
    }

    @Test
    public void test(){
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        TreeNode res = convertPart(root);
        System.out.println(res);
    }
}