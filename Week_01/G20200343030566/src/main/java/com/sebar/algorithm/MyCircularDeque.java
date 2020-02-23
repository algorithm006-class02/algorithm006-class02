package com.sebar.algorithm;

/**
 * @author liguang@youxin.com
 * @Date 2020/2/14
 * @Description
 */
public class MyCircularDeque<E> {
    /**
     * Maximum number of items in the deque
     */
    private final int capacity;
    /**
     * 头结点
     */
    transient Node<E> firstNode;
    /**
     * 尾节点
     */
    transient Node<E> tailNode;
    /**
     * Number of items in the deque
     */
    private transient int count;
    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */
    public MyCircularDeque(int k) {
        this.capacity = k;
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
        // 先判断当前容量够不够，
        if (count > capacity) {
            // 容不下了
            return false;
        }
        // 当前节点
        Node newNode = new Node(value);
        // 旧的头结点
        Node first = firstNode;
        // 将当前最新节点设置为头节点，旧的头结点设置为新的头结点的下一个元素
        newNode.next = first;
        // 当前头结点更新
        firstNode = newNode;
        if (tailNode == null) {
            tailNode = newNode;
        } else {
            // 将旧头结点的前置节点指向现在新节点，构建双向指针
            first.prev = newNode;
        }
        ++count;
        return true;
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        // 先判断当前容量够不够，
        if (count > capacity) {
            // 容不下了
            return false;
        }
        // 最新的尾节点
        Node<E> lastNode = this.tailNode;
        // 需要添加到尾部的新节点
        Node newNode = new Node(value);
        // 将新元素的prev指向当前列表的最后一个节点
        newNode.prev = lastNode;
        // 更新最后一个指针
        tailNode = newNode;
        // 如果没有头结点
        if (firstNode == null) {
            firstNode = newNode;
        } else {
            // last节点存在时，将last的next指针指向最新元素
            lastNode.next = newNode;
        }

        ++count;
        return true;
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        // 当没有元素可以移除时，返回成功
        if (count == 0) {
            return true;
        }
        // 将头结点存放的值设置为null
        Node<E> firstNode = this.firstNode;
        firstNode.item = null;

        // 获取当前列表的头结点的下一个
        Node<E> firstNodeNextNode = firstNode.next;
        // 它代替原来的头结点成为新的头结点
        this.firstNode = firstNodeNextNode;

        if (firstNodeNextNode.next == null) {
            tailNode = null;
        } else {
            firstNodeNextNode.prev = null;
        }

        --count;
        return true;
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        // 当没有元素可以移除时，返回成功
        if (count == 0) {
            return true;
        }

        // 取出当前尾结点
        Node<E> lastNode = this.tailNode;
        lastNode.item = null;

        // 取出尾结点的上一个结点
        Node<E> tailNodePrevNode = lastNode.prev;
        // 将尾巴指针指向它
        this.tailNode = tailNodePrevNode;
        if (tailNodePrevNode.prev == null) {
            firstNode = null;
        } else {
            tailNodePrevNode.next = null;
        }

        --count;
        return true;
    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        if (count == 0) {
            throw new IllegalArgumentException();
        }
        Node<E> firstNode = this.firstNode;
        return (int) firstNode.item;
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        if (count == 0) {
            throw new IllegalArgumentException();
        }
        Node<E> tailNode = this.tailNode;
        return (int) tailNode.item;
    }

    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
        // 当前元素是不是为0个
        return count == 0 ? true : false;
    }

    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull() {
        // 当前元素个数是不是大于最大容积
        return count > capacity ? true : false;
    }

    /**
     * Doubly-linked list node class
     */
    static final class Node<E> {
        /**
         * The item, or null if this node has been removed.
         */
        E item;

        /**
         * One of:
         * - the real predecessor Node
         * - this Node, meaning the predecessor is tail
         * - null, meaning there is no predecessor
         */
        Node<E> prev;

        /**
         * One of:
         * - the real successor Node
         * - this Node, meaning the successor is head
         * - null, meaning there is no successor
         */
        Node<E> next;

        Node(E x) {
            item = x;
        }
    }

}
