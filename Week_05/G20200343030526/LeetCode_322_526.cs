/*
 * @lc app=leetcode.cn id=322 lang=csharp
 *
 * [322] 零钱兑换
 *
 * https://leetcode-cn.com/problems/coin-change/description/
 *
 * algorithms
 * Medium (37.11%)
 * Likes:    489
 * Dislikes: 0
 * Total Accepted:    63.6K
 * Total Submissions: 164.6K
 * Testcase Example:  '[1,2,5]\n11'
 *
 * 给定不同面额的硬币 coins 和一个总金额
 * amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * 
 * 示例 1:
 * 
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3 
 * 解释: 11 = 5 + 5 + 1
 * 
 * 示例 2:
 * 
 * 输入: coins = [2], amount = 3
 * 输出: -1
 * 
 * 说明:
 * 你可以认为每种硬币的数量是无限的。
 * 
 */

// @lc code=start
public class Solution
{
    public int CoinChange(int[] coins, int amount)
    {
        //1.类似于爬楼梯问题
        //2.状态 dp(i)表示凑齐目标金额的最小硬币数
        //3. dp[i] = Min(dp[i-coins[0]] + 1,...,dp[i-coins[coins.Length - 1]] + 1) ,i表示金额

        int[] dp = new int[amount + 1];
        for (int i = 1; i < amount + 1; i++)
        {
            dp[i] = amount + 1;
        }
        for (int i = 1; i < amount + 1; i++)
        {
            for (int ci = 0; ci < coins.Length; ci++)
            {
                if (coins[ci] <= i)
                    dp[i] = Math.Min(dp[i - coins[ci]] + 1, dp[i]);
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
// @lc code=end

