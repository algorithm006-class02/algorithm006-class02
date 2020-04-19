package com.ping.leetcode.medium.LRUCache146;

import java.util.Hashtable;

/**
 * @Author: 高一平
 * @Date: 2020/3/29
 * @Description: 运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制。
 * 它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 * <p>
 * 进阶:
 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
 * <p>
 * 示例:
 * LRUCache cache = new LRUCache(2);  // 2 缓存容量
 * cache.put(1, 1);
 * cache.put(2, 2);
 * cache.get(1);       // 返回  1
 * cache.put(3, 3);    // 该操作会使得密钥 2 作废
 * cache.get(2);       // 返回 -1 (未找到)
 * cache.put(4, 4);    // 该操作会使得密钥 1 作废
 * cache.get(1);       // 返回 -1 (未找到)
 * cache.get(3);       // 返回  3
 * cache.get(4);       // 返回  4
 **/
public class LRUCache146 {

    /**
     * 目前缓存中数据的数量
     */
    private int size;
    /**
     * 缓存的最大容量
     */
    private int capacity;
    /**
     * 可以再O(1)时间内取出指定数据
     */
    private Hashtable<Integer, LinkedNode> cache = new Hashtable<Integer, LinkedNode>();

    /**
     * 定义缓存链表头尾--哨兵模式
     * 可以省去头尾增删操作中的空指针相关判断
     */
    private LinkedNode head, tail;

    public LRUCache146(int capacity) {
        this.size = 0;
        this.capacity = capacity;

        head = new LinkedNode();
        tail = new LinkedNode();
        head.setNext(tail);
        tail.setPrev(head);
    }

    public int get(int key) {
        LinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        } else {
            moveToHead(node);
            return node.getValue();
        }
    }

    public void put(int key, int value) {
        LinkedNode node = cache.get(key);
        if (node == null) {
            // 缓存中无此数据，将此数据插入，需注意，若已到缓存上限，需移除链表尾端数据
            LinkedNode newNode = new LinkedNode();
            newNode.setKey(key);
            newNode.setValue(value);

            cache.put(key, newNode);
            addNode(newNode);
            ++size;
            validCache();
        } else {
            // 缓存中已有数据，将此数据取出并插入到链表前面
            node.setValue(value);
            moveToHead(node);
        }
    }

    /**
     * 添加结点
     *
     * @param node
     */
    private void addNode(LinkedNode node) {
        node.setPrev(head);
        node.setNext(head.getNext());

        head.getNext().setPrev(node);
        head.setNext(node);
    }

    /**
     * 删除结点
     *
     * @param node
     */
    private void removeNode(LinkedNode node) {
        LinkedNode prev = node.getPrev();
        LinkedNode next = node.getNext();
        prev.setNext(next);
        next.setPrev(prev);
    }

    /**
     * 若缓存已达上限，则需移除尾端数据
     */
    private void validCache() {
        if (size > capacity) {
            LinkedNode popNode = popTail();
            cache.remove(popNode.getKey());
            --size;
        }
    }

    /**
     * @param node
     */
    private void moveToHead(LinkedNode node) {
        removeNode(node);
        addNode(node);
    }

    /**
     * 移除尾端元素
     *
     * @return
     */
    private LinkedNode popTail() {
        LinkedNode node = tail.getPrev();
        removeNode(node);
        return node;
    }

}
