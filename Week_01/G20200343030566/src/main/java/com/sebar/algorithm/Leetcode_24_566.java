package com.sebar.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liguang@youxin.com
 * @Date 2020/2/13
 * @Description
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 *  
 *
 * 示例:
 *
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
 */
public class Leetcode_24_566 {

    /**
     * 采用分组的形式进行倒过来
     *
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        List<List<ListNode>> groupNodeList = new ArrayList<>();
        if (head == null || head.next == null) {
            return head;
        }
        int i = 0;
        ListNode first = null;
        while (head != null) {
            if (i == 0) {
                first = new ListNode(head.val);
                i++;
                if (head.next == null) {
                    // 一个组成一组
                    List<ListNode> newList = Arrays.asList(first);
                    groupNodeList.add(newList);
                }
            } else if (i == 1) {
                List<ListNode> newList = Arrays.asList(new ListNode(head.val), first);
                groupNodeList.add(newList);
                i = 0;
            }
            head = head.next;
        }

        ListNode newListNode = null;
        ListNode lastListNode = null;
        for (List<ListNode> listNodes : groupNodeList) {
            if (listNodes.size() == 2) {
                ListNode firstNode = listNodes.get(0);
                ListNode secondNode = listNodes.get(1);

                firstNode.next = secondNode;
                if (lastListNode == null) {
                    newListNode = firstNode;
                } else {
                    lastListNode.next = firstNode;
                }
                lastListNode = secondNode;
            } else {
                ListNode firstNode = listNodes.get(0);
                lastListNode.next = firstNode;
            }
        }
        return newListNode;
    }

    /**
     * 递归求解
     * @param head
     * @return
     */
    public ListNode recursiveSolution(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode firstNode = head;
        ListNode secondNode = head.next;

        firstNode.next=recursiveSolution(secondNode.next);
        secondNode.next=firstNode;

        return secondNode;
    }

    static class ListNode {
        int val;
        ListNode next;

        /**
         * 构造函数
         *
         * @param val
         * @return
         */
        ListNode(int val) {
            this.val = val;
        }
    }
}
