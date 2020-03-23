/**
 * 547. Friend Circles
 * https://leetcode.com/problems/friend-circles/
 * @param {number[][]} M
 * @return {number}
 */
/**
 * 方法一：DFS
 * 方法二：BFS
 * 方法三：并查集 
 *  - 因为矩阵是n*n的，所以是n个人之间的关系，创建一个长度为n的数组，表示初始化的n个独立的集合，自己是自己的集合代表(parent), 此时集合数量count = n
 *  - 遍历矩阵M，如果i,j两个人的关系 M[i][j] == 1，那就找到他们各自的集合代表，如果不一致，就合并为一个集合，因为他们是一个共同的朋友圈
 *  - 返回集合数量
 */
const findCircleNum = (M) => {
  if (!M.length) return 0
  let n = M.length, count = n
  let parent = new Array(n)
  
  const findParent = (p) => {
    while (parent[p] != p) {
      parent[p] = parent[parent[p]]
      p = parent[p]
    }
    return p
  }
  
  const union = (p, q) => {
    let rootP = findParent(p), rootQ = findParent(q)
    if (rootP === rootQ) return 
    parent[rootP] = rootQ
    count--
  }

  for (let i = 0; i < n; i++) parent[i] = i
  for (let i = 0; i < n; i++) {
    for (let j = 0; j < n; j++) {
      if (M[i][j] === 1) union(i, j)
    }
  }
  return count
}