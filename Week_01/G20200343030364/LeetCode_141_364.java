/**
 * Created by HuGuodong on 2/14/20.
 */
public class LeetCode_141_364 {

  public class Solution {

    public boolean hasCycle(ListNode head) {
      if (head == null || head.next == null) return false;
      if (head.next == head) return true;
      ListNode slow = head, fast = head.next.next;
      while (slow != fast) {
        if (fast == null || fast.next == null) {
          return false;
        }
        slow = slow.next;
        fast = fast.next.next;
      }
      return true;
    }
  }
}
