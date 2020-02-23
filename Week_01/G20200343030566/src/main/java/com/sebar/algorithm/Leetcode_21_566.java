package com.sebar.algorithm;

/**
 * @author liguang@youxin.com
 * @Date 2020/2/14
 * @Description
 */
public class Leetcode_21_566 {

    /**
     * 思路：进行比较，如果相等，则将next指针进行更新，
     * 需要同时记录next指针的头部和尾部
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newNodeList = new ListNode(-1);
        ListNode prevNode = newNodeList;
        while (l1 != null && l2 != null) {
            if (l1.val >= l2.val) {
                prevNode.next = l2;
                // 移动较小的那根指针
                l2 = l2.next;
            } else {
                prevNode.next = l1;
                l1 = l1.next;
            }
            prevNode = prevNode.next;
        }

        // 有一边先行结束了
        prevNode.next = l1 == null ? l2 : l1;
        return newNodeList.next;
    }

    /**
     * 递归求解
     * @param l1
     * @param l2
     * @return
     */
    public ListNode recursiveSolution(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = recursiveSolution(l1.next, l2);
            return l1;
        } else {
            l2.next = recursiveSolution(l1, l2.next);
            return l2;
        }

    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
