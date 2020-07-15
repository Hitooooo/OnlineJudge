package com.leetcode.dp;

import com.common.util.TreeUtils;
import com.google.common.collect.Lists;
import com.leetcode.struct.TreeNode;
import org.junit.Test;

import java.util.ArrayList;

/**
 * 打家劫舍 1 2 3
 *
 * @author HitoM
 * @date 2020/7/15 9:54
 **/
public class Rob {
    public int rob(TreeNode root) {
        if(root == null){
            return 0;
        }
        int notCurr = rob(root.left) + rob(root.right);
        int curr = root.val;
        if(root.left != null){
            curr += rob(root.left.left) + rob(root.left.right);
        }
        if(root.right != null){
            curr+= rob(root.right.left) + rob(root.right.right);
        }
        return Math.max(curr, notCurr);
    }

    @Test
    public void  test(){
        ArrayList<Integer> integers = Lists.newArrayList(3, 2, 3, null, 3, null, 1);
        Integer[] treeSource = new Integer[7];
        TreeNode treeNode = TreeUtils.toTree(integers.toArray(treeSource));
        int res = rob(treeNode);
        System.out.println(res);
    }

}
