/*
 * @lc app=leetcode.cn id=91 lang=javascript
 *
 * [91] 解码方法
 *
 * https://leetcode-cn.com/problems/decode-ways/description/
 *
 * algorithms
 * Medium (22.54%)
 * Likes:    311
 * Dislikes: 0
 * Total Accepted:    36.7K
 * Total Submissions: 158.1K
 * Testcase Example:  '"12"'
 *
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 * 
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 
 * 
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 * 
 * 示例 1:
 * 
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 
 * 
 * 示例 2:
 * 
 * 输入: "226"
 * 输出: 3
 * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 * 
 * 
 */

// @lc code=start
/**
 * @param {string} s
 * @return {number}
 */
var numDecodings = function(s) {
    if (s === '0' || s.length === 0) return 0

    const dp = Array(s.length + 1).fill(0)
    dp[0] = 1
    dp[1] = s[0] !== "0" ? 1 : 0
    for (let i = 2; i < s.length + 1; i++) {
        const one = +s.slice(i - 1, i)
        const two = +s.slice(i - 2, i)

        if (two >= 10 && two <= 26) {
            dp[i] = dp[i - 2]
        }

        if (one >= 1 && one <= 9) {
            dp[i] += dp[i - 1]
        }
    }

    return dp[dp.length - 1]
};
// @lc code=end

