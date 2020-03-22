/*
 * @lc app=leetcode.cn id=91 lang=cpp
 *
 * [91] 解码方法
 */

// @lc code=start
class Solution {
public:
    int numDecodings(string s) {
        if (s[0] == '0') return 0;
        vector<int> dp(s.size()+1);
        dp[0]=1;dp[1]=1;
        for (int i =1; i < s.size(); i++) {
            if (s[i] == '0')//1.s[i]为0的情况
                if (s[i - 1] == '1' || s[i - 1] == '2') //s[i - 1]等于1或2的情况
                    dp[i+1] = dp[i-1];//由于s[1]指第二个下标，对应为dp[2],所以dp的下标要比s大1，故为dp[i+1]
                else 
                    return 0;
            else //2.s[i]不为0的情况
                if (s[i - 1] == '1' || (s[i - 1] == '2' && s[i] <= '6'))//s[i-1]s[i]两位数要小于26的情况
                    dp[i+1] = dp[i]+dp[i-1];
                else//其他情况
                    dp[i+1] = dp[i];
        }
        return dp[s.size()];
    }
};
// @lc code=end

