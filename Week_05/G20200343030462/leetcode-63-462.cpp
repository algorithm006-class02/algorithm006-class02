class Solution {
public:
    //动态规划
    int uniquePathsWithObstacles(vector<vector<int>>& obstacleGrid) {
        //第一个格子就是障碍物，那就不用往前走了
        if(1 == obstacleGrid[0][0])
            return 0;
        //题目说，这个格子里的数就是0和1,1的时候表示有障碍物，不能通行
        
        obstacleGrid[0][0] = 1;
        int row = obstacleGrid.size();
        int col = obstacleGrid[0].size();
        //这个数组的存在完全是因为grid[row][col] = grid[row -1][col] + grid[row][col - 1]; 相加有可能会导致int溢出
        vector<vector<long>> grid{row,vector<long>(col)};
        for(int i = 0; i < row; ++i)
            for(int j = 0; j < col; ++j)
                grid[i][j] = obstacleGrid[i][j];
        //处理第一行
        for(int col = 1; col < grid[0].size(); ++col)
        {
            grid[0][col] = (1 == grid[0][col - 1] && 0 == grid[0][col]) ? 1 : 0;    //三目运算符，如果条件成立说明当前格子上不是障碍物
        }
        
        //处理第一列
        for(int row = 1; row < grid.size(); ++ row)
        {
            grid[row][0] = (1 == grid[row - 1][0] && 0 == grid[row][0]) ? 1 : 0;
        }
        
        for(int row = 1; row < grid.size(); ++row)
            for(int col = 1; col < grid[row].size(); ++col)
            {
                if(1 == grid[row][col])
                {
                    grid[row][col] = 0;
                    continue;
                }
                else
                    grid[row][col] = grid[row -1][col] + grid[row][col - 1];
            }
        return grid[row - 1][col - 1];
    }
};
