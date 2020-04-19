package week7;

import java.util.HashMap;
import java.util.Map;

/**
 * 146. LRU缓存机制
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 * <p>
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 * <p>
 * 进阶:
 * <p>
 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
 * <p>
 * https://leetcode-cn.com/problems/lru-cache/#/
 */
public class LRUCache {
    private int capacity;
    private Map<Integer, Node> map;
    private DoubleList list;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        list = new DoubleList();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            int value = map.get(key).value;
            put(key, value);
            return value;
        }
        return -1;
    }

    public void put(int key, int value) {
        Node x = new Node(key, value);
        if (map.containsKey(key)) {
            // 直接删除
            list.remove(map.get(key));
            list.addFirst(x);
            map.put(key, x);
        } else {
            // 插入
            if (list.size() == capacity) {
                // 满了，则删除最后一个元素，对应的map中的索引也一并删除
                Node node = list.removeLast();
                map.remove(node.key);
            }
            list.addFirst(x);
            map.put(key, x);
        }
    }

    private static class Node {
        int key;
        int value;
        Node pre;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private static class DoubleList {
        private Node head;
        private Node tail;
        private int size;

        public DoubleList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.pre = head;
            size = 0;
        }

        // 在链表头部添加节点 x
        public void addFirst(Node x) {
            Node next = head.next;
            x.next = next;
            x.pre = head;
            next.pre = x;
            head.next = x;

            size++;
        }

        // 删除链表中的 x 节点（x 一定存在）
        public void remove(Node x) {
            Node pre = x.pre;
            Node next = x.next;
            pre.next = next;
            next.pre = pre;

            size--;
        }

        // 删除链表中最后一个节点，并返回该节点
        public Node removeLast() {
            if (tail.pre == head)
                return null;
            Node last = tail.pre;
            remove(last);
            return last;
        }

        // 返回链表长度
        public int size() { return size; }
    }
}
