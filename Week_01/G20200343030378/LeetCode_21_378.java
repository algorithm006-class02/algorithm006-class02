public class LeetCode_21_378 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(null == l1)
            return l2;
        if(null == l2)
            return l1;

        ListNode newHead = new ListNode(0);
        ListNode head = newHead;
        while (null != l1 && null != l2){
            if(l1.val > l2.val){
                head.next = l2;
                l2 = l2.next;
            }else {
                head.next = l1;
                l1 = l1.next;
            }
            head = head.next;
        }

        head.next = l1 == null ? l2 :l1;
        return newHead.next;

    }
}
