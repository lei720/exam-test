package com.lei.problem3;

import java.util.HashMap;
import java.util.Map;

class MyLruCache {
    /**
     * 容量
     */
    int cap;
    /**
     * 缓存
     */
    Map<Integer, MyListNode> innerMap;
    /**
     * 用于操作最近最少使用节点
     */
    MyListNode head, tail;

    /**
     * 链表保证O(1)
     */
    private static class MyListNode {
        int key, value;
        MyListNode prev, next;

        MyListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public MyLruCache(int cap) {
        this.innerMap = new HashMap<Integer, MyListNode>();
        this.cap = cap;
    }

    public int get(int key) {
        /**
         * 得到最近使用的节点
         */
        MyListNode myListNode = innerMap.get(key);
        if (myListNode == null) {
            return -1;
        }
        /**
         * 将最近使用的节点插入头部
         */
        if (myListNode != head) {
            /**
             * 先删除
             */
            removeFromList(myListNode);
            /**
             * 再插入
             */
            insertToHeadList(myListNode);
        }

        return myListNode.value;
    }

    public void put(int key, int value) {
        removeFromLRuCache(key);
        /**
         * 装不下了，剔除长期未使用的节点
         */
        if (innerMap.size() >= cap && tail != null) {
            removeFromLRuCache(tail.key);
        }

        MyListNode myListNode = new MyListNode(key, value);
        insertToHeadList(myListNode);
        innerMap.put(key, myListNode);
    }

    void removeFromLRuCache(int key) {
        removeFromList(innerMap.get(key));
        innerMap.remove(key);
    }

    void removeFromList(MyListNode node) {
        if (node == null) {
            return;
        }

        if (node.prev != null) {
            node.prev.next = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        }

        if (node == tail) {
            tail = node.prev;
        }
        if (node == head) {
            head = node.next;
        }
    }

    /**
     * 如果师最近使用的节点,那么插入头接地
     * @param node
     */
    void insertToHeadList(MyListNode node) {
        if (head == null) {
            head = node;
            tail = node;
        } else {
            head.prev = node;
            node.next = head;
            head = node;
        }
    }
}