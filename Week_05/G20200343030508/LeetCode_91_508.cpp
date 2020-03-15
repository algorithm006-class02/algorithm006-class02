/*
 * @lc app=leetcode.cn id=91 lang=cpp
 *
 * [91] 解码方法
 *
 * https://leetcode-cn.com/problems/decode-ways/description/
 *
 * algorithms
 * Medium (23.02%)
 * Likes:    311
 * Dislikes: 0
 * Total Accepted:    36.8K
 * Total Submissions: 158.2K
 * Testcase Example:  '"12"'
 *
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 * 
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 
 * 
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 * 
 * 示例 1:
 * 
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 
 * 
 * 示例 2:
 * 
 * 输入: "226"
 * 输出: 3
 * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 * 
 * 
 */

// @lc code=start
class Solution {
public:
    int numDecodings(string s) {
        if (s == "" || s[0] == '0') return 0;
        int len = s.size();
        vector<int> dp(len + 1, 0);
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 1; i < len; i++) {
            //ai=0 & ai-1=0
            if (s[i] == '0' && s[i - 1] == '0') return 0;
            if (s[i] == '0') {
                //ai=0 && ai-1 ！=0 && [ai][ai-1]>26
                if (s[i - 1] != '0' && (s[i - 1] > '2' || (s[i - 1] == '2' && s[i] > '6'))) return 0;
                //ai=0 && ai-1 ！=0 && [ai][ai-1]<=26
                dp[i + 1] = dp[i - 1];
            }
            else {
                if (s[i - 1] != '0') {
                    //ai!=0 && ai-1 !=0 && [ai][ai-1]>26
                    if (s[i - 1] > '2' || (s[i - 1] == '2' && s[i] > '6')) {
                        dp[i + 1] = dp[i];
                    }
                    else {
                    //ai!=0 && ai-1 !=0 && [ai][ai-1]<=26
                        dp[i + 1] = dp[i] + dp[i - 1];
                    }
                }
                else {
                    //ai!=0 && ai-1=0
                    dp[i + 1] = dp[i];
                }
               
            }

        }
        return dp[len];
    }
};
// @lc code=end

