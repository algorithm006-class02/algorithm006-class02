package com.sebar.algorithm;

/**
 * @author liguang@youxin.com
 * @Date 2020/2/15
 * @Description
 */
public class Leetcode_641_566 {
    /**
     * Maximum number of items in the deque
     */
    private final int capacity;
    /**
     * 头结点
     */
    private int headPoint;
    /**
     * 尾节点
     */
    private int tailPoint;
    /**
     * 存储元素的数组
     */
    private int[] nums;

    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */
    public Leetcode_641_566(int k) {
        // 多一个空的位置，因为tailPoint=headPoint时代表数组为空，则需要有一个空位置，
        // 避免数组已满的时候两者重合
        this.capacity = k + 1;
        this.headPoint = 0;
        this.tailPoint = 0;
        nums = new int[capacity];
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
        if (isFull()) {
            // 已满不能再添加元素
            return false;
        }
        // 添加在前面，则前置指针前移一位，如果已经到0的位置，则置于队尾，如果已经到队尾，置于0的位置
        headPoint = (headPoint + capacity - 1) % capacity;
        nums[headPoint] = value;
        return true;
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        if (isFull()) {
            // 已满不能再添加元素
            return false;
        }

        //添加到尾指针后面，尾指针到底队尾，则变为0，
        nums[tailPoint] = value;
        tailPoint = (tailPoint + 1) % capacity;
        return true;
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        nums[headPoint] = 0;
        headPoint = (headPoint + 1) % capacity;
        return true;
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        // 将值置为0，标识删除了，
        nums[tailPoint] = 0;
        tailPoint = (tailPoint + capacity - 1) % capacity;
        return true;
    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return nums[headPoint];
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        if (isEmpty()) {
            throw new IllegalArgumentException();
        }
        return nums[(tailPoint - 1 + capacity) % capacity];
    }

    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
        // 当前元素是不是为0个
        return headPoint == tailPoint ? true : false;
    }

    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull() {
        // 当前元素个数是不是大于最大容积
        return (tailPoint + 1) % capacity == headPoint ? true : false;
    }
}
