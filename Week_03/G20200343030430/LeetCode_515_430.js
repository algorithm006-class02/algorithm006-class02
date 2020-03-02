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
var largestValues = function (root) {
  if (!root) return []
  let res = []
  let queue = [root]
  while (queue.length) {
    let size = queue.length
    let max = Number.MIN_SAFE_INTEGER
    for (let i = 0; i < size; i++) {
      root = queue.shift()
      max = Math.max(max, root.val)
      root.left && queue.push(root.left)
      root.right && queue.push(root.right)
    }
    res.push(max)
  }
  return res
};