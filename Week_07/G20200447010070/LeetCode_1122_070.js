/*
 * @lc app=leetcode.cn id=1122 lang=javascript
 *
 * [1122] 数组的相对排序
 */

// @lc code=start
/**
 * @param {number[]} arr1
 * @param {number[]} arr2
 * @return {number[]}
 */
var relativeSortArray = function(arr1, arr2) {
  let map = {};
  let res = [];
  for (let i = 0; i < arr1.length; i++) {
    map[arr1[i]] = (map[arr1[i]] || 0) + 1;
  }
  for (let i = 0; i < arr2.length; i++) {
    while (map[arr2[i]]) {
      res.push(arr2[i]);
      map[arr2[i]]--;
    }
  }
  for (let key in map) {
    while (map[key]) {
      res.push(key);
      map[key]--;
    }
  }
  return res;
};
// @lc code=end
