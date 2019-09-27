package com.leetcode;

import com.leetcode.top100.medium.LRUByDoubleList;

/**
 * @author Mht
 */
public class Main {

    public static void main(String[] args) {
        LRUByDoubleList list = new LRUByDoubleList(2);
        list.put(1, 1);
        list.put(2, 2);
        int n1 = list.get(1);
        list.put(3, 3);
        int n2 = list.get(2);
        list.put(4, 4);
        int n3 = list.get(1);
        int n4 = list.get(3);
        int n5 = list.get(4);
    }
}
