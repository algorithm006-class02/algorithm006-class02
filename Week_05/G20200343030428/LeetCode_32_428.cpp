/*
 * @lc app=leetcode.cn id=32 lang=cpp
 *
 * [32] 最长有效括号
 */

// @lc code=start
class Solution {
public:
    int longestValidParentheses_single_dir(string s, int i, int flag, int end, char ch){
        int max = 0, sum = 0, currlentLen = 0, validLen = 0;
        while (i!=end){
            sum += (s[i] == ch ? 1 : -1);
            currlentLen++;
            if (sum == 0) validLen = currlentLen;
            else if (sum < 0){
                max = max > validLen ? max : validLen;
                sum = currlentLen = validLen =  0;
            }
            i+=flag;
        }
        return max > validLen ? max : validLen;
    }
    int longestValidParentheses(string s) {
        return max(longestValidParentheses_single_dir(s, 0, 1, s.size(), '('),
        longestValidParentheses_single_dir(s, s.size()-1, -1, -1,')'));
    }
};

// @lc code=end

