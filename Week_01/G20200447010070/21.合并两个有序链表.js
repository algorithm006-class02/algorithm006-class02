/*
 * @lc app=leetcode.cn id=21 lang=javascript
 *
 * [21] 合并两个有序链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */
var mergeTwoLists = function(l1, l2) {
  if (!l1) return l2;
  if (!l2) return l1;

  let node = null;
  if (l1.val < l2.val) {
    node = l1;
    l1 = l1.next;
  } else {
    node = l2;
    l2 = l2.next;
  }
  let tail = node;
  while (l1 != null && l2 != null) {
    if (l1.val < l2.val) {
      tail.next = l1;
      l1 = l1.next;
    } else {
      tail.next = l2;
      l2 = l2.next;
    }
    tail = tail.next;
  }
  tail.next = l1 === null ? l2 : l1;
  return node;
};
// @lc code=end
