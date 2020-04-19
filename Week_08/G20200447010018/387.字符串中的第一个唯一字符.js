/*
 * @lc app=leetcode.cn id=387 lang=javascript
 *
 * [387] 字符串中的第一个唯一字符
 *
 * https://leetcode-cn.com/problems/first-unique-character-in-a-string/description/
 *
 * algorithms
 * Easy (43.21%)
 * Likes:    197
 * Dislikes: 0
 * Total Accepted:    69.2K
 * Total Submissions: 156.6K
 * Testcase Example:  '"leetcode"'
 *
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * 
 * 案例:
 * 
 * 
 * s = "leetcode"
 * 返回 0.
 * 
 * s = "loveleetcode",
 * 返回 2.
 * 
 * 
 * 
 * 
 * 注意事项：您可以假定该字符串只包含小写字母。
 * 
 */

// @lc code=start
/**
 * @param {string} s
 * @return {number}
 */
var firstUniqChar = function(s) {
    let res = -1;
    for (let i = 0; i < s.length; i++) {
        if (i === s.indexOf(s[i]) && s.indexOf(s[i], i + 1) === -1) {
            res = i;
            break;
        }
    }
    return res;
};
// @lc code=end

