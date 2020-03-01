package com.leetcode.base;

public class MergeTwoLists {
    /**
     * 题三：合并两个有序链表
     * 方法一：递归
     * 思路：排序好的链表头与val值比较小的相接，直到l1或者l2为空递归结束
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists_1(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }else if(l1.val < l2.val){
            l1.next = mergeTwoLists_1(l1.next, l2);
            return l1;
        }else{
            l2.next = mergeTwoLists_1(l1, l2.next);
            return l2;
        }
    }

    /**
     * 题三：合并两个有序链表
     * 方法一：迭代
     * 注意点：新建一个链表，需要辅助结点cur来完成链表结点的相接，不能直接返回cur.next,
     * 因为cur已指向链表最后。操作链表时常常需要一个辅助结点来完成遍历、插入、删除等操作。
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists_2(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        while (l1 != null && l2 != null) {
            if(l1.val < l2.val){
                cur.next = l1;
                l1 = l1.next;
            }else{
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 == null ? l2 : l1;
        return head.next;
    }
}

class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
    }
}
