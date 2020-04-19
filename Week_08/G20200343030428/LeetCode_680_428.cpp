/*
 * @lc app=leetcode.cn id=680 lang=cpp
 *
 * [680] 验证回文字符串 Ⅱ
 */

// @lc code=start

class Solution {
public:
    bool validPalindrome(string s) {
        return validPal(s, 0, s.size() - 1);
    }

    bool validPal(string &s, int i, int j, bool usedSkip = false) {
        for(; i < j; i++, j--)
            if(s[i] != s[j]) 
                return usedSkip ? false : validPal(s, i + 1, j, true) || validPal(s, i, j - 1, true);
        return true;        
    }
};


// @lc code=end

