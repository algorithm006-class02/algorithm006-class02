package Week_01.G20200343030576;

public class LeetCode_21_G20200343030576 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 1. 终止条件
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        // 2. 递归过程
        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }

        // 3. 返回值
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
