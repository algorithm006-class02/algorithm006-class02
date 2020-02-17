/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */

/**
 * @param {ListNode} head
 * @return {boolean}
 */
var hasCycle = function (head) {
  if (head == null || head.next == null || head.next.next == null) return false
  var slow = head.next
  var fast = slow.next
  while (1) {
    if (slow == null || fast == null || fast.next == null) {
      return false
    }
    if (slow == fast) {
      return true
    }
    slow = slow.next
    fast = fast.next.next
  }
};