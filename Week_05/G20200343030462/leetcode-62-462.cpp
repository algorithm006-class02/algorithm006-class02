class Solution {
public:
    int uniquePaths(int m, int n) {
        vector<vector<int>> grid(m,vector<int>(n));       //m行n列
        //因为棋盘的左边界和上边界都是只能向右走一步或者向下走一步
        for(int row = 0; row < m; ++row)
            grid[row][0] = 1;         //网格上第一列的值是1
        for(int col = 0; col < n; ++col)
            grid[0][col] = 1;         //网格上第一行是0
        for(int row = 1; row < m; ++row)
            for(int col = 1; col < n; ++col)
                grid[row][col] = grid[row - 1][col] + grid[row][col - 1];
        return grid[m - 1] [n - 1];
    }
};
