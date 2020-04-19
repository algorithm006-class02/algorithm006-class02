class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int result = 0;
        for (int i = 0; i < m; i++) { // m , n need match;
            for (int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    dfsIslans(grid,i,j,m,n);
                    result ++;
                }
            }
        }
        return result;
    }

    private void dfsIslans(char[][] grid, int i, int j, int m, int n){
        if (i < 0|| j < 0 || i >= m || j >= n || grid[i][j] == '0'){ // i need larger than m; j larger than n;
            return;
        }
        grid[i][j] = '0';
        dfsIslans(grid, i+1, j, m, n);
        dfsIslans(grid, i-1, j, m, n);
        dfsIslans(grid, i, j+1, m, n);
        dfsIslans(grid, i, j-1, m, n);
    }
}