/*
 * @lc app=leetcode.cn id=53 lang=csharp
 *
 * [53] 最大子序和
 *
 * https://leetcode-cn.com/problems/maximum-subarray/description/
 *
 * algorithms
 * Easy (48.80%)
 * Likes:    1713
 * Dislikes: 0
 * Total Accepted:    179.2K
 * Total Submissions: 360.5K
 * Testcase Example:  '[-2,1,-3,4,-1,2,1,-5,4]'
 *
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 
 * 示例:
 * 
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 
 * 
 * 进阶:
 * 
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 * 
 */

// @lc code=start
public class Solution
{
    public int MaxSubArray(int[] nums)
    {
        //1.子问题 从第i个元素看过去，取或不取当前元素的解 max_sum(i) = Max(max_sum(i-1),0) + a(i)
        //2.状态定义 f(i)->代表0到第i个元素当前的sum
        //3.DP 方程f[i] = Max(f(i-1),0)+ a[i]
        int dpi = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.Length; i++)
        {
            dpi = nums[i] + dpi > 0 ? dpi : 0;
            if (dpi > max) max = dpi;
        }
        return max;
    }
}
// @lc code=end

