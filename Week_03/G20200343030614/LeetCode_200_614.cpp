//BFS，发现一个岛屿，每前进一步就开始探索每个方位
class Solution {
public:
    void step(vector<vector<char>>& grid, int r, int c) {
        grid[r][c]='0';
        int width=grid.size();
        int length=grid[0].size();
        if (r-1>=0 && grid[r-1][c]=='1')
            step(grid, r-1, c);
        if (r+1<width && grid[r+1][c]=='1')
            step(grid, r+1, c);
        if (c-1>=0 && grid[r][c-1]=='1')
            step(grid, r, c-1);
        if (c+1<length && grid[r][c+1]=='1')
            step(grid, r, c+1);
    }
    int numIslands(vector<vector<char>>& grid) {
        int width=grid.size();
        if (!width) return 0;
        int length=grid[0].size();
        int islandNum=0;
        for (int i=0; i<width; i++) {
            for (int j=0; j<length; j++) {
                if (grid[i][j]=='1') {
                    islandNum++;
                    step(grid, i, j);
                }
            }
        }
        return islandNum;
    }
};