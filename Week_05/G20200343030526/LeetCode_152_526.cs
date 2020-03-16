/*
 * @lc app=leetcode.cn id=152 lang=csharp
 *
 * [152] 乘积最大子序列
 *
 * https://leetcode-cn.com/problems/maximum-product-subarray/description/
 *
 * algorithms
 * Medium (36.73%)
 * Likes:    417
 * Dislikes: 0
 * Total Accepted:    39.4K
 * Total Submissions: 105.2K
 * Testcase Example:  '[2,3,-2,4]'
 *
 * 给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
 * 
 * 示例 1:
 * 
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 
 * 
 * 示例 2:
 * 
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 * 
 */

// @lc code=start
public class Solution
{
    public int MaxProduct(int[] nums)
    {
        //1.子问题，第i个元素的最大子序积为第i-1的最大子序积乘以i
        //由于存在负数，最小的也记录（负数），当负数出现时，最大的乘以负数会变为最小的，最小的会变为最大的
        //如果当前值是负数，交换max和min
        //2.dpi
        //3.f[i] = Max(f[i-1]),1)*a[i]
        int dpimax = nums[0];
        int dpimin = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.Length; i++)
        {
            if (nums[i] < 0)
            {
                var tmp = dpimax;
                dpimax = dpimin;
                dpimin = tmp;
            }
            dpimax = Math.Max(nums[i], dpimax * nums[i]);
            dpimin = Math.Min(nums[i], dpimin * nums[i]);

            if (dpimax > max) max = dpimax;
        }
        return max;
    }
}
// @lc code=end

