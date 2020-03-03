
void numIslandsDfs(char** grid, int gridSize, int* gridColSize, int row, int col) {
    if ((row < 0) || (row >= gridSize) || (col < 0) || (col >= gridColSize[row]) || ('1' != grid[row][col])) 
        return; 
    grid[row][col] = 'F'; 

    numIslandsDfs(grid, gridSize, gridColSize, row, col + 1); 
    numIslandsDfs(grid, gridSize, gridColSize, row + 1, col); 
    numIslandsDfs(grid, gridSize, gridColSize, row, col - 1); 
    numIslandsDfs(grid, gridSize, gridColSize, row - 1, col); 
}
int numIslands(char** grid, int gridSize, int* gridColSize) { 
    int i, j, k, res = 0; 
    if ((!grid) || (0 == gridSize) || (!gridColSize)) 
        return 0; 

    for (i = 0; i < gridSize; i++) 
        for (j = 0; j < gridColSize[i]; j++) 
            if ('1' == grid[i][j]) {
                res++; 
                numIslandsDfs(grid, gridSize, gridColSize, i, j); 
            }
   
    return res;  
} 
