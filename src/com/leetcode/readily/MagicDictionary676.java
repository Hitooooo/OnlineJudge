package com.leetcode.readily;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class MagicDictionary676 {

    private Map<Integer, java.util.List<String>> buckets;

     /** Initialize your data structure here. */
     public MagicDictionary676() {
        buckets = new HashMap<>();
    }
    
    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for (String string : dict) {
            buckets.computeIfAbsent(string.length(), x -> new ArrayList<String>()).add(string);
        }
    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        int len = word.length();
        if(!buckets.containsKey(len)){
            return false;
        }
        List<String> caps = buckets.get(len);
        for (String string : caps) {
            int mismatch = 0;
            for (int i = 0; i < word.length(); ++i) {
                if (word.charAt(i) != string.charAt(i)) {
                    if (++mismatch > 1) break;
                }
            }
            if (mismatch == 1) return true;
        }
        return false;
    }
}