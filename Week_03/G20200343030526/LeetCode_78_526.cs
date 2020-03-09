/*
 * @lc app=leetcode.cn id=78 lang=csharp
 *
 * [78] 子集
 *
 * https://leetcode-cn.com/problems/subsets/description/
 *
 * algorithms
 * Medium (76.12%)
 * Likes:    481
 * Dislikes: 0
 * Total Accepted:    63.5K
 * Total Submissions: 83.1K
 * Testcase Example:  '[1,2,3]'
 *
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 
 * 说明：解集不能包含重复的子集。
 * 
 * 示例:
 * 
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 * ⁠ [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 * 
 */

// @lc code=start
public class Solution
{
    public IList<IList<int>> Subsets(int[] nums)
    {
        var r = new List<IList<int>>();
        BackTrack(r, new List<int>(), nums, 0);
        return r;
    }

    void BackTrack(IList<IList<int>> result, IList<int> tmp, int[] nums, int start)
    {
        //隐含teminator，就是for循环里的start 要小于 nums.length,否则就没有子问题了
        result.Add(new List<int>(tmp));//细节处理，新建一个tmp的副本，不然tmp会一直为空
        for (int i = start; i < nums.Length; i++)
        {
            tmp.Add(nums[i]);
            BackTrack(result, tmp, nums, i + 1);
            tmp.RemoveAt(tmp.Count - 1);
        }
    }
}
// @lc code=end

