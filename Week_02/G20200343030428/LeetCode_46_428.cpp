/*
 * @lc app=leetcode.cn id=46 lang=cpp
 *
 * [46] 全排列
 */

// @lc code=start
class Solution {
public:
    vector<vector<int>> permute(vector<int>& nums) {
        vector<vector<int>>ret;
        sort(nums.begin(),nums.end());
        do{
            ret.push_back(nums);
        }while(next_permutation(nums.begin(),nums.end()));
        return ret;
    }
};
// @lc code=end

