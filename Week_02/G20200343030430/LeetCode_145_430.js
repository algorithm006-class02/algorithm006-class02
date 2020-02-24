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
var postorderTraversal = function (root) {
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
    // 放入第一位
    res.unshift(node.val)
    let left = node.left
    let right = node.right
    // 顺序入栈
    left && nodes.push(left)
    right && nodes.push(right)
  }
  return res
};

function deep (node, res) {
  if (!node) return res
  deep(node.left, res)
  deep(node.right, res)
  res.push(node.val)
}
