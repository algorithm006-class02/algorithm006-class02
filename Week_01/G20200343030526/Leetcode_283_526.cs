/*
 * @lc app=leetcode.cn id=283 lang=csharp
 *
 * [283] 移动零
 *
 * https://leetcode-cn.com/problems/move-zeroes/description/
 *
 * algorithms
 * Easy (58.92%)
 * Likes:    483
 * Dislikes: 0
 * Total Accepted:    101.7K
 * Total Submissions: 172.4K
 * Testcase Example:  '[0,1,0,3,12]'
 *
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 
 * 示例:
 * 
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 
 * 说明:
 * 
 * 
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 * 
 * 
 */

// @lc code=start
public class Solution
{
    public void MoveZeroes(int[] nums)
    {
        //1，遍历数组将所有不为0的数往j处放，放完后j++,原来的i处置为0
        //2. 需注意下标i处置0时，应判断i!=j
        int j = 0;
        for (int i = 0; i < nums.Length; i++)
        {
            if (nums[i] != 0)
            {
                nums[j] = nums[i];
                if (i != j)
                {
                    nums[i] = 0;
                }
                j++;
            }
        }
    }
}
// @lc code=end

