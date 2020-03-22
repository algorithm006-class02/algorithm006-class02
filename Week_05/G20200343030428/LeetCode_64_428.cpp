/*
 * @lc app=leetcode.cn id=64 lang=cpp
 *
 * [64] 最小路径和
 */

// @lc code=start
class Solution {
public:
    int minPathSum(vector<vector<int>>& grid) {
        int m = grid.size();
        int n = grid[0].size();
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(i == 0 && j != 0) grid[i][j] += grid[i][j-1];
                else if(j == 0 && i != 0)    grid[i][j] += grid[i-1][j];
                else if(i != 0 && j != 0)    grid[i][j] += min(grid[i][j - 1], grid[i - 1][j]); 
            }
        }
        return grid[m-1][n-1];
    }
};

// @lc code=end

