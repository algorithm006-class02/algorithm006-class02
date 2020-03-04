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

        int sum = 0;
        for(int i = 0, j = 0; i < g.size() and j < s.size();j++) {
            if (g[i] <= s[j]) {
                sum++;i++;
            }
        }
        return sum;
    }
};
// @lc code=end

