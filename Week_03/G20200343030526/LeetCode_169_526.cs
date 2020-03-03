/*
 * @lc app=leetcode.cn id=169 lang=csharp
 *
 * [169] 多数元素
 *
 * https://leetcode-cn.com/problems/majority-element/description/
 *
 * algorithms
 * Easy (61.24%)
 * Likes:    456
 * Dislikes: 0
 * Total Accepted:    113.9K
 * Total Submissions: 184.6K
 * Testcase Example:  '[3,2,3]'
 *
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * 
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * 
 * 示例 1:
 * 
 * 输入: [3,2,3]
 * 输出: 3
 * 
 * 示例 2:
 * 
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 * 
 * 
 */

// @lc code=start
public class Solution
{
    public int MajorityElement(int[] nums)
    {
        //1.暴力法：遍历数组，记录所有元素出现的次数，如果当某一元素值大于n/2返回当前元素，O(n)
        if (nums.Length == 1) return nums[0];
        Dictionary<int, int> map = new Dictionary<int, int>();
        for (int i = 0; i < nums.Length; i++)
        {
            if (map.ContainsKey(nums[i]))
            {
                map[nums[i]]++;
                if (map[nums[i]] > nums.Length / 2) return nums[i];
            }
            else
                map.Add(nums[i], 1);
        }
         return 0;
        //2.排序，因为众数定义是大于n/2，所以有且仅有一个，排序复杂度O(NLogN),返回n/2
        // System.Array.Sort(nums);
        // return nums[nums.Length / 2];

        //3.摩尔投票法，根据题意，有且仅有一个众数，且大于n/2，即表示众数出现的次数，大于所有其他数出现总和
        //可以将可能的数先记为1，其他数记为-1
        //设置两个变量 candidate 和 count，candidate 用来保存数组中遍历到的某个数字，count 表示当前数字的出现次数，一开始 candidate 保存为数组中的第一个数字，count 为 1
        // 遍历整个数组
        // 如果数字与之前 candidate 保存的数字相同，则 count 加 1
        // 如果数字与之前 candidate 保存的数字不同，则 count 减 1
        // 如果出现次数 count 变为 0 ，candidate 进行变化，保存为当前遍历的那个数字，并且同时把 count 重置为 1
        // 遍历完数组中的所有数字即可得到结果

        // 作者：MisterBooo
        // 链接：https://leetcode-cn.com/problems/majority-element/solution/du-le-le-bu-ru-zhong-le-le-ru-he-zhuang-bi-de-qiu-/
        // 来源：力扣（LeetCode）
        // 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
        // int candidate = nums[0];
        // int count = 1;
        // for (int i = 1; i < nums.Length; i++)
        // {
        //     if (count == 0)
        //     {
        //         candidate = nums[i];
        //         count++;
        //     }
        //     else
        //     {
        //         if (nums[i] == candidate) count++;
        //         else count--;
        //     }
        // }
        // return candidate;
    }
}
// @lc code=end

