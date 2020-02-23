//1
//https://leetcode.com/problems/two-sum

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int, int> val_idx;
        for (int i = 0; i < nums.size(); ++i) {
            if (val_idx.find(target - nums[i]) != val_idx.end()) {
                return {val_idx[target - nums[i]], i};
            }
            val_idx[nums[i]] = i;
        }
        return {0,0};
    }
};
