public class ReverseKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1 || head == null) {
            return head;
        }
        int length = getLength(head);
        ListNode previous = null;
        ListNode current = head;
        int lastReverseIndex = 0;
        if (length % k == 0) {
            lastReverseIndex = length;
        } else {
            lastReverseIndex = (length / k) * k;
        }

        int i = 0;
        while (i < lastReverseIndex && current != null) {
            ListNode lastNodeOfPreviousPart = previous;
            ListNode lastNodeOfSubList = current;
            ListNode next;
            for (int j = 0; j < k && current != null; j++) {
                next = current.next;
                current.next = previous;
                previous = current;
                current = next;
                i++;
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

    private int getLength(ListNode head) {
        int length = 0;
        ListNode current = head;
        while (current != null) {
            current = current.next;
            length++;
        }
        return length;
    }

}