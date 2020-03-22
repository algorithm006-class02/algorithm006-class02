//200
//https://leetcode-cn.com/problems/number-of-islands/

class Solution {
public:
    int numIslands(vector<vector<char>>& grid) {
        int count = 0;
        for (int i = 0; i < grid.size(); i++) {
            for (int k = 0; k < grid[0].size(); k++) {
                if ('1' == grid[i][k]) {
                    count += sink(grid, i, k);
                }    
            }
        }
        return count;
    }

    int sink(vector<vector<char>>& grid, int i, int k) {
        if ('0' == grid[i][k]) {
            return 0;
        }    
        grid[i][k] = '0';
        if (i > 0)
            sink(grid, i - 1, k);
        if (i < grid.size() - 1) 
            sink(grid, i + 1, k);
        if (k > 0) 
            sink(grid, i, k - 1);
        if (k < grid[0].size() -  1) 
            sink(grid, i, k + 1);
        return 1;
    }
};
