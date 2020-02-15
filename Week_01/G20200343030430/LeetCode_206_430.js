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
var reverseList = function (head) {
  if (head == null) return head
  var p = head
  var n1 = p.next
  var n2 = n1 && n1.next
  p.next = null
  while (n1 != null) {
    n1.next = p
    p = n1
    n1 = n2
    n2 = n2 && n2.next
  }
  return p
};