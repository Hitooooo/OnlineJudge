package com.leetcode.top100.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.leetcode.struct.TreeNode;

import org.junit.Test;

/**
 * 二叉树的层序遍历
 * 
 * @author hitomeng
 * @since 2019/09/21
 */
public class BTLLevelOrderTravelsal {

    public List<List<Integer>> levelOrderRecursive(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        helper(root, 0, result);
        return result;
    }

    private void helper(TreeNode root, int level, List<List<Integer>> result) {
        if(root == null){
            return;
        }
        // 还没到过这层，新加一层
        if(level < result.size()){
            result.add(new ArrayList<Integer>());
        }
        result.get(level).add(root.val);
        helper(root.left, level+1, result);
        helper(root.right, level+1, result);
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()) {
            result.add(new ArrayList<Integer>());
            int levelLength = queue.size();
            for (int i = 0; i < levelLength; i++) {
                TreeNode node = queue.poll();
                result.get(level).add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            level++;
        }
        return result;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return result;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> temp = new ArrayList<Integer>();
            List<TreeNode> levelNodes = new ArrayList<>(queue);
            for (TreeNode node : queue) {
                temp.add(node.val);
            }
            result.add(temp);
            queue.clear();
            for (TreeNode levelNode : levelNodes) {
                if (levelNode.left != null) {
                    queue.offer(levelNode.left);
                }
                if (levelNode.right != null) {
                    queue.offer(levelNode.right);
                }
            }
        }
        return result;
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(9);
        TreeNode right = new TreeNode(20);
        root.left = left;
        root.right = right;

        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);
        right.left = node15;
        right.right = node7;

        levelOrder2(root);
    }
}