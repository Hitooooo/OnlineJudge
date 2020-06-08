package com.leetcode.readily;

import org.junit.Test;

/**
 * 前缀树
 * 
 * @author hitomeng
 * @since 2020-06-08 08:32:55
 */
public class TrieTree {

    private Node tree;

    /** Initialize your data structure here. */
    public TrieTree() {
        tree = new Node();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        if(word == null || word.length() < 1){
            return;
        }
        char[] caps = word.toCharArray();
        Node node = this.tree;
        for (int i = 0; i < caps.length; i++) {
            if(node.contains(caps[i])){
                node = node.getNode(caps[i]);
                continue;
            }else{
                node.add(caps[i]);
                node = node.getNode(caps[i]);
            }
        }
        node.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if(word == null || word.length() < 1){
            return false;
        }
        Node node = this.tree;
        char[] caps = word.toCharArray();
        for (int i = 0; i < caps.length; i++) {
            if(node.contains(caps[i])){
                node = node.getNode(caps[i]);
            }else{
                return false;
            }
        }
        return node.isEnd == true;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if(prefix == null || prefix.length() < 1){
            return false;
        }
        Node node = this.tree;
        char[] caps = prefix.toCharArray();
        for (int i = 0; i < caps.length; i++) {
            if(node.contains(caps[i])){
                node = node.getNode(caps[i]);
            }else{
                return false;
            }
        }
        return true;
    }

    class Node{
        Node[] nexts;
        boolean isEnd;

        public Node(){
            nexts = new Node[26];
            isEnd = false;
        }

        public boolean contains(char c){
            return nexts[c - 'a'] != null;     
        }

        public Node getNode(char c){
            return nexts[c - 'a'];
        }

        public void add(char c){
            nexts[c - 'a'] = new Node();
        }
    }

    @Test
    public void test(){
        TrieTree tree = new TrieTree();
        tree.insert("word");
        System.out.println(tree.search("word"));
        System.out.println(tree.search("wordx"));
        System.out.println(tree.search("wor"));
        System.out.println(tree.startsWith("worddd"));
    }
}