/*
 * @lc app=leetcode.cn id=15 lang=csharp
 *
 * [15] 三数之和
 *
 * https://leetcode-cn.com/problems/3sum/description/
 *
 * algorithms
 * Medium (25.22%)
 * Likes:    1787
 * Dislikes: 0
 * Total Accepted:    155.5K
 * Total Submissions: 610.7K
 * Testcase Example:  '[-1,0,1,2,-1,-4]'
 *
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0
 * ？找出所有满足条件且不重复的三元组。
 * 
 * 注意：答案中不可以包含重复的三元组。
 * 
 * 
 * 
 * 示例：
 * 
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 
 * 满足要求的三元组集合为：
 * [
 * ⁠ [-1, 0, 1],
 * ⁠ [-1, -1, 2]
 * ]
 * 
 * 
 */

// @lc code=start
public class Solution
{
    public IList<IList<int>> ThreeSum(int[] nums)
    {
        //先将数组排序，第一层循环，固定一个值i
        //固定一个值，对该值右边一个元素到数组最后一个元素采用双指针向中间夹逼的方法，
        //排除一些肯定不用考虑的条件：
        //1.由于固定的这个指针是最小值，所以如果这个值已经大于0，则三数和肯定大于0，不用处理
        //2.如果当前数和之前数一致，则已经求过解了，可以跳过不处理。
        //每次求三个指针数的和。
        //如果大于0，说明数字大了，右边指针向左移动
        //如果小于0，说明数字小了，左边指针向右移动
        //如果等于0，得解，左指针移动到右边第一个不同的元素，右指针移动到左边的第一个不同元素
        //注意边界条件
        var r = new List<IList<int>>();
        if (nums.Length >= 3)
        {
            System.Array.Sort(nums);
            for (int i = 0; i < nums.Length - 2; i++)
            {
                if (nums[i] > 0 || (i > 0 && nums[i] == nums[i - 1]))
                {
                    continue;
                }
                for (int lo = i + 1, hi = nums.Length - 1; lo < hi;)
                {
                    int s = nums[i] + nums[lo] + nums[hi];
                    if (s == 0)
                    {
                        r.Add(new List<int> { nums[i], nums[lo], nums[hi] });
                        while (lo < hi && nums[lo] == nums[++lo]) { }
                        while (lo < hi && nums[hi] == nums[--hi]) { }
                    }
                    else if (s > 0) hi--;
                    else lo++;
                }
            }
        }
        return r;
    }
}
// @lc code=end

