/*
 * @lc app=leetcode.cn id=169 lang=cpp
 *
 * [169] 多数元素
 */

// @lc code=start
class Solution {
public:
    int majorityElement(vector<int>& nums) {
        int length = nums.size();
        sort(nums.begin(), nums.end());
        return nums[length/2];
    }
};
// @lc code=end

