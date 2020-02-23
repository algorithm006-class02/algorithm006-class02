/*
 * @lc app=leetcode.cn id=26 lang=cpp
 *
 * [26] 删除排序数组中的重复项
 * ### 解题思路
 * 一、 时间复杂度O(n)
 *     标记一个偏移量，遇到不同的就偏移加一
 * ### 代码
*/

// @lc code=start
class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        if(nums.size() == 0) return 0;
        int i = 0;
        for(int j = 1; j < nums.size(); j++){
            if(nums[j] != nums[i]){
                nums[++i] = nums[j];
            }
        }
        return i + 1;
    }
};
// @lc code=end