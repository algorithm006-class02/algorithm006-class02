/* 计算n的阶乘 */ 
long calcFactorials(int n) {
    if (0 == n) 
        return 1; 
    return n * calcFactorials(n - 1); 
}
void swapInt(int* num1, int* num2) {
    int temp = *num1; *num1 = *num2; *num2 = temp; 
}
void backTrap(int* nums, int numsSize, int procIndex, int* returnSize, int** returnColumnSizes, int **res) {
    if (procIndex == numsSize) {
        res[*returnSize] = calloc(numsSize, sizeof(int)); 
        memcpy(res[*returnSize], nums, numsSize * sizeof(int)); 
        (*returnColumnSizes)[*returnSize] = numsSize; 
        (*returnSize)++; 
        return; 
    }
    for (int i = procIndex; i < numsSize; i++) {
        swapInt(&nums[i], &nums[procIndex]); 
        backTrap(nums, numsSize, procIndex + 1, returnSize, returnColumnSizes, res); 
        swapInt(&nums[i], &nums[procIndex]); 
    }
}
/**
 * Return an array of arrays of size *returnSize.
 * The sizes of the arrays are returned as *returnColumnSizes array.
 * Note: Both returned array and *columnSizes array must be malloced, assume caller calls free().
 */
/**
 * nums = [1, 2, 3], 固定1，递归剩下的[2,3]; 固定2（交换1和2），递归剩下的[1,3]; 固定3(交换1和3)，递归剩下的[1,2];
 * 相当于遍历数组每个元素，将其与首元素交换后，递归剩下的数组。这样得到最终所有的组合
 */
int** permute(int* nums, int numsSize, int* returnSize, int** returnColumnSizes) {
    if ((!nums) || (0 == numsSize)) 
        return NULL; 
    long rowSize = calcFactorials(numsSize); 
    int **res = calloc(rowSize, sizeof(int*)); 
    *returnColumnSizes = calloc(rowSize, sizeof(int)); 
    *returnSize = 0; 
    backTrap(nums, numsSize, 0, returnSize, returnColumnSizes, res); 
    return res; 
}


