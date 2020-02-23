import Entity.ListNode;

import java.util.PriorityQueue;

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class LeetCode_21_564 {

    public static void main(String[] args) {

        int[] a = {1,2,4};
        int[] b = {1,3,4};
        ListNode l1 = constructListNode(a);
        ListNode l2 = constructListNode(b);

//        ListNode listNode1 = mergeTwoLists1(l1, l2);
        ListNode listNode2 = mergeTwoLists2(l1, l2);
    }

    /**
     * 递归
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        // 谁到了末尾就返回另外一个链表，因为后面不需要进行比较
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        // 谁小谁往挪，因为小的next，肯定是大的
        else if (l1.var < l2.var) {
            l1.next = mergeTwoLists1(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists1(l1, l2.next);
            return l2;
        }
    }

    /**
     * 迭代
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        // 定义一个哨兵头链表
        ListNode prevhead = new ListNode(-1);
        ListNode pre = prevhead;
        while (l1 != null && l2 != null) {
            if (l1.var < l2.var) {
                pre.next = l1;
                pre = l1;
                l1 = l1.next;
            }else {
                pre.next = l2;
                pre = l2;
                l2 = l2.next;
            }
        }
        pre.next = l1 == null ? l2 : l1;
        return prevhead.next;
    }

    private static ListNode constructListNode(int[] nums){
        ListNode first = null;
        ListNode last = null;
        for (int n : nums) {
            ListNode newNode = new ListNode(n);
            if (first == null) {
                first = newNode;
                last = newNode;
            } else {
                last.next = newNode;
                last = newNode;
            }
        }
        return first;
    }


}
