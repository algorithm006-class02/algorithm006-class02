package algorithm.leetCode.geek.No21;

/**
 * @author ltw
 * on 2020-02-14.
 */
class Solution {
    //solution1: 时间复杂度 O(m+n) 空间复杂度O(n)
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode mergedList = new ListNode(-1);
        ListNode head = mergedList;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                mergedList.next = l1;
                l1 = l1.next;
            } else {
                mergedList.next = l2;
                l2 = l2.next;
            }
            mergedList = mergedList.next;

        }
        mergedList.next = (l1 == null ? l2 : l1);

        return head.next;
    }

    //solution2: 时间复杂度 O(n+m) 空间复杂度 O(n+m)  //need review
//    class Solution {
//        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//            if(l1 == null) {
//                return l2;
//            }
//            if(l2 == null) {
//                return l1;
//            }
//
//            if(l1.val < l2.val) {
//                l1.next = mergeTwoLists(l1.next, l2);
//                return l1;
//            } else {
//                l2.next = mergeTwoLists(l1, l2.next);
//                return l2;
//            }
//        }
//    }

}
