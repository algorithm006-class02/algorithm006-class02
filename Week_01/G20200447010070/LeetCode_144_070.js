/*
 * @lc app=leetcode.cn id=144 lang=javascript
 *
 * [144] 二叉树的前序遍历
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number[]}
 */
var preorderTraversal = function(root) {
  if (!root) return [];
  let res = [];
  let stack = [];
  stack.push(root);
  while (stack.length !== 0) {
    let node = stack.pop();
    if (node) {
      res.push(node.val);
      // 先打印左子树，所有先将右子树加入栈
      node.right && stack.push(node.right);
      node.left && stack.push(node.left);
    }
  }
  return res;
};
// @lc code=end
