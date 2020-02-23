/*
 * @lc app=leetcode.cn id=46 lang=cpp
 *
 * [46] 全排列
 */

// @lc code=start
class Solution {
public:
    vector<vector<int>> permute(vector<int>& nums) {
        
        vector<vector<int>> res;
        
        if(nums.size() == 1){
            res.push_back(vector<int>(1,nums[0]));
            return res;
        }
        
        for(int i = 0; i < nums.size(); i++){
            vector<int>temp(nums);
            temp.erase(temp.begin()+i);
            vector<vector<int>> intermediate = permute(temp);
            for(int j = 0; j < intermediate.size(); j++){
                intermediate[j].push_back(nums[i]);
                res.push_back(intermediate[j]);
            }
        }
        
        return res;
        
    }
};
// @lc code=end

