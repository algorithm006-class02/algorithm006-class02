/*
 * @lc app=leetcode.cn id=541 lang=cpp
 *
 * [541] 反转字符串 II
 */

// @lc code=start
class Solution {
public:
    string reverseStr(string s, int k) {
        for (int i = 0; i < s.size(); i += 2 * k) {
            if (i + k > s.size()) {
                reverse(s.begin() + i, s.end());
                break;
            } 
            reverse(s.begin() + i, s.begin() + i + k);
        }
        return s;
    }
};
// @lc code=end

