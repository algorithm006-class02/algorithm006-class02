class Solution {
public:
    vector<vector<int>> permuteUnique(vector<int>& nums) {
        if(nums.empty())
            return {};
        std::vector<std::vector<int>> vecRet;
        backtrack(nums,vecRet,0);
        return vecRet;
    }
private:
    //参数nums：就是输入序列；vecRet：保存结果的输出数组；iLevel：决策树的层级编号，这个需要你把决策树画出来自己看一下
    void backtrack(std::vector<int> &nums,std::vector<std::vector<int>> &vecRet,int iLevel)
    {
        if(iLevel == nums.size())
        {
            //说明已经到了决策树的最底下一层，现在的nums已经调整为最终的解了
            vecRet.push_back(nums);
            return ;
        }
        
        //把这一次决策过程中所做的选择保存下来，如果回溯的时候发现要做的选择已经在这个集合里了，那么决策树上这个分支就可以减掉了，去除重复
        std::unordered_set<int> unsetUsedEle;
        //iLevel的最大值是nums.size()，但是当它取到最大的时候，递归返回，所以不会产生数组溢出的问题
        for(int i = iLevel; i < nums.size(); ++i)
        {
            if(unsetUsedEle.find(nums[i]) != unsetUsedEle.end())
                continue;       //说明已经用过了
            swap(nums[i],nums[iLevel]);     //通过这个swap，它把nums调整成了想要的输出
            backtrack(nums,vecRet,iLevel + 1);
            swap(nums[i],nums[iLevel]);     //经过这个swap，则不nums还原成了最初始的状态
            unsetUsedEle.insert(nums[i]);
        }
    }
};
