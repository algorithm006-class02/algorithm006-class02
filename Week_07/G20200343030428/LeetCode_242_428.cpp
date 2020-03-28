/*
 * @lc app=leetcode.cn id=242 lang=cpp
 *
 * [242] 有效的字母异位词
 */

// @lc code=start
class Solution {
public:
    bool isAnagram(string s, string t) {
        vector<int> check(26);
        for(char c: s) check[c - 'a']++;
        for(char c: t) if(--check[c - 'a'] < 0) return false;
        return accumulate(check.begin(), check.end(), 0) == 0 ? true : false;
    }
};
// @lc code=end

