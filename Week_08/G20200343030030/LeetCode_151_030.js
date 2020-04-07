/*
 * @lc app=leetcode.cn id=151 lang=javascript
 *
 * [151] 翻转字符串里的单词
 */

// @lc code=start
/**
 * @param {string} s
 * @return {string}
 */
var reverseWords = function(s) {
    return s.trim().split(/\s+/).reverse().join(" ");
};

// var reverseWords = function(s) {
//     return s
//     .split(" ")
//     .reverse()
//     .map((word) => word.trim())
//     .filter((word) => word)
//     .join(" ");
// }



// @lc code=end

