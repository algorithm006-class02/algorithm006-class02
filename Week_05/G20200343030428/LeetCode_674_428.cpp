/*
 * @lc app=leetcode.cn id=647 lang=cpp
 *
 * [647] 回文子串
 */

// @lc code=start
class Solution {
public:
    int countSubstrings(string s) {
        int len = s.size();
        bool dp[len][len] = {};
        int result = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i; j >= 0; j--) {
                if ((s[i] == s[j]) and ( (i - j < 2) or dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                    result++;
                }
            }
        }
        return result;
    }
};
// @lc code=end

