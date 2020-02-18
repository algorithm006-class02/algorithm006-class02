/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode tmp1 = l1;
        ListNode tmp2 = l2;
        ListNode tmp = new ListNode(-1);
        ListNode result = tmp;
        while(tmp2 != null || tmp1 != null) {
            if (tmp1 == null && tmp2 != null) {
                tmp.next = tmp2;
                tmp2 = tmp2.next;
            } else if (tmp1 != null && tmp2 == null) {
                tmp.next = tmp1;
                tmp1 = tmp1.next;
            } else if (tmp1.val >= tmp2.val) {
                tmp.next = tmp2;
                tmp2 = tmp2.next;
            } else if (tmp1.val < tmp2.val) {
                tmp.next = tmp1;
                tmp1 = tmp1.next;
            }
            tmp = tmp.next;
        }
        return result.next;
    }
}