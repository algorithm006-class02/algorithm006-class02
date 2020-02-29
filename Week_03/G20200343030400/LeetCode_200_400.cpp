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
        if (i == -1 || i == grid.size() || k == -1 || k == grid[0].size() || '0' == grid[i][k]) {
            return 0;
        }    
        grid[i][k] = '0';
        sink(grid, i - 1, k);
        sink(grid, i + 1, k);
        sink(grid, i, k - 1);
        sink(grid, i, k + 1);
        return 1;
    }
};
