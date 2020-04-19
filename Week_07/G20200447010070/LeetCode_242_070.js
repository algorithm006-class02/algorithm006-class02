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
  let map = {};
  for (let ch of s) {
    map[ch] = (map[ch] || 0) + 1;
  }
  for (let ch of t) {
    if (!map[ch]) return false;
    map[ch]--;
  }
  return true;
};
// @lc code=end
