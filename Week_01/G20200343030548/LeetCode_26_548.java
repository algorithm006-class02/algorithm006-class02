/*
 * @lc app=leetcode.cn id=26 lang=java
 *
 * [26] 删除排序数组中的重复项
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int n = nums[0], j = 1;
        for(int i = 1; i < nums.length; i++){
            if(n != nums[i]){
                nums[j] = nums[i];
                n = nums[i];
                j++;
            }
        }
        return j;
    }
}
// @lc code=end