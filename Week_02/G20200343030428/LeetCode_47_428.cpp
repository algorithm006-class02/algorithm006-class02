/*
 * @lc app=leetcode.cn id=47 lang=cpp
 *
 * [47] 全排列 II
 */

// @lc code=start
class Solution {
public:
    void helper (vector<vector<int>>& res, vector<int> nums, int cur) {
        if (cur == nums.size())
            res.push_back(nums);

        // 俩俩交换
        // 去重：1.不延续自己， 2.保证有效交换
        for (int i = cur; i < nums.size(); ++i) {
            if (cur == i || nums[cur] != nums[i]) {
                swap(nums[cur],nums[i]);
                helper(res,nums,cur + 1);
            }
        }
    }
    // 入口函数
    vector<vector<int>> permuteUnique(vector<int>& nums) {
        vector<vector<int>> res;
        sort(nums.begin(),nums.end());
        helper(res,nums,0);
        return res;
    }
};
// @lc code=end

