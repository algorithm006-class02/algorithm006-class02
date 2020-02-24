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
var inorderTraversal = function (root) {
  // 1. 递归
  // let res = []
  // deep(root, res)
  // return res

  // 2. 迭代
  let res = []
  if (!root) return res
  let stack = []
  let cur = root
  while (cur || stack.length) {
    // 当前节点左分支所有节点入栈
    while (cur) {
      stack.push(cur)
      cur = cur.left
    }
    // 出栈
    cur = stack.pop()
    res.push(cur.val)
    cur = cur.right
  }
  return res
};

function deep (node, res) {
  if (!node) return res
  deep(node.left, res)
  res.push(node.val)
  deep(node.right, res)
}
