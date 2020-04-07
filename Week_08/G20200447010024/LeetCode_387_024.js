/*
 * @lc app=leetcode.cn id=387 lang=javascript
 *
 * [387] 字符串中的第一个唯一字符
 *
 * https://leetcode-cn.com/problems/first-unique-character-in-a-string/description/
 *
 * algorithms
 * Easy (42.28%)
 * Likes:    197
 * Dislikes: 0
 * Total Accepted:    69.1K
 * Total Submissions: 156.4K
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
    const obj = {}
    const arrs = s.split('')
    for (let i = 0; i < arrs.length; i++) {
        obj[arrs[i]] = obj[arrs[i]] ? [...obj[arrs[i]], i] : [i]
    }

    for (let key in obj) {
        if (obj[key].length === 1) {
            return obj[key][0]
        }
    }

    return -1
};
// @lc code=end

