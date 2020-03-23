/*
 * @lc app=leetcode.cn id=547 lang=cpp
 *
 * [547] 朋友圈
 */

// @lc code=start
class Solution {
public:
    vector<bool> visit;
    void dfs(int& i, vector<vector<int>>& M){
        if(visit[i]) return;
        visit[i] = true;
        for(int j = 0; j < M.size(); j++){
            if(M[i][j]) dfs(j, M);
        }
    }
    
    int findCircleNum(vector<vector<int>>& M) {
        int n = M.size();
        int cnt = 0;
        visit.assign(n, false);
        for(int i = 0; i < n; i++){
            if(!visit[i]){
                cnt++;
                dfs(i, M);
            }
        }
        return cnt;
    }
};
// @lc code=end

