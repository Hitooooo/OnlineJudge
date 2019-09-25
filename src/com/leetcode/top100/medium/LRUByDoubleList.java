package com.leetcode.top100.medium;

/**
 * 通过双向链表和HashMap实现的LRU算法
 */
public class LRUByDoubleList {

    /**
     * 双向链表，remove addFirst removeLast
     */
    public class DoubleList {

        private Node head;

        private Node tail;

        private int size;

        public DoubleList() {
            head = new Node(0, 0);
            head.next = head;
            head.pre = head;
            tail = head;
        }

        public void remove(Node node) {
            if (node == head) {
                return;
            }
            if (node == tail) {
                removeLast();
                return;
            }
            node.pre.next = node.next;
            node.next.pre = node.pre;
            size--;
        }

        public void addFirst(Node node) {
            head.next.pre = node;
            node.next = head.next;
            head.next = node;
            node.pre = head;
            size++;
        }

        public Node removeLast() {
            if (tail == head) {
                return null;
            }
            Node temp = tail;
            tail = tail.pre;
            tail.next = null;
            size--;
            return temp;
        }

        public int size() {
            return size;
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