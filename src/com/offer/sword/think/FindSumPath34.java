package com.offer.sword.think;

import java.util.ArrayList;

import com.leetcode.struct.TreeNode;

import org.junit.Test;

/**
 * 输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
 */
public class FindSumPath34 {
    /**
     * 
     * @param root   二叉树
     * @param target 目标和
     * @return 路径集合
     */
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (root == null || root.val > target) {
            return res;
        }
        find(res, new ArrayList<>(), root, target, 0);
        return res;
    }

    /**
     * 深度遍历的过程中，保留累积和，如果sum==target并且当前结点是叶子结点，那么就找到路径并添加到结果集中。
     * 回溯法
     *  
     * @param res 用来保存多个满足条件的路径结果
     * @param path 深度过程中构建的路径
     * @param node 遍历的当前节点
     * @param target 目标和
     * @param sum 当前已经累积的和
     */
    private void find(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> path, TreeNode node, int target, int sum) {
        path.add(node.val);
        if(sum + node.val > target){
            path.remove(path.size() -1);
            return;
        }
        sum = sum + node.val;
        if(sum == target && node.left == null && node.right == null){
            // 满足条件添加path到结果，这里一定要new
            res.add(new ArrayList<>(path));
            return ;
        }
        // 继续向左右孩子节点寻找
        if(node.left != null){
            find(res, path, node.left, target, sum);
            // 不管是否有结果，下一层会在路径中添加当前节点, 为了下一步右孩子不会重复添加,需要删除
            path.remove(path.size() -1);
        }
        if (node.right != null) {
            find(res, path, node.right, target, sum);
            // 删除下一层添加的节点 
            path.remove(path.size() -1);
        }
    }

    @Test
    public void test(){
        TreeNode root = new TreeNode(10);
        root.right = new TreeNode(12);

        TreeNode n1 = new TreeNode(5);
        n1.left = new TreeNode(4);
        n1.right = new TreeNode(7);
        root.left = n1;

        ArrayList<ArrayList<Integer>> res = FindPath(root, 22);
        System.out.println(res);
    }
}