/**
 * 515. Find Largest Value in Each Tree Row
 * https://leetcode.com/problems/find-largest-value-in-each-tree-row/
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
/**
 * 方法一：BFS
 */
const largestValues = (root) => {
  if (!root) return []    
  let result = [], queue = [root]
  while (queue.length) {
    let vals = [], n = queue.length
    for (let i = 0; i < n; i++) {
      let node = queue.pop() // 队尾出队列
      vals.push(node.val)
      if (node.left) queue.unshift(node.left) // 队头入队列
      if (node.right) queue.unshift(node.right)
    }
    result.push(Math.max(...vals))
  }
  return result
};