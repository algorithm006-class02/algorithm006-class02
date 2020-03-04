/*
 * @lc app=leetcode.cn id=455 lang=cpp
 *
 * [455] 分发饼干
 */

// @lc code=start
class Solution {
public:
    int findContentChildren(vector<int>& g, vector<int>& s) {
        sort(g.begin(), g.end());
        sort(s.begin(), s.end());
        int j = 0;
        int i = 0;
        while(i < g.size() && j < s.size()){
            if(g[i] <= s[j]){
                i++;j++;
            } else {
                j++;
            }
        }
        return i;
    }
};
// @lc code=end

