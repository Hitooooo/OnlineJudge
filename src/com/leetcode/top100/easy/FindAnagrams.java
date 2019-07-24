package com.leetcode.top100.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 * <p>
 * Strings consists of lowercase English letters only and the length of both
 * strings s and p will not be larger than 20,100.
 * <p>
 * The order of output does not matter.
 *
 * @author HitoM
 * @date 2019/4/13 15:22
 **/
public class FindAnagrams {

    /**
     * Time Limit Exceeded
     */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            String count = p;
            for (int j = i; j < i + p.length() && j < s.length(); j++) {
                if (count.contains(s.charAt(j) + "")) {
                    count = count.replaceFirst(s.charAt(j) + "", "");
                } else {
                    break;
                }
                if (count.length() == 0) {
                    integers.add(i);
                }
            }
        }
        return integers;
    }

    /**
     * 移动窗口,此方法不是固定窗口。
     * 思想：移动end，直到找到完全包含字串，这时再移动begin，移动begin的目的是将破坏的map恢复成可让end所指进行下一
     * 次比较的状态。在恢复时候判断我们需要保存的结果。
     *
     * 1, 将寻找字串保存在HashMap中，key：字符 value：字符重复次数
     * 2，声明左右指针和 Counter（用来判断比对完成）
     * 3. 循环s（判断条件为右指针）
     *      循环体内部1. 右指针处判断是否包含，包含修改map
     *              2. 判断后右指针自增
     *              3. 当counter为零，map中的都已匹配上。
     *                  根据begin来恢复map。如果begin存在，添加到map中value+1。只有value大于零的时候count才+1，因为
     *                  counter代表的是 p中字符不同种类数
     *
     */
    public List<Integer> findAnagrams2(String s, String p) {
        if (s == null || p == null) {
            return null;
        }
        if (s.length() < p.length()) {
            return null;
        }

        ArrayList<Integer> integers = new ArrayList<>();
        HashMap<Character, Integer> pMap = new HashMap<>();
        char[] chars = p.toCharArray();
        for (char c : chars) {
            pMap.put(c, pMap.getOrDefault(c, 0) + 1);
        }
        int begin = 0;
        int end = 0;
        int counter = pMap.size();

        while (end < s.length()) {
            char current = s.charAt(end);
            if (pMap.containsKey(current)) {
                pMap.put(current, pMap.get(current) - 1);
                if (pMap.get(current) == 0) {
                    counter--;
                }
            }
            end++;
            while (counter == 0) {
                char charOldest = s.charAt(begin);
                if (pMap.containsKey(charOldest)) {
                    pMap.put(charOldest, pMap.get(charOldest) + 1);
                    if(pMap.get(charOldest) > 0){
                        counter++;
                    }
                }

                if (end - begin == p.length()) {
                    integers.add(begin);
                }
                begin++;
            }
        }

        return integers;
    }

}
