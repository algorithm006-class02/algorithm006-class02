/**
 * 94. Binary Tree Inorder Traversal
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
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
// 递归 + Array
//const inorderTraversal = (root, result = []) => {
//  if (root) {
//    inorderTraversal(root.left, result)
//    result.push(root.val)
//    inorderTraversal(root.right, result)
//  }
//  return result
//}

// 纯递归
const inorderTraversal = (root) => {
  if (!root) return []  
  return inorderTraversal(root.left).concat(root.val, inorderTraversal(root.right))
}