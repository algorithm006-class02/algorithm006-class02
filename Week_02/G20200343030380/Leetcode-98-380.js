/**
 * 98. Validate Binary Search Tree
 * https://leetcode.com/problems/validate-binary-search-tree/
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {boolean}
 */
// 方法一：递归
//const isValidBST = (root) => {
//  const validate = (node, min, max) => {
//    if (!node) return true
//    let val = node.val
//    if (val <= min || val >= max) return false
//    return (validate(node.left, min, val)) && (validate(node.right, val, max))
//  }    
//  return validate(root, Number.MIN_SAFE_INTEGER, Number.MAX_SAFE_INTEGER)
//};

// 方法二：stack + 中序遍历
const isValidBST = (root) => {
  let stack = [], node = root, min = Number.MIN_SAFE_INTEGER
  while (stack.length > 0 || node) {
    while (node) {
      stack.push(node)
      node = node.left
    }
    node = stack.pop()
    if (node.val <= min) return false
    min = node.val
    node = node.right
  }
  return true
}