//回溯算法，内部元素一个一个比较，内部是暴力法
class Solution {
public:
    vector<vector<int>> res;
    void arrays(vector<int>& nums, vector<int>& it) {
        if (it.size()==nums.size()) {
            res.push_back(it);
            return;
        }
        for (int i=0; i<nums.size(); i++) {
            int k;
            for (k=0; k<it.size(); k++) {
                if (it[k]==nums[i]) break;
            }
            if (k!=it.size()) continue;
            it.push_back(nums[i]);
            arrays(nums, it);
            it.pop_back();
        }
    }
    vector<vector<int>> permute(vector<int>& nums) {
        if (nums.size()<=0) return res;
        vector<int> it;
        arrays(nums, it);
        return res;
    }
};