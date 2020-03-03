/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number[][]}
 */
var levelOrder = function (root) {
  if (!root) return []
  let res = []
  // dfs(0, root, res)
  // dfsByStack(root, res)
  bfs(root, res)
  return res
};

function bfs (root, res) {
  let queqe = [root]
  while (queqe.length) {
    let size = queqe.length
    let cur = []
    for (let i = 0; i < size; i++) {
      root = queqe.shift()
      cur.push(root.val)
      root.left && queqe.push(root.left)
      root.right && queqe.push(root.right)
    }
    res.push(cur)
  }
}

function dfs (level, root, res) {
  res[level] = res[level] || []
  res[level].push(root.val)
  root.left && dfs(level + 1, root.left, res)
  root.right && dfs(level + 1, root.right, res)
}

function dfsByStack (root, res) {
  let level = 0
  let stack = [{ root, level: 0 }]
  while (stack.length) {
    let obj = stack.pop()
    root = obj.root
    level = obj.level
    res[level] = res[level] || []
    res[level].push(root.val)
    root.right && stack.push({ root: root.right, level: level + 1 })
    root.left && stack.push({ root: root.left, level: level + 1 })
  }
}