package com.leetcode.offer.sword;

public class Solution5 {
    public String replaceSpace(String s) {
        if(s == null || s.length() < 1){
            return s;
        }
        return s.replace(" ", "%20");
    } 
}