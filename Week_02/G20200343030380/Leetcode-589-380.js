/**
 * 589. N-ary Tree Preorder Traversal
 * https://leetcode.com/problems/n-ary-tree-preorder-traversal/
 * // Definition for a Node.
 * function Node(val, children) {
 *    this.val = val;
 *    this.children = children;
 * };
 */
/**
 * @param {Node} root
 * @return {number[]}
 */
const preorder = (root, result = []) => {
  if (root) {
    result.push(root.val)
    for (let i = 0; i < root.children.length; i++) {
      preorder(root.children[i], result)
    }
  }  
  return result
}