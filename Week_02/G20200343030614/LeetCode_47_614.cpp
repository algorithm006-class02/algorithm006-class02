//去重排列
class Solution {
public:
    vector<vector<int>> res;
    void arrayUniq(vector<int>& nums, int level) {
        if (level==nums.size()) {
            res.push_back(nums);
            return;
        }
        unordered_set<int> uniq;
        for (int i=level; i<nums.size(); i++) {
            if (uniq.count(nums[i])) continue;
            swap(nums[i], nums[level]);
            arrayUniq(nums,level+1);
            swap(nums[i], nums[level]);
            uniq.insert(nums[i]);
        }
    }
    vector<vector<int>> permuteUnique(vector<int>& nums) {
        arrayUniq(nums, 0);
        return res;
    }
};