class Solution {
public:
    vector<vector<int>> combine(int n, int k) {
        if( n <= 0 || k <= 0 || n < k)
            return {};
        std::vector<int> vecPath;       //保存选择结果的临时遍历
        std::vector<std::vector<int>> vecRet;
        backtrack(1,n,k,vecPath,vecRet);
        return vecRet;
    }

private:
    //回溯函数
    void backtrack(int iFirst,int n,int k,std::vector<int> &vecPath,std::vector<std::vector<int>> &vecRet)
    {
        //结束条件
        if(k == vecPath.size())
        {
            vecRet.push_back(vecPath);
            return;
        }
        
        //回溯过程
        for(int i = iFirst; i <= n; ++i)
        {
            //选择
            vecPath.push_back(i);
            backtrack(i + 1,n,k,vecPath,vecRet);        //i + 1，去除(1,1)这样的重复结果
            //撤销选择
            vecPath.pop_back();
        }
    }
};
