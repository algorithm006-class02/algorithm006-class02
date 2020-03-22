/** 
 * dp[i][j]表示从[0,0]到[i,j]的矩形和，单独一个点也算是矩形，初始第0行和第0列的矩形和为节点本身值。
 * 遍历所有点，遍历到的当前点记为[row,col]，以[0,0]为起点，[row,col]为终点，统计其内所有矩形的和。
 */
#define MIN_VAL     (-65535)
int getMaxSum(int *nums, int size, int k) {
    /* 可以先将nums排序，求解时可以剪枝。我们这里直接暴力法 */ 
    int l, r, temp, res = MIN_VAL; 
    for (l = 0; l < size; l++) {
        temp = 0;         
        for (r = l; r < size; r++) {
            temp += nums[r]; 
            if ((temp <= k) && (res < temp)) 
                res = temp; 
        }
    }
    //printArray(nums, size); 
    //printf("getMaxSum: %d,", res); 
    return res; 
}
int maxSumSubmatrix(int** matrix, int matrixSize, int* matrixColSize, int k) {
//int maxSumSubmatrix(int (*matrix)[15], int matrixSize, int* matrixColSize, int k) {    
    int colStart = 0, row, col, temp, res = MIN_VAL;
    int *rowSum = calloc(matrixSize, sizeof(int)); 

    while (colStart < matrixColSize[0]) {
        memset(rowSum, 0, matrixSize * sizeof(int)); 
        
        for (col = colStart; col < matrixColSize[0]; col++) {
            //printf("[%2d, %2d]\t", colStart, col); 
            //rowSum[row]表示第row行，colStart到col的累加和
            for (row = 0; row < matrixSize; row++)                          
                rowSum[row] += matrix[row][col]; 
            /* 问题转为求rowSum数组中连续元素累加和不超过k的最大和值 */ 
            temp = getMaxSum(rowSum, matrixSize, k); 
            res = (temp > res) ? temp : res; 
            //printf("    res: %d\n", res); 
        }

        colStart++; 
    } 
    free(rowSum); 
    return res; 
}
