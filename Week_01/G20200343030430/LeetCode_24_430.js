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
var swapPairs = function (head) {
  if (!head || !head.next) return head

  let h = head.next
  let p = head
  let pre = null
  while (p && p.next) {
    let n = p.next
    p.next = n.next
    n.next = p
    // 2   1   3   4
    //   pre   p   n  第一次交换后
    if (pre) {
      pre.next = n
    }
    pre = p
    p = p.next
  }

  return h
};