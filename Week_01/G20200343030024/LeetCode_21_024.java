class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
      ListNode result = new ListNode(-1);
        ListNode currentIndex = result;

        ListNode indexL1 = l1;
        ListNode indexL2 = l2;

        for (; indexL1 != null && indexL2 != null; ) {
            ListNode node;
            if (indexL1.val >= indexL2.val) {
                node = new ListNode(indexL2.val);
                indexL2 = indexL2.next;
            } else {
                node = new ListNode(indexL1.val);
                indexL1 = indexL1.next;
            }

            currentIndex.next = node;
            currentIndex = node;
        }

        if (indexL1 != null) {
            currentIndex.next = indexL1;
        } else {
            currentIndex.next = indexL2;
        }

        return result.next;
    }
}