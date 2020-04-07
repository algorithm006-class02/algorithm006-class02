/*
 * @lc app=leetcode.cn id=387 lang=cpp
 *
 * [387] 字符串中的第一个唯一字符
 */

// @lc code=start
class Solution {
public:
    int firstUniqChar(string s) {
        int array[26] = {0};
        for (auto c: s) array[c - 'a']++;
        for (int i = 0; i < s.size(); i++) 
            if (array[s[i] - 'a'] == 1) return i;
        return -1;
    }
};
// @lc code=end

