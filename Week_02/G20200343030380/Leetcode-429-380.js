/**
 * 429. N-ary Tree Level Order Traversal
 * https://leetcode.com/problems/n-ary-tree-level-order-traversal/
 * // Definition for a Node.
 * function Node(val,children) {
 *    this.val = val;
 *    this.children = children;
 * };
 */
/**
 * @param {Node} root
 * @return {number[][]}
 */
// 使用队列实现广度优先搜索 O(n^2)
const levelOrder = (root) => {
  if (!root) return []
  let result = []
  let queue = [root]
  while(queue.length) {
    let level = []
    let len = queue.length
    while(len) {
      let node = queue.shift()
      level.push(node.val)
      if (node.children && node.children.length) {
        queue.push(...node.children)
      }
      len-- 
    }
    result.push(level)
  }
  
  return result
}