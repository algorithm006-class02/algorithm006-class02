//46
//https://leetcode-cn.com/problems/permutations

class Solution {
public:
    void dfs(vector<int>& nums, int begin, vector<vector<int>>& res) {
        if (begin == nums.size() - 1 || nums.size() == 0) {
            res.push_back(nums);
            return;
        }
        for (int i = begin; i < nums.size(); ++i) {
            swap(nums[begin], nums[i]);
            dfs(nums, begin + 1, res);
            swap(nums[begin], nums[i]);
        }
        return;
    }

    vector<vector<int>> permute(vector<int>& nums) {
        vector<vector<int>> res;
        dfs(nums, 0, res);
        return res;
    }
};
