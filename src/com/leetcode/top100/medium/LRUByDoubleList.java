package com.leetcode.top100.medium;

import java.util.HashMap;

import org.junit.Test;

/**
 * 通过双向链表和HashMap实现的LRU算法
 */
public class LRUByDoubleList {

    private int capacity;
    private HashMap<Integer, Node> cache;
    private DoubleList doubleList;

    public LRUByDoubleList(int capacity) {
        // 1. 初始化双向链表和HashMap
        cache = new HashMap<>(capacity);
        doubleList = new DoubleList();
        this.capacity = capacity;
    }

    public int get(int key) {
        // 存在，返回并将Node移动到链表头
        // 不存在，返回-1
        int value = -1;
        if (cache.keySet().contains(key)) {
            Node node = cache.get(key);
            doubleList.moveToHead(node);
            value = node.val;
        }
        return value;
    }

    public void put(int key, int value) {
        // 存在更新值，不存在判断是否能添加
        Node old = cache.get(key);
        if (old == null) {
            // 满了，删除最后一个，没满，添加到头
            Node newNode = new Node(key, value);
            if (doubleList.size() == capacity) {
                Node last = doubleList.removeLast();
                cache.remove(last.key);
            }
            cache.put(key, newNode);
            doubleList.add(newNode);
        } else {
            old.val = value;
            doubleList.moveToHead(old);
        }
    }

    /**
     * 双向链表，remove addFirst removeLast
     */
    public class DoubleList {

        // 引入头尾结点同意操作
        private Node head;

        private Node tail;

        private int size = 0;

        public DoubleList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            head.pre = tail;
            tail.next = head;
            tail.pre = head;
        }

        // head tail 是手动加的，默认不会删除
        public void remove(Node node) {
            if (isEmpty()) {
                return;
            }
            node.pre.next = node.next;
            node.next.pre = node.pre;
            size -= 1;
        }

        // 新增结点放在头部
        public void add(Node node) {
            head.next.pre = node;
            node.next = head.next;
            head.next = node;
            node.pre = head;
            size += 1;
        }

        public void moveToHead(Node node) {
            remove(node);
            add(node);
        }

        public Node removeLast() {
            if (isEmpty()) {
                return null;
            }
            Node temp = tail.pre;
            remove(temp);
            return temp;
        }

        public int size() {
            return size;
        }

        public boolean isEmpty() {
            return size == 0;
        }
    }

    /**
     * 双向链表中的结点定义
     */
    public class Node {
        public int key;
        public int val;
        public Node next;
        public Node pre;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}