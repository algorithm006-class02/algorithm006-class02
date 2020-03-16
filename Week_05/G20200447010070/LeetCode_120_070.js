/*
 * @lc app=leetcode.cn id=120 lang=javascript
 *
 * [120] 三角形最小路径和
 */

// @lc code=start
/**
 * @param {number[][]} triangle
 * @return {number}
 */
var minimumTotal = function(triangle) {
  var len = triangle.length;
  var row = 0;
  var col = 0;
  var memo = new Array(row);
  for (var i = 0; i < len; i++) {
    // 由题可知每行最大列数即为行数
    memo[i] = new Array(row);
  }
  function helper(row, col, triangle) {
    // terminator
    if (row == len - 1) {
      return (memo[row][col] = triangle[row][col]);
    }
    // drill down
    var left = helper(row + 1, col, triangle);
    var right = helper(row + 1, col + 1, triangle);
    return Math.min(left, right) + triangle[row][col];
  }
  return helper(row, col, triangle);
};
// @lc code=end
