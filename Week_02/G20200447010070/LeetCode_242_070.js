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
  if (s.length !== t.length) return false;

  let count = new Array(26).fill(0);
  for (let i = 0; i < s.length; i++) {
    count[s[i] - "a"]++;
    count[t[i] - "a"]--;
  }
  for (const i of count) {
    if (i != 0) return false;
  }
  return true;
};
// @lc code=end
