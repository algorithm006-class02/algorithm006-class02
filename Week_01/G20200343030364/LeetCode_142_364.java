/**
 * Created by HuGuodong on 2/14/20.
 */
public class LeetCode_142_364 {

  public class Solution {

    public ListNode detectCycle(ListNode head) {
      if (head == null || head.next == null) return null;
      ListNode slow = head, fast = head, start = head;
      while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
        if (slow == fast) {
          while (start != slow) {
            slow = slow.next;
            start = start.next;
          }
          return start;
        }
      }
      return null;
    }
  }
}
