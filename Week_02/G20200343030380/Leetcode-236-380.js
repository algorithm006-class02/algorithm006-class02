/**
 * 236. Lowest Common Ancestor of a Binary Tree
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @param {TreeNode} p
 * @param {TreeNode} q
 * @return {TreeNode}
 */
// 方法一：递归
const lowestCommonAncestor = (root, p, q) => {
  const traverse = (node) => {
    // 如果递归到叶子结点，返回false
    if (!node) return false
    // 递归遍历左子树
    let left = traverse(node.left)
    // 递归遍历右子树
    let right = traverse(node.right)
    // 判断当前结点是否是 p 或 q
    let isSelf = node == p || node == q
    // 如果任意两个值为true，当前结点即为LCA 
    if (isSelf + left + right >= 2) return node      
    // 如果任意一个值为true，返回true
    return isSelf || left || right
  }    
  return traverse(root)
};