/* 二维矩阵从左到右从上到下是单调递增，因此考察的是二分查找，重点在于一维坐标和二维坐标的转换 */ 
bool searchMatrix_2(int** matrix, int matrixSize, int* matrixColSize, int target) {
    if ((!matrix) || (0 == matrixSize)) 
        return false; 

    int s = 0, e = matrixSize * matrixColSize[0] - 1, mid, row, col; 
    while (s <= e) {    //这里是<=, 否则找不到，自己debug一下就知道了
        mid = s + (e - s) / 2; 
        row = mid / matrixColSize[0]; 
        col = mid % matrixColSize[0]; 
        if (target == matrix[row][col]) 
            return true; 
        else if (target < matrix[row][col]) 
            e = mid - 1; 
        else 
            s = mid + 1; 
    }
    return false; 
}
/* 递推式查找，原理和两次查找差不多，右下的总是大于左上的，直接在矩阵上操作 */ 
bool searchMatrix_3(int** matrix, int matrixSize, int* matrixColSize, int target) {
    if ((!matrix) || (0 == matrixSize)) 
        return false; 
    int row = 0, col = matrixColSize[row] - 1; 
    while ((row < matrixSize) && (col >= 0)) {
        if (target < matrix[row][col]) 
            col--; 
        else if (target > matrix[row][col]) 
            row++; 
        else 
            return true; 
    }
    return false; 
}
