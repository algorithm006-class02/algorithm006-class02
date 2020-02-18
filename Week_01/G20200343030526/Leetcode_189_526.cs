/*
 * @lc app=leetcode.cn id=189 lang=csharp
 *
 * [189] 旋转数组
 *
 * https://leetcode-cn.com/problems/rotate-array/description/
 *
 * algorithms
 * Easy (40.20%)
 * Likes:    478
 * Dislikes: 0
 * Total Accepted:    94.4K
 * Total Submissions: 234.4K
 * Testcase Example:  '[1,2,3,4,5,6,7]\n3'
 *
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * 
 * 示例 1:
 * 
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 
 * 
 * 示例 2:
 * 
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释: 
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 * 
 * 说明:
 * 
 * 
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的 原地 算法。
 * 
 * 
 */

// @lc code=start
public class Solution
{
    public void Rotate(int[] nums, int k)
    {
        if (nums.Length == 0)
        {
            return;
        }
        //思路1：每次把所有的元素依次向后移动，用一个额外变量存储溢出的一个值
        //暴力法，时间溢出了
        // for (int i = 0; i < k; i++)
        // {
        //     int temp = nums[nums.Length - 1];
        //     for (int j = nums.Length - 2; j >= 0; j--)
        //     {
        //         nums[j + 1] = nums[j];
        //     }
        //     nums[0] = temp;
        // }
        //思路2：每个元素的下标变换为 当前下标 + k 对 nums.length 取模        int[] rnums = new int[nums.Length];
        // for (int i = 0; i < nums.Length; i++)
        // {
        //     int position = (i + k) % nums.Length;
        //     rnums[position] = nums[i];
        // }
        // for (int i = 0; i < nums.Length; i++)
        // {
        //     nums[i] = rnums[i];
        // }
        //思路3：直接看的结果，翻转法(最优解) 时间复杂度O(n)
        k %= nums.Length;
        Reverse(nums, 0, nums.Length - 1);//翻转整个数组
        Reverse(nums, k , nums.Length - 1);//翻转尾巴 
        Reverse(nums, 0, k - 1);//翻转头
    }

    private void Reverse(int[] nums, int start, int end)
    {
        //翻转（镜像）数组操作，头尾双指针，对称交换元素
        while (start < end)
        {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }
}
// @lc code=end

