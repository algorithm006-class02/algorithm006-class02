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
var preorderTraversal = function (root) {
  // 1. 递归
  // let res = []
  // deep(root, res)
  // return res

  // 2. 迭代
  let res = []
  if (!root) return res
  let nodes = [root]
  while (nodes.length) {
    // 每次取最后一个
    let node = nodes.pop()
    res.push(node.val)
    let left = node.left
    let right = node.right
    // 倒序入栈
    right && nodes.push(right)
    left && nodes.push(left)
  }
  return res
};

function deep (node, res) {
  if (!node) return res
  res.push(node.val)
  deep(node.left, res)
  deep(node.right, res)
}
