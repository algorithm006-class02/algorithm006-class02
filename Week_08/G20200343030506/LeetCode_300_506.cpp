/*
 * @lc app=leetcode.cn id=300 lang=cpp
 *
 * [300] 最长上升子序列
 */

// @lc code=start
class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        vector<int> minnums;
        for(int v : nums)
        {
            if(!minnums.size() || v > minnums.back()) 
                minnums.push_back(v);
            else
                *lower_bound(minnums.begin(), minnums.end(), v) = v;
        }
        return minnums.size();
    }
};
// @lc code=end

