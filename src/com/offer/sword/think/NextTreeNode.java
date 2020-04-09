package com.offer.sword.think;

import com.leetcode.struct.TreeLinkNode;

/**
 * 给定一个二叉树中的结点，判读二叉树中序遍历中这个结点的下一个结点
 * 
 * @author hitomeng
 * @date 2020-04-08 22:17:40
 */
public class NextTreeNode {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode != null) {
            // 右节点不为空，返回右节点的最左节点
            if (pNode.right != null) {
                TreeLinkNode node = pNode.right;
                while(node.left != null){
                    node = node.left;
                }
                return node;
            } 
            // 如果右节点为空，向上寻找。直到找到节点为父节点左孩子的结点。因为没有右节点意味着当前节点是某棵树中序遍历
            // 的最后一个节点，需要找到这棵树的父亲节点。
            while(pNode.parent != null && pNode.parent.left != pNode){
                pNode = pNode.parent;
            }
            // while 不满足即无父节点或节点为父节点的左孩子节点，直接返回父节点即可
            return pNode.parent;
        }
        return null;
    }
}