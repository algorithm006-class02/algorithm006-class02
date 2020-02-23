/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} head
 * @param {number} k
 * @return {ListNode}
 */
var reverseKGroup = function (head, k) {
  if (!head || !head.next || k == 1) return head

  let h = null
  let p = head
  let pre = head
  while (p && p.next) {
    // pre记录下一次循环的当前循环的第一个元素
    let first = p
    // 检查最后一轮循环的节点数是否等于k
    let i = 0
    while (i < k) {
      if (!p) return h || head
      p = p.next
      i++
    }
    // 反转
    i = 1
    p = first
    let n = p.next
    let n1 = n.next
    while (i < k) {
      n.next = p
      p = n
      n = n1
      n1 = n1 && n1.next
      i++
    }
    //     p n n1
    // 1 2 3 4 ...  i=3
    // 4   3   2  1    5   -
    // p          pre  n   n1
    // 第一次循环
    if (!h) h = p
    pre.next = p
    first.next = n
    p = n
    pre = first
  }

  return h
};