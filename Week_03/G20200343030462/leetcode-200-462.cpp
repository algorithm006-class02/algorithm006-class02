class Solution {
public:
    int numIslands(vector<vector<char>>& grid) {
        int iCounter = 0;
        for(int i = 0; i < grid.size(); ++i)
            for(int j = 0; j < grid[i].size(); ++j)
            {
                if('1' == grid[i][j])
                {
                    ++iCounter;
                    dfs(i,j,grid);
                }
            }
        return iCounter;
    }
private:
    //这个递归函数的作用就是消除以(x,y)为中心点的所有1
    void dfs(int x,int y, std::vector<std::vector<char>> &grid)
    {
        //递归终止条件
        if(x < 0 || y < 0 || x >= grid.size() || y >= grid[x].size() || '0' == grid[x][y])
            return;
        grid[x][y] = '0';
        dfs(x + 1,y,grid);
        dfs(x - 1,y,grid);
        dfs(x,y + 1,grid);
        dfs(x,y - 1,grid);
    }
};
