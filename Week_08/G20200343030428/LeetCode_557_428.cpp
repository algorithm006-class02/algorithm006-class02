/*
 * @lc app=leetcode.cn id=557 lang=cpp
 *
 * [557] 反转字符串中的单词 III
 */

// @lc code=start
class Solution {
public:
    string reverseWords(string s) {
        int n = s.size();
        for (int idx = 0,start = 0 ; idx <= n; ++idx) {
            if (s[idx] == ' ' or idx == n) {
                // go to the end of the word
                int end = idx;
                // reverse the word
                reverse(s.begin() + start, s.begin() + end);
                // move to the next word
                start = end + 1;
            }
        }
        return s;
    }
};


// @lc code=end

