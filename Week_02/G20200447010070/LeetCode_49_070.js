/*
 * @lc app=leetcode.cn id=49 lang=javascript
 *
 * [49] 字母异位词分组
 */

// @lc code=start
/**
 * @param {string[]} strs
 * @return {string[][]}
 */
var groupAnagrams = function(strs) {
  if (!strs || strs.length === 0) return [];
  let map = new Map();
  for (let str of strs) {
    let key = [...str].sort().join("");
    if (map.has(key)) {
      map.get(key).push(str);
    } else {
      map.set(key, [str]);
    }
  }
  return [...map.values()];
};
// @lc code=end
