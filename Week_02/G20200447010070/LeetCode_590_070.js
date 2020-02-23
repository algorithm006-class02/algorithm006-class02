/*
 * @lc app=leetcode.cn id=590 lang=javascript
 *
 * [590] N叉树的后序遍历
 */

// @lc code=start
/**
 * // Definition for a Node.
 * function Node(val,children) {
 *    this.val = val;
 *    this.children = children;
 * };
 */
/**
 * @param {Node} root
 * @return {number[]}
 */
var postorder = function(root) {
  if (!root) return [];
  let res = [];
  let stack = [];
  stack.push(root);
  while (stack.length > 0) {
    let node = stack.pop();
    res.push(node.val);
    for (let child of node.children) {
      child && stack.push(child);
    }
  }
  return res.reverse();
};
// @lc code=end
