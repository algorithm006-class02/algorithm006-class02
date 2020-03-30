/*
 * @lc app=leetcode.cn id=242 lang=javascript
 *
 * [242] 有效的字母异位词
 */

// @lc code=start
/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isAnagram = function(s, t) {
    if (s.length != t.length) {
        return false;
    }
    const charMap = {};
    for (let index = 0; index < s.length; index++) {
        charMap[s[index]] ? (charMap[s[index]]++):(charMap[s[index]] = 1);
    }
    for (let index = 0; index < t.length; index++) {
        if (charMap[t[index]] && charMap[t[index]] > 0) {
            charMap[t[index]]--;
        }else {
            return false;
        }
        
    }

    return true;
};
// @lc code=end

