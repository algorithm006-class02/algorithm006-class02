/*
 * @lc app=leetcode.cn id=94 lang=javascript
 *
 * [94] 二叉树的中序遍历
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
var inorderTraversal = function(root) {
  let res = [];
  let stack = [];
  let curr = root;
  while (curr || stack.length !== 0) {
    while (curr) {
      stack.push(curr);
      curr = curr.left;
    }
    // 现在 curr 是最左叶子结点
    curr = stack.pop();
    res.push(curr.val);
    curr = curr.right;
  }
  return res;
};
// @lc code=end
