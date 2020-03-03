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

    // 全排列模板
    void backtrack (vector<vector<int>>& result, vector<int> nums, int cur) {
        // 次数结束，交换过的所有数
        if (cur == nums.size())
            result.push_back(nums);

        // 从0开始到最后，每个数字保证俩俩交换过
        for (int i = cur; i < nums.size(); ++i) {
            swap(nums[cur],nums[i]);
            backtrack(result,nums,cur + 1);
        }
    }

    // 入口函数
    vector<vector<int>> permute(vector<int>& nums) {
        vector<vector<int>> result;
        backtrack(result, nums, 0);
        return result;
    }
};
// @lc code=end

