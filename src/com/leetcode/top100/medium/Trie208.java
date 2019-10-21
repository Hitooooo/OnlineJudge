package com.leetcode.top100.medium;

import org.junit.Assert;
import org.junit.Test;

/**
 * 实现一个前缀树; Trie 树是一个有根的树，其结点具有以下字段： 1. 最多 RRR 个指向子结点的链接，其中每个链接对应字母表数据集中的一个字母。
 * 2. 本文中假定 RRR 为 26，小写拉丁字母的数量。布尔字段，以指定节点是对应键的结尾还是只是键前缀
 * 
 * @author hitomeng
 * @date 2019/10/10
 */
public class Trie208 {

    private TrieNode root;

    public Trie208() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = this.root;
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (!node.containsKey(chars[i])) {
                node.addLink(chars[i], new TrieNode());
            }
            node = node.get(chars[i]);
        }
        node.setEnd(true);
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = this.root;
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (node.containsKey(chars[i])) {
                node = node.get(chars[i]);
            }else{
                return false;
            }
        }
        return node.isEnd;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode node = this.root;
        char[] chars = prefix.toCharArray();
        int index = 0;
        for (int i = 0; i < chars.length; i++) {
            if (node.containsKey(chars[i])) {
                node = node.get(chars[i]);
                index++;
            }else{
                return false;
            }
        }
        return index == prefix.length();
    }

    public class TrieNode {
        private final int R = 26;
        private TrieNode[] links;
        private boolean isEnd;

        public TrieNode() {
            links = new TrieNode[R];
        }

        // 是否包含某个字符
        public boolean containsKey(char c) {
            return links[c - 'a'] != null;
        }

        // 新增下一级连接
        public void addLink(char c, TrieNode trieNode) {
            links[c - 'a'] = trieNode;
        }

        // 获取下一级连接
        public TrieNode get(char c) {
            return links[c - 'a'];
        }

        public boolean isEnd() {
            return this.isEnd;
        }

        public void setEnd(boolean end) {
            this.isEnd = end;
        }
    }

    @Test
    public void test(){
        Trie208 trie =  new Trie208();
        trie.insert("apple");
        Assert.assertTrue(trie.search("apple"));
        Assert.assertTrue(trie.startsWith("app"));
        trie.insert("app");
        Assert.assertTrue(trie.search("app"));
    }
}