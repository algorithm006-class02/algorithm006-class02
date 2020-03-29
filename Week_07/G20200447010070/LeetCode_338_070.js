/*
 * @lc app=leetcode.cn id=338 lang=javascript
 *
 * [338] 比特位计数
 */

// @lc code=start
/**
 * @param {number} num
 * @return {number[]}
 */
var countBits = function(num) {
  // 1.子问题 dp[i]: i 变成二进制有多少个 1
  // 2.状态定义 dp[i]
  // 3.DP 方程 dp[i] = dp[i & (i - 1)] + 1   i & (i - 1)去掉最低位的 1
  let bits = new Uint8Array(num + 1);
  for (let i = 1; i <= num; i++) {
    bits[i] = bits[i & (i - 1)] + 1;
  }
  return bits;
};
// @lc code=end
