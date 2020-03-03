/*
 * @lc app=leetcode.cn id=77 lang=cpp
 *
 * [77] 组合
 */

// @lc code=start
class Solution {
public:
    void i_combine( vector<vector<int>>& res, vector <int>& aux, int n, int k, int i)
    {
        if(k == 0)
        {
            res.push_back(aux);
            return;
        }
        
        for(;i <= n; ++i)
        {
            aux.push_back(i);
            i_combine(res,aux,n,k-1,i+1);
            aux.pop_back();
        }
    }
    vector<vector<int>> combine(int n, int k) {
        vector <vector<int>> res;
        vector <int> aux;
        i_combine(res,aux,n,k,1);
        return res;
    }
};
// @lc code=end

