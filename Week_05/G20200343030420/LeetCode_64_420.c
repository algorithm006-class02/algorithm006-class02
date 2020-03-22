int minPathSum(int** grid, int gridSize, int* gridColSize) {
    int i, j, res; 
    int **dp = (int**)calloc(gridSize, sizeof(int*)); 
    for (i = 0; i < gridSize; i++) 
        dp[i] = (int*)calloc(gridColSize[i], sizeof(int)); 

    dp[gridSize - 1][gridColSize[gridSize - 1] - 1] = grid[gridSize - 1][gridColSize[gridSize - 1] - 1]; 
    j = gridColSize[gridSize - 1] - 1; 
    for (i = gridSize - 2; i >= 0; i--) 
        dp[i][j] = grid[i][j] + dp[i + 1][j];
    for (j = gridColSize[gridSize - 1] - 2 ; j >= 0; j--)     
        dp[gridSize - 1][j] = grid[gridSize - 1][j] + dp[gridSize - 1][j + 1]; 
    
    for (i = gridSize - 2; i >= 0; i--) 
        for (j = gridColSize[i] - 2; j >= 0; j--) 
            dp[i][j] = grid[i][j] + ((dp[i + 1][j] < dp[i][j + 1]) ? dp[i + 1][j] : dp[i][j + 1]); 
        
    res = dp[0][0]; 
    for (i = 0; i < gridSize; i++) 
        free(dp[i]); 
    free(dp); 
    return res; 
}
int minPathSum_2(int** grid, int gridSize, int* gridColSize) {  
    for (int i = gridSize - 1; i >= 0; i--) 
        for (int j = gridColSize[i] - 1; j >= 0; j--) {
            if ((i < gridSize - 1) && (j < gridColSize[i] - 1)) 
                grid[i][j] += (grid[i + 1][j] < grid[i][j + 1]) ? grid[i + 1][j] : grid[i][j + 1]; 
            else if ((i == gridSize - 1) && (j < gridColSize[i] - 1)) 
                grid[i][j] += grid[i][j + 1]; 
            else if ((i < gridSize - 1) && (j == gridColSize[i] - 1)) 
                grid[i][j] += grid[i + 1][j]; 
        } 
      
    return grid[0][0]; 
}
int minPathSum_3(int** grid, int gridSize, int* gridColSize) {  
    int i, j, res; 
    int *dp = (int*)calloc(gridColSize[0] + 1, sizeof(int)); 
    for (j = gridColSize[0] - 1; j >= 0; j--) 
        dp[j] = grid[gridSize - 1][j] + dp[j + 1]; 
    
    for (i = gridSize - 2; i >= 0; i--) 
        for (j = gridColSize[i] - 1; j >= 0; j--) {
            if (j < gridColSize[i] - 1) 
                dp[j] = grid[i][j] + ((dp[j] < dp[j + 1]) ? dp[j] : dp[j + 1]); 
            else
                dp[j] += grid[i][j]; 
        }
        
    res = dp[0]; 
    free(dp); 
    return res; 
}
