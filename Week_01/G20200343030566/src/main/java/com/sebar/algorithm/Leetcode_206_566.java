package com.sebar.algorithm;

import java.util.Stack;

/**
 * @author liguang@youxin.com
 * @Date 2020/2/13
 * @Description
 */
public class Leetcode_206_566 {
    public static void main(String[] args) {
        ListNode oneNode = new ListNode(1);
        ListNode twoNode = new ListNode(2);
        ListNode threeNode = new ListNode(3);
        ListNode fourNode = new ListNode(4);
        ListNode fifthNode = new ListNode(5);

        oneNode.next = twoNode;
        twoNode.next = threeNode;
        threeNode.next = fourNode;
        fourNode.next = fifthNode;
        fifthNode.next = null;

        Leetcode_206_566 solutionOne = new Leetcode_206_566();
//        ListNode listNode = solutionOne.reverseList(oneNode);
//        ListNode listNode2 = solutionOne.solutionTwo(oneNode);
//        ListNode listNode2 = solutionOne.recursiveSolution(oneNode);
        ListNode listNode = solutionOne.twoPointSolution(oneNode);
        System.out.println(1);
    }

    /**
     * 反转链表
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode lastHeadListNode = null;
        ListNode newListNode = null;
        int i = 0;
        while (head != null) {
            ListNode nowNode = head;

            // 当前头指针不为空的情况下，将头指针赋值给最新的下一个节点
            if (lastHeadListNode != null) {
                newListNode = new ListNode(nowNode.val);
                newListNode.next = lastHeadListNode;
            }

            // 第一次进来，要将头节点的next置空
            if (i == 0) {
                // 代表第一个头结点
                newListNode = new ListNode(nowNode.val);
                newListNode.next = null;
                i++;
            }
            // 下一个节点进行赋值
            head = head.next;
            lastHeadListNode = newListNode;
        }
        return newListNode;
    }

    /**
     * 采用栈进行反转
     * 借用栈先进后出的特性
     *
     * @return
     */
    public ListNode solutionTwo(ListNode head) {
        Stack stack = new Stack();
        // 将node元素全部推入占中
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        // 全部推入栈后，一个个出栈
        ListNode newListNode = null;
        ListNode nowNode = null;
        while (!stack.empty()) {
            ListNode listNode = (ListNode) stack.pop();
            if (listNode.next != null) {
                listNode.next = null;
            }
            if (newListNode == null) {
                newListNode = listNode;
                nowNode = newListNode;
            } else if (newListNode != null) {
                nowNode.next = listNode;
                nowNode = nowNode.next;
            }
        }
        return newListNode;
    }

    /**
     * 下一个元素的next指针要指回当前节点
     */
    public ListNode recursiveSolution(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newNode = recursiveSolution(head.next);
        head.next.next = head;
        head.next = null;
        return newNode;
    }

    public ListNode twoPointSolution(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
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

        ListNode() {
        }
    }
}
