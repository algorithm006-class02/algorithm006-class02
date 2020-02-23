/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */

/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var detectCycle = function (head) {
  if (!head || !head.next || !head.next.next) return null
  var slow = head.next
  var fast = slow.next
  while (1) {
    if (!slow || !fast || !fast.next) {
      return null
    }
    if (slow == fast) {
      break
    }
    slow = slow.next
    fast = fast.next.next
  }
  // 第一次相遇后，头指针和慢指针走到环形入口处再次相等
  fast = head
  while (fast != slow) {
    fast = fast.next
    slow = slow.next
  }
  return slow
};