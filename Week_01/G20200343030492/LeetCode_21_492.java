package Week_01.G20200343030492;

/**
 * LeetCode_21_492
 */
public class LeetCode_21_492 {

	/**
	 * 整体思路：递归。时间复杂度：O(N)，空间复杂度：O(1)
	 */
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l2 == null) return l1;
		if (l1 == null) return l2;
		if (l1.val < l2.val) {
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		} else {
			l2.next = mergeTwoLists(l1, l2.next);
			return l2;
		}
	}

	/**
	 * 整体思路：比较常规的做法，逐个对比两个链表节点，然后拼接成一条。时间复杂度：O(N)，空间复杂度：O(1)
	 */
	public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l2 == null) return l1;
        if (l1 == null) return l2;
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                cur = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                cur = l2;
                l2 = l2.next;
            }
        }
        if (l1 != null) {
            cur.next = l1;
        }
        if (l2 != null) {
            cur.next = l2;
        }
        return head.next;
    }
}