/**
 * 144. Binary Tree Preorder Traversal
 * https://leetcode.com/problems/binary-tree-preorder-traversal/
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
const preorderTraversal = (root) => {
  let result = []
  function preorder(node, result) {
    if (node) {
      result.push(node.val)
      preorder(node.left, result)
      preorder(node.right, result)
    }
  }
  preorder(root, result)
  return result
};