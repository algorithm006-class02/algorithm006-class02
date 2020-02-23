//47
//https://leetcode-cn.com/problems/permutations-ii

class Solution {
public:
    vector<vector<int>> permuteUnique(vector<int>& nums) {
        vector<vector<int>> res;
        backtrack(nums, 0, res);
        return res;
    }

    void backtrack(vector<int>& nums, int begin, vector<vector<int>>& res) {
        if (begin == nums.size() - 1 || nums.size() == 0) {
            res.push_back(nums);
            return;
        }
        unordered_map<int, bool> duplicate;
        for (int i = begin; i < nums.size(); ++i) {
            if (!duplicate.count(nums[i])) {
                swap(nums[i], nums[begin]);
                backtrack(nums, begin + 1, res);
                swap(nums[i], nums[begin]);
                duplicate[nums[i]] = true;
            }
        }
        return;
    }
};
