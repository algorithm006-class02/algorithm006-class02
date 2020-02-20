/**
 * Created by HuGuodong on 2/14/20.
 */
public class LeetCode_24_364 {

  class Solution {

    public ListNode reverseList(ListNode head) {
      if (head == null || head.next == null) return head;
      return _rev(null, head);
    }

    private ListNode _rev(ListNode prev, ListNode cur) {
      if (cur == null) {
        return prev;
      }
      ListNode next = cur.next;
      cur.next = prev;
      return _rev(cur, next);
    }
  }
}
