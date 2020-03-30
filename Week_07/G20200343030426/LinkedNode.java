package com.ping.leetcode.medium.LRUCache146;

/**
 * @Author: 高一平
 * @Date: 2020/3/29
 * @Description:
 **/
public class LinkedNode {
    private int key;
    private int value;
    /**
     * 前驱结点
     */
    private LinkedNode prev;
    /**
     * 后继结点
     */
    private LinkedNode next;

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public LinkedNode getPrev() {
        return prev;
    }

    public void setPrev(LinkedNode prev) {
        this.prev = prev;
    }

    public LinkedNode getNext() {
        return next;
    }

    public void setNext(LinkedNode next) {
        this.next = next;
    }

}
