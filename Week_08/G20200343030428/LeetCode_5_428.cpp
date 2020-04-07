/*
 * @lc app=leetcode.cn id=5 lang=cpp
 *
 * [5] 最长回文子串
 */

// @lc code=start
class Solution {
public:
    string longestPalindrome(string s) {
    const int size_s = s.size();
    int max_s = 0, max_l = 0;

    for (int i = 0; i < size_s;) {
        int start = i, end = i;
        while (end + 1 < size_s && s[end] == s[end+1]) end++;
        i = end + 1;
        // 找一个中心向俩边扩展
        while (start - 1 >= 0 && end + 1 < size_s && s[start-1] == s[end+1]) {
            start--;
            end++;
        }
        if (end - start + 1 > max_l) {
            max_l = end - start + 1;
            max_s = start;
        }
    }
    return s.substr(max_s, max_l);
}
};
// @lc code=end

