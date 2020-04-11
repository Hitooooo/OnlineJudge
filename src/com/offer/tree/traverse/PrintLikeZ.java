package com.offer.tree.traverse;

import java.util.ArrayList;
import java.util.LinkedList;

import com.leetcode.struct.TreeNode;

import org.junit.Test;

/**
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印， 第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 * 
 * @author hitomeng
 * @date 2020-04-11 11:34:14
 */
public class PrintLikeZ {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (pRoot == null) {
            return res;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        boolean isMoveRight = true;
        int remain = 1;
        int nextRemain = 0;
        queue.addLast(pRoot);
        LinkedList<Integer> tempList = new LinkedList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.removeFirst();
            remain--;
            if (isMoveRight) {
                tempList.addLast(node.val);
            } else {
                tempList.addFirst(node.val);
            }
            if (node.left != null) {
                queue.add(node.left);
                nextRemain++;
            }
            if (node.right != null) {
                queue.add(node.right);
                nextRemain++;
            }
            if (remain == 0) {
                remain = nextRemain;
                nextRemain = 0;
                isMoveRight = !isMoveRight;
                res.add(new ArrayList<>(tempList));
                tempList.clear();
            }
        }
        return res;
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(8);
        TreeNode n1 = new TreeNode(6);
        TreeNode n2 = new TreeNode(10);
        root.left = n1;
        root.right = n2;
        n1.left = new TreeNode(5);
        n1.right = new TreeNode(7);

        n2.left = new TreeNode(100);
        n2.right = new TreeNode(200);

        ArrayList<ArrayList<Integer>> res = Print(root);
        System.out.println(res);
    }
}