/**
 * 120. Triangle
 * https://leetcode.com/problems/triangle/
 * @param {number[][]} triangle
 * @return {number}
 */
/**
 * DP
 * dp[row][col] = Math.min(dp[row+1][col], dp[row+1][col+1])
 */
const minimumTotal = (triangle) => {
  let rowLen = triangle.length
  for (let row = rowLen-2; row >= 0; row--) {
    for (let col = 0; col < triangle[row].length; col++) {
      triangle[row][col] += Math.min(triangle[row+1][col], triangle[row+1][col+1])
    }  
  }
  return triangle[0][0]
}

 /**
  * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:

Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
  */