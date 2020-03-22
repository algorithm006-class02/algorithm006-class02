/*
 * @lc app=leetcode.cn id=221 lang=cpp
 *
 * [221] 最大正方形
 */

// @lc code=start
class Solution {
public:
    int maximalSquare(vector<vector<char>>& matrix) {
        if (matrix.size() == 0) return 0;
        int m = matrix.size();
        int n = matrix[0].size();
        int res = 0, i = 0, j = 0, ii = 0, jj = 0;
        while (i < m or j < n) {
            if (i < m) {
                ii = i;
                jj = 0;
                i++;
            } else if (j < n) {
                ii = 0;
                jj = j;
                j++;
            }
            int dp = 0;
            while (ii < m and jj < n) {
                if (matrix[ii][jj] == '0')
                    dp = 0;
                else {
                    int k = 1;
                    while (k <= dp and matrix[ii-k][jj] == '1' and matrix[ii][jj-k] == '1') {
                        k++;
                    }
                    dp = k;
                }
                ii++; jj++;
                res = std::max(res, dp);
            }
        }
        return res*res;
    }
};
// @lc code=end

