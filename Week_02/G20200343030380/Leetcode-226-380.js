/**
 * 226. Invert Binary Tree
 * https://leetcode.com/problems/invert-binary-tree/
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {TreeNode}
 */
// 递归
const invertTree = (root) => {
  const reverse = (node) => {
    if (!node) return node
    if (node.left || node.right) {
      let tmp = node.right
      node.right = node.left  
      node.left = tmp
      
      reverse(node.left)
      reverse(node.right)
    }
    return node
  }
  return reverse(root)
}