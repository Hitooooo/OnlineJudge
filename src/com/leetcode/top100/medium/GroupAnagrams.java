package com.leetcode.top100.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array of strings, group anagrams together.
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。 Input : ["eat", "tea", "tan",
 * "ate", "nat", "bat"], Output : [ ["ate","eat","tea"], ["nat","tan"], ["bat"]
 * ]
 * 
 * @author hitomeng
 * @date 2019/09/07
 */
public class GroupAnagrams {

    /**
     * 写一个算法，将具有相同字符（可不同顺序）的字符串映射成相同的字符串，然后通过Map的put操作
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        if (strs == null || strs.length < 1) {
            return result;
        }
        for (String str : strs) {
            //Arrays.sort(charArr);
            String tempKey = encoding(str);

            /*
             * if (map.keySet().contains(tempKey)) { // 这里直接获取引用 map.get(tempKey).add(str);
             * } else { ArrayList<String> list = new ArrayList<String>(); list.add(str);
             * map.put(tempKey, list); }
             */
            if (!map.keySet().contains(tempKey)) {
                map.put(tempKey, new ArrayList<>());
            }
            map.get(tempKey).add(str);
        }
        for (String key : map.keySet()) {
            result.add(map.get(key));
        }
        return result;
    }
    /**
     * 上面造成时间复杂度过高，是因为Sort排序最快也得是 o(nlogn)
     * 有没有什么办法可以做唯一映射，但是时间复杂度没那么高？总共就26个字母，你有什么想法嘛？
     * 
     * 好像并没有减少多少...
     */
    public String encoding(String str){
        int[] count = new int[26];
        char[] charArr = str.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            int countIndex = charArr[i] - 'a';
            count[countIndex] ++; 
        }
        StringBuilder sb = new StringBuilder();
        for(int c : count){
            sb.append("#");
            sb.append(c);
        }
        return sb.toString();
    }
}