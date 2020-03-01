/**
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
var invertTree = function (root) {
  // 1. 递归
  // deep(root)
  // return root

  // 2. 迭代
  if (!root) return root
  let nodes = [root]
  while (nodes.length) {
    let node = nodes.pop()
    let left = node.left
    let right = node.right
    node.left = right
    node.right = left
    left && nodes.push(left)
    right && nodes.push(right)
  }
  return root
};

function deep (node) {
  if (!node) return node
  let left = node.left
  node.left = node.right
  node.right = left
  deep(node.left)
  deep(node.right)
}
