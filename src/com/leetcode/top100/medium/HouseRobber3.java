package com.leetcode.top100.medium;

import com.leetcode.struct.TreeNode;

/**
 * 打家劫舍第三版。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。
 * 一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。
 * 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
 * 
 * @author hitomeng
 * @date 2019/11/5
 */
public class HouseRobber3 {

    /**
     * dp[i] = max(dp[l]+dp[r], node[i].val + dp[ll]+dp[lr]+dp[rl]+dp[rr])
     * 节点i的最好金额。问题的关键：如何处理初始状态，如何记录金额？从公式中可以发现，父节点是依赖于子节点的，那么可以自下而上
     * 考虑问题。用node.val记录其最大金额，因为父节点依赖于子节点，所以返回值不能是int。
     */
    public int rob(TreeNode root) {
        return helper(root).val;
    }

    /**
     * 在树状dp中同样，我们需要将每一个非叶结点作为根节点的子树构造成一棵三层满二叉树方便运算。
     * 对于叶子结点，我们给其添加值为0的左右子结点。对于左/右子树为空的非叶节点，我们在其左/右添加一棵两层值为0的满二叉树
     */
    private TreeNode helper(TreeNode root) {
        if (root == null) {
            TreeNode node = new TreeNode(0);
            return helper(node);
        }

        // 因为会去算dp[ll] dp[lr]...,所以所有叶子节点必须有子节点以统一操作
        if (root.left == null && root.right == null) {
            root.left = new TreeNode(0);
            root.right = new TreeNode(0);
            return root;
        }

        root.left = helper(root.left);
        root.right = helper(root.right);

        root.val = Math.max(root.left.val + root.right.val, root.val + root.left.left.val+root.left.right.val+root.right.left.val+root.right.right.val);
        return root;
    }
}