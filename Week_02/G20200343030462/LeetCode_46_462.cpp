class Solution {
public:
    vector<vector<int>> permute(vector<int>& nums) {
        std::vector<int> vecPath;           //一次决策的决策列表
        std::vector<std::vector<int>> vecRet;
        backtrack(nums,vecPath,vecRet);
        return vecRet;
    }

private:
    void backtrack(const std::vector<int> &vecInput,std::vector<int> &vecPath,std::vector<std::vector<int>> &vecRet)
    {
        if(vecInput.size() == vecPath.size())
        {
            vecRet.push_back(vecPath);
            return;
        }
        
        //回溯过程
        for(int i = 0 ; i < vecInput.size(); ++i)
        {
            if ( std::find(vecPath.begin(),vecPath.end(),vecInput[i]) != vecPath.end() )        //已经做过的决策就不用再做了
                continue;
            vecPath.push_back(vecInput[i]);
            backtrack(vecInput,vecPath,vecRet);
            vecPath.pop_back();
        }
    }
};
