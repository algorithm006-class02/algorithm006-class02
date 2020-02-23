public class SwapNodesInPair {


    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode previous = null;
        ListNode current = head;
        while (current != null) {
            ListNode lastNodeOfPreviousPart = previous;
            ListNode lastNodeOfSubList = current;
            ListNode next;
            for (int i = 0; i < 2 && current != null; i++) {
                next = current.next;
                current.next = previous;
                previous = current;
                current = next;
            }

            if (lastNodeOfPreviousPart != null) {
                lastNodeOfPreviousPart.next = previous;
            } else {
                head = previous;
            }
            lastNodeOfSubList.next = current;

            previous = lastNodeOfSubList;
        }
        return head;
    }

}