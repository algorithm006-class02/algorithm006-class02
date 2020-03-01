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
var minDepth = function (root) {
  // 1. 递归
  // return deep(root)

  // 2. DFS
  // return DFS(root)

  // 3. BFS
  return BFS(root)
};

function deep (node) {
  if (!node) return 0
  if (!node.left && !node.right) return 1
  let min = Number.MAX_SAFE_INTEGER
  if (node.left) {
    min = Math.min(deep(node.left), min)
  }
  if (node.right) {
    min = Math.min(deep(node.right), min)
  }
  return min + 1
}

function DFS (root) {
  if (!root) return 0

  let min = Number.MAX_SAFE_INTEGER
  let nodes = [{ key: root, value: 1 }]
  while (nodes.length) {
    let obj = nodes.pop()
    let node = obj.key
    let value = obj.value
    let left = node.left
    let right = node.right
    // 叶子节点时才比较最小值
    if (!left && !right) {
      min = Math.min(min, value)
    }
    // 保存当前节点的深度
    left && nodes.push({ key: left, value: value + 1 })
    right && nodes.push({ key: right, value: value + 1 })
  }
  return min
}

function BFS (root) {
  if (!root) return 0

  let min = 0
  let nodes = [{ key: root, value: 1 }]
  while (nodes.length > 0) {
    let obj = nodes.pop()
    let node = obj.key
    min = obj.value
    console.log(min, node.val)
    let left = node.left
    let right = node.right
    // 找到叶子节点时就结束
    if (!node.left && !node.right) {
      break
    }
    // 保存当前节点的深度
    left && nodes.push({ key: left, value: min + 1 })
    right && nodes.push({ key: right, value: min + 1 })
  }

  return min
}
