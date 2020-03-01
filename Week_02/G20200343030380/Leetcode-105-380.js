/**
 * 105. Construct Binary Tree from Preorder and Inorder Traversal
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {number[]} preorder
 * @param {number[]} inorder
 * @return {TreeNode}
 */
const buildTree = (preorder, inorder) => {
  if (!preorder.length) return null    
  let index = inorder.indexOf(preorder[0])
  let left = buildTree(preorder.slice(1, index + 1), inorder.slice(0, index))
  let right = buildTree(preorder.slice(index + 1), inorder.slice(index + 1))
  return { val: preorder[0], left, right }
};