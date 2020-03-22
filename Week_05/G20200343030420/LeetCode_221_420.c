int getMinOfThree(int a, int b, int c) {
    if (a < b) {
        if (a < c) 
            return a; 
        else 
            return c; 
    }
    else {
        if (b < c) 
            return b; 
        else 
            return c; 
    }
}
int maximalSquare(char** matrix, int matrixSize, int* matrixColSize) {
    int i, j, maxLen = 0; 
    int **dp = calloc(matrixSize, sizeof(int*)); 
    for (i = 0; i < matrixSize; i++) 
        dp[i] = calloc(matrixColSize[i], sizeof(int)); 

    for (i = 0; i < matrixSize; i++) 
        for (j = 0; j < matrixColSize[i]; j++) {
            if ('1' == matrix[i][j]) {
                dp[i][j] = 1; 
                if ((i > 0) && (j > 0) && (dp[i - 1][j - 1] > 0) && (dp[i - 1][j] > 0) && (dp[i][j - 1] > 0)) 
                    dp[i][j] = getMinOfThree(dp[i - 1][j - 1], dp[i - 1][j], dp[i][j - 1]) + 1; 
                maxLen =  (dp[i][j] > maxLen) ? dp[i][j] : maxLen; 
            } 
            else 
                dp[i][j] = 0; 
        }

    for (i = 0; i < matrixSize; i++) 
        free(dp[i]); 
    free(dp); 
    return (maxLen * maxLen); 
}
