/**
 * 322. Coin Change
 * https://leetcode.com/problems/coin-change/
 * @param {number[]} coins
 * @param {number} amount
 * @return {number}
 */
const coinChange = (coins, amount) => {
  let dp = new Array(amount+1).fill(amount+1).fill(0, 0, 1)
  
  for (let i = 1; i < dp.length; i++) {
    for (let coin of coins) {
      if (coin <= i) dp[i] = Math.min(dp[i], dp[i-coin] + 1)
    }
  }
  return dp[amount] === amount+1 ? -1 : dp[amount]
}

/** DP
 *  明确状态：目标金额 amount
 *  确定dp函数的定义： dp[i] 表示至少需要 dp[i] 个硬币凑出目标金额 i
 *  确定选择并择优：无论当前的目标金额是多少，选择就是从 coins 中选择一个硬币，然后目标金额就会较少
 *  明确 base case：当目标金额为0时，所需硬币数量为0，当无解时，返回-1
 *  所以DP方程为：
 *    dp[0] = 0
 *    dp[i] = Math.min(dp[i], dp[i-coin] + 1), for coin of coins
 */

/**
 * You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

Example 1:

Input: coins = [1, 2, 5], amount = 11
Output: 3 
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
Note:
You may assume that you have an infinite number of each kind of coin.
 */