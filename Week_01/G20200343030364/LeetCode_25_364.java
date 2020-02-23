/**
 * Created by HuGuodong on 2/14/20.
 */
public class LeetCode_25_364 {

  class Solution {

    public ListNode reverseList(ListNode head) {
      ListNode prev = null;
      ListNode cur = head;
      while (cur != null) {
        ListNode temp = head.next;
        cur.next = prev;
        prev = cur;
        cur = temp;
      }
      return cur;
    }
  }
}
