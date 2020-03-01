                                                                               class Solution {
public:
    //回溯法解决问题
    vector<vector<int>> subsets(vector<int>& nums) {
        std::vector<std::vector<int>> vecRet;
        std::vector<int> vecPath;
        backtrack(0,nums,vecPath,vecRet);
        return vecRet;
    }
private:
    void backtrack(const int iLevel,const std::vector<int> &nums, std::vector<int> & vecPath,std::vector<std::vector<int>> &vecRet)
    {
        if(iLevel == nums.size())
        {
            vecRet.push_back(vecPath);
            return;
        }
        
        //不选当前元素
        backtrack(iLevel + 1,nums,vecPath,vecRet);
        
        //选择当前元素
        vecPath.push_back(nums[iLevel]);
        backtrack(iLevel + 1,nums,vecPath,vecRet);
        vecPath.pop_back();
    }
};
