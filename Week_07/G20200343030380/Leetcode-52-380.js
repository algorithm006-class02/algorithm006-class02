/**
 * 52. N-Queens II
 * https://leetcode-cn.com/problems/n-queens-ii/
 * @param {number} n
 * @return {number}
 */
/**
 * 解法一：位运算 + DFS
 * DFS 当前列、左斜对角线、右斜对角线
 * 二进制为1代表不可放置，0相反
 * x & -x ：得到最低位的1
 * x & (x-1)：清零最低位的1
 * x & ((1 << n) - 1)：将x最高位至第n位(含)清零
 */
const totalNQueens = (n) => {
  if (n < 1) return []
  let count = 0 

  const dfs = (n, row, cols, pie, na) => {
    if (row >= n) { ++count; return }
    let bits = (~(cols | pie | na)) & ((1 << n) - 1) // 得到当前所有的空位
    while(bits) {
      let p = bits & -bits // 取到最低位的1
      bits = bits & (bits - 1) // 表示在p位置上放入皇后
      dfs(n, row + 1, cols | p, (pie | p) << 1, (na | p) >> 1)
    }
  }

  dfs(n, 0, 0, 0, 0)
  return count
}