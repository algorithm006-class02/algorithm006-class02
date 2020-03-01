/**
 * 111. Minimum Depth of Binary Tree
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number}
 */
// 方法一：递归
const minDepth = (root) => {
  if (!root) return 0    
  let L = minDepth(root.left), R = minDepth(root.right)
  return (Math.min(L, R) || Math.max(L, R)) + 1
};