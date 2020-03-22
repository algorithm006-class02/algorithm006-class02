/*
 * @lc app=leetcode.cn id=198 lang=csharp
 *
 * [198] 打家劫舍
 *
 * https://leetcode-cn.com/problems/house-robber/description/
 *
 * algorithms
 * Easy (42.58%)
 * Likes:    670
 * Dislikes: 0
 * Total Accepted:    84.7K
 * Total Submissions: 195K
 * Testcase Example:  '[1,2,3,1]'
 *
 * 
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 * 
 * 示例 1:
 * 
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 * 偷窃到的最高金额 = 1 + 3 = 4 。
 * 
 * 示例 2:
 * 
 * 输入: [2,7,9,3,1]
 * 输出: 12
 * 解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 * 偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 * 
 * 
 */

// @lc code=start
public class Solution
{
    public int Rob(int[] nums)
    {
        //dp[i,0]表示第i个房子不偷
        //dp[i,1]表示第i个房子偷
        //dp[i,0] = Max(dp[i-1,0],dp[i-1,1])
        //dp[i,1] = Max(dp[i-1,0]，0) + nums[i]
        // if (nums == null || nums.Length == 0) return 0;
        // int[,] dp = new int[nums.Length, 2];
        // dp[0, 0] = 0;
        // dp[0, 1] = nums[0];
        // for (int i = 1; i < nums.Length; i++)
        // {
        //     dp[i, 0] = Math.Max(dp[i - 1, 0], dp[i - 1, 1]);
        //     dp[i, 1] = dp[i - 1, 0] + nums[i];
        // }
        // return Math.Max(dp[nums.Length - 1, 0], dp[nums.Length - 1, 1]);

        //如果简化为一维，则状态定义为，dp[i]表示为第i个房子必偷
        //dp方程变化为 dp[i] = Max(dp[i-1](不偷),dp[i-2]+nums[i]);
        // if (nums == null || nums.Length == 0) return 0;
        // if (nums.Length == 1) return nums[0];
        // int[] dp = new int[nums.Length];
        // dp[0] = nums[0];
        // dp[1] = Math.Max(nums[0], nums[1]);
        // for (int i = 2; i < nums.Length; i++)
        // {
        //     dp[i] = Math.Max(dp[i - 1], dp[i - 2] + nums[i]);
        // }
        // return Math.Max(dp[nums.Length - 1], dp[nums.Length - 2]);

        //在一维的基础上再简化，只用两个变量保存dp[i-1],dp[i-2]
        int dpa = 0, dpb = 0,dpi = 0;
        for (int i = 0; i < nums.Length; i++)
        {
            dpi = Math.Max(dpb,dpa + nums[i]);
            dpa = dpb;
            dpb = dpi;
        }
        return Math.Max(dpb,dpa);
    }
}
// @lc code=end

