/**
 *  https://leetcode-cn.com/problems/merge-two-sorted-lists/
 */
public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode tmp = new ListNode(-1);
        ListNode head = tmp;
        while (l1!=null&&l2!=null){
            int val1 = l1.val;
            int val2 = l2.val;
            if(val1>=val2){
                head.next = l2;
                l2 = l2.next;
            } else {
                head.next = l1;
                l1 = l1.next;
            }
            head = head.next;
        }
        //l1=null||l2=null
        head.next = l1 == null?l2:l1;
        return tmp.next;
    }
}

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}
