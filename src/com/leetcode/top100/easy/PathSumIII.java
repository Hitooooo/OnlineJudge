package com.leetcode;

import com.leetcode.struct.TreeNode;

/**
 * You are given a binary tree in which each node contains an integer value.
 * <p>
 * Find the number of paths that sum to a given value.
 * <p>
 * The path does not need to start or end at the root or a leaf, but it must go downwards
 * (traveling only from parent nodes to child nodes).
 * <p>
 * The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
 *
 * @author HitoM
 * @date 2019/4/13 13:56
 **/
public class PathSumIII {

    /**
     * WRONG! 每个结点应该当作一个root来算有多少种可能，而不是若root等于sum则 1+root.left+root.right
     */
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        if (root.val == sum) {
            return 1 + pathSum(root.left, sum) + pathSum(root.right, sum);
        } else {
            return pathSum(root.left, sum - root.val) + pathSum(root.right, sum - root.val);
        }
    }

    public int pathSum2(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }

        return helper(root, sum) + pathSum2(root.right, sum) + pathSum2(root.left, sum);
    }

    public int helper(TreeNode root, int sum) {
        int res = 0;
        if(root == null)
            return res;
        if(sum == root.val)
            res++;
        res += helper(root.left, sum - root.val);
        res += helper(root.right, sum - root.val);
        return res;
    }
}
