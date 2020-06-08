package com.leetcode.readily;

import org.junit.Test;

public class MagicDictionary676 {

    private Node tree;
    private int correctChange = 1;
    /** Initialize your data structure here. */
    public MagicDictionary676() {
        tree = new Node();
    }

    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        if (dict == null) {
            return;
        }
        for (int i = 0; i < dict.length; i++) {
            insert(dict[i]);
        }
    }

    /**
     * Returns if there is any word in the trie that equals to the given word after
     * modifying exactly one character
     */
    public boolean search(String word) {
        if(word == null || word.length() < 1){
            return false;
        }
        Node node = this.tree;
        char[] caps = word.toCharArray();
        for (int i = 0; i < caps.length; i++) {
            if(node.contains(caps[i])){
                node = node.getNode(caps[i]);
            }else if(correctChange > 0){
                node = node.getNode(caps[i]);
                correctChange--;
            }else{
                return false;
            }
        }
        return node.isEnd == true;
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (word == null || word.length() < 1) {
            return;
        }
        char[] caps = word.toCharArray();
        Node node = this.tree;
        for (int i = 0; i < caps.length; i++) {
            if (node.contains(caps[i])) {
                node = node.getNode(caps[i]);
                continue;
            } else {
                node.add(caps[i]);
                node = node.getNode(caps[i]);
            }
        }
        node.isEnd = true;
    }

    class Node {
        Node[] nexts;
        boolean isEnd;

        public Node() {
            nexts = new Node[26];
            isEnd = false;
        }

        public boolean contains(char c) {
            return nexts[c - 'a'] != null;
        }

        public Node getNode(char c) {
            return nexts[c - 'a'];
        }

        public void add(char c) {
            nexts[c - 'a'] = new Node();
        }
    }

    @Test
    public void test(){
        MagicDictionary676 dictTree =  new MagicDictionary676();
        dictTree.buildDict(new String[]{"hello","leetcode"});
        dictTree.search("hello");
        dictTree.search("hhllo");
        dictTree.search("hell");
    }
}