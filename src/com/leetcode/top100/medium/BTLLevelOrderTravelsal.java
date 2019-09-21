package com.leetcode.top100.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.leetcode.struct.TreeNode;

/**
 * 二叉树的层序遍历
 * 
 * @author hitomeng
 * @since 2019/09/21
 */
public class BTLLevelOrderTravelsal{
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        if(root == null){
            return result;
        }
        queue.offer(root);
        while(!queue.isEmpty()){
            List<Integer> temp = new ArrayList<Integer>();
            for (TreeNode node : queue) {
                temp.add(node.val);
            }
            temp.clear();
        }
        return result;
    }
}