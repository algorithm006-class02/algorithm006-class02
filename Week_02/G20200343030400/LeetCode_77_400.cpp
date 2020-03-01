//77
//https://leetcode-cn.com/problems/combinations

class Solution {
public:
    vector<vector<int>> combine(int n, int k) {
        if (n <= 0 || k <= 0 || n < k) {
            return {};
        }
        vector<vector<int>> res;
        vector<int> ans(k);
        dfs(ans, 0, 0, n, res);
        return res;
    }

    void dfs(vector<int>& ans, int idx, int begin, int n, vector<vector<int>>& res) {
        if (idx == ans.size()) {
            res.push_back(ans);
            return;
        }
        for (int i = begin; i < n; ++i) {
            ans[idx] = i + 1;
            dfs(ans, idx + 1, i + 1, n, res);
        }
        return;
    }
};
