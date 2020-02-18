// @lc code=start
public class Solution
{
    public int RemoveDuplicates(int[] nums)
    {
        if (nums.Length == 0)
        {
            return 0;
        }
        //双指针，快指针i遍历数组，慢指针j更新值
        int j = 0;
        for (int i = 1; i < nums.Length; i++)
        {
            if (nums[i] != nums[j])
            {
                j++;
                nums[j] = nums[i];
            }
        }
        return j + 1;
    }
}
// @lc code=end