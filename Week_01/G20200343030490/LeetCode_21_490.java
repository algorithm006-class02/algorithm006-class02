/**
 * @author:
 * @Date: 2020-02-14 18:02
 * @Copyright: 2019 www.lenovo.com Inc. All rights reserved.
 */


//将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
//
// 示例：
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
//
// Related Topics 链表


//leetcode submit region begin(Prohibit modification and deleti

public class LeetCode_21_490 {


    //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 使用哨兵模式 简化判断操作。
     */
    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode solied = new ListNode(-1);
            ListNode p = solied;
            while(l1 != null && l2 != null) {
                if(l1.val < l2.val) {
                    p.next = l1;
                    l1 = l1.next;
                }else {
                    p.next = l2;
                    l2 = l2.next;
                }
                p = p.next;
            }

            if(l1 == null) {
                p.next = l2;
            }else{
                p.next = l1;
            }
            return solied.next;
        }
    }

}
