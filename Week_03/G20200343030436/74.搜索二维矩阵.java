/*
 * @lc app=leetcode.cn id=74 lang=java
 *
 * [74] 搜索二维矩阵
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) {
            return false;
        }
        int n = matrix[0].length;
        int left = 0, right = m * n - 1;
        int mid, midValue;
        while (left <= right) {
            mid = left + (right - left) / 2;
            midValue = matrix[mid / n][mid % n];
            if (target == midValue) {
                return true;
            } else {
                if (target < midValue) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return false;
    }
}
// @lc code=end

