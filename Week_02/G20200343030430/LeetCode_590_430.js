/**
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
var postorder = function (root) {
  // 1. 递归
  let res = []
  deep(root, res)
  return res

  // 2. 迭代
  /* let res = []
  if (!root) return res
  let nodes = [root]
  while (nodes.length) {
      // 每次取最后一个
      let node = nodes.pop()
      let arr = node.children
      // 放入第一位
      res.unshift(node.val)
      // 顺序入栈
      for (let i = 0; i < arr.length; i++) {
          nodes.push(arr[i])
      }
  }
  return res */
};

function deep (node, res) {
  if (!node) return res
  let nodes = node.children
  for (let i = 0; i < nodes.length; i++) {
    deep(nodes[i], res)
  }
  res.push(node.val)
}
