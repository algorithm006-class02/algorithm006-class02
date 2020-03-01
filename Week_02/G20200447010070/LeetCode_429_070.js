/*
 * @lc app=leetcode.cn id=429 lang=javascript
 *
 * [429] N叉树的层序遍历
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
 * @return {number[][]}
 */
var levelOrder = function(root) {
  if (!root) return [];
  let res = [];
  let queue = [{ node: root, level: 0 }];
  while (queue.length) {
    let item = queue.pop();
    let level = item.level;
    if (!res[level]) res[level] = [];
    res[level].push(item.node.val);
    for (let child of item.node.children) {
      queue.unshift({ node: child, level: level + 1 });
    }
  }
  return res;
};
// @lc code=end
