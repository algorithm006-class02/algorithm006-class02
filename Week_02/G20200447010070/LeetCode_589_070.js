/*
 * @lc app=leetcode.cn id=589 lang=javascript
 *
 * [589] N叉树的前序遍历
 */

// @lc code=start
/**
 * // Definition for a Node.
 * function Node(val, children) {
 *    this.val = val;
 *    this.children = children;
 * };
 */
/**
 * @param {Node} root
 * @return {number[]}
 */
var preorder = function(root) {
  if (!root) return [];
  let res = [];
  let stack = [];
  stack.push(root);
  while (stack.length) {
    let next = stack.pop();
    res.push(next.val);
    // 后打印的先入栈
    while (next.children.length) {
      stack.push(next.children.pop());
    }
  }
  return res;
};
// @lc code=end
