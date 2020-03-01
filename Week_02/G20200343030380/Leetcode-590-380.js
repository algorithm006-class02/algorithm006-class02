/**
 * 590. N-ary Tree Postorder Traversal
 * https://leetcode.com/problems/n-ary-tree-postorder-traversal/
 * // Definition for a Node.
 * function Node(val,children) {
 *    this.val = val;
 *    this.children = children;
 * };
 */
/**
 * @param {Node} root
 * @return {number[]}
 */
const postorder = (root, result = []) => {
  if (root) {
    for (let i = 0; i < root.children.length; i++) {
      postorder(root.children[i], result)
    }
    result.push(root.val)
  }
  return result
}