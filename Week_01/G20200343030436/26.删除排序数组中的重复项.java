/*
 * @lc app=leetcode.cn id=26 lang=java
 *
 * [26] 删除排序数组中的重复项
 */

// @lc code=start
class Solution {
    //快慢指针
    //num[i] == num[j] j跳过重复项
    //num[i] != num[j] i++ 新长度数组的长度加1 num[j] 赋值给num[i]
    public int removeDuplcates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;//返回去重新长度
    }
}
// @lc code=end

