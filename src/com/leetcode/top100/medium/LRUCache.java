package com.leetcode.top100.medium;

import java.util.LinkedHashMap;

/**
 * 使用java自带的LinkedHashMap实现LRU算法
 * 
 * @author  hitomeng
 * @date    2019/09/25
 */
public  class LRUCache extends LinkedHashMap<Integer, Integer>{

    private int mCapacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75F, true);
        this.mCapacity = capacity;
    }
    
    public int get(int key) {
        return super.getOrDefault(key, -1);
    }
    
    public void put(int key, int value) {
        super.put(key, value);
    }
    
    @Override
    protected boolean removeEldestEntry(java.util.Map.Entry<Integer, Integer> eldest) {
        return super.size() > mCapacity;
    }
}