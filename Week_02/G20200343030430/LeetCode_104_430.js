/**
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
var maxDepth = function (root) {
  // 1. 递归
  // return deep(root)

  // 2. 迭代
  if (!root) return 0
  let max = 1
  let nodes = [{ key: root, value: 1 }]
  while (nodes.length) {
    let obj = nodes.pop()
    let node = obj.key
    let value = obj.value
    max = Math.max(max, value)
    let left = node.left
    let right = node.right
    // 保存当前节点的深度
    if (left) {
      nodes.push({ key: left, value: value + 1 })
    }
    if (right) {
      nodes.push({ key: right, value: value + 1 })
    }
  }
  return max
};

function deep (node) {
  if (!node) return 0
  return Math.max(deep(node.left), deep(node.right)) + 1
}
