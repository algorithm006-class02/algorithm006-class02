/**
 * 91. Decode Ways
 * https://leetcode.com/problems/decode-ways/
 * @param {string} s
 * @return {number}
 */
const numDecodings = (s) => {
  if (s[0] === '0') return 0
  
  const ways = new Array(s.length+1).fill(0).fill(1, 0, 2) // [1,1,0,0,.....]
  for (let i = 2; i <= s.length; i++) {
    let prevOne = Number(s[i-1])  // 前1个字符
    let prevTwo = Number(s[i-2])*10 + Number(s[i-1]) // 前两个字符
    if (1 <= prevOne && prevOne <= 9)  ways[i] += ways[i-1]
    if (10 <= prevTwo && prevTwo <= 26) ways[i] += ways[i-2]
  }
  return ways[s.length]
}

/**
 * 思路：动态规划 
 * 举例：'2223'
 * i = 0; 1 (第一个字符'2' 有1种解码方式)
 * i = 1; 2 (前两个字符'22' 有2种解码方式)
 * i = 2; 3 (前三个字符'222' 有3种解码方式)
 * i = 3; 5 (前四个字符'2223' 有5种解码方式)
 * 发现符合斐波那契数列规律，递推公式即 ways(n) = ways(n-1) + ways(n-2) 
 * 但是这题难就难在有很多边界问题，比如 "2263" 这个数，就不符合上述规律，因为 倒数第一二位 "63" 这个数组不在字母数字范围内
 */

 /**
  * A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given a non-empty string containing only digits, determine the total number of ways to decode it.

Example 1:

Input: "12"
Output: 2
Explanation: It could be decoded as "AB" (1 2) or "L" (12).
Example 2:

Input: "226"
Output: 3
Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
  */