/*
 * @lc app=leetcode.cn id=46 lang=cpp
 *
 * [46] 全排列
 */

// @lc code=start
class Solution {
public:
    // 巧用C++ 已经实现的 next_permutation 全排列
    // vector<vector<int>> permute(vector<int>& nums) {
    //     vector<vector<int>>ret;
    //     sort(nums.begin(),nums.end());
    //     do{
    //         ret.push_back(nums);
    //     }while(next_permutation(nums.begin(),nums.end()));
    //     return ret;
    // }

    void helper (vector<vector<int>>& res, vector<int> nums, int cur) {
        if (cur == nums.size())
            res.push_back(nums);

        for (int i = cur; i < nums.size(); ++i) {
            swap(nums[cur],nums[i]);
            helper(res,nums,cur + 1);
        }
    }
    
    vector<vector<int>> permute(vector<int>& nums) {
        vector<vector<int>> res;
        sort(nums.begin(),nums.end());
        helper(res, nums, 0);
        return res;
    }
};
// @lc code=end

