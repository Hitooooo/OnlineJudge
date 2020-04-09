package com.leetcode.struct;

/**
 * Tree Node,并且有指向父亲指针
 *
 * @author HitoM
 * @date 2019/4/1 10:21
 */
public class TreeLinkNode {
    public int val;
    public TreeLinkNode left;
    public TreeLinkNode right;
    public TreeLinkNode parent;
    public TreeLinkNode(int x) { val = x; }
}