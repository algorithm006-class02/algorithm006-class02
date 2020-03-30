/**
 * Return an array of arrays of size *returnSize.
 * The sizes of the arrays are returned as *returnColumnSizes array.
 * Note: Both returned array and *columnSizes array must be malloced, assume caller calls free().
 */
typedef struct {
    int leftKey; 
    int row; 
} XXX; 
void swapX(XXX *xxx, int m, int n) {
    XXX temp = xxx[m]; 
    xxx[m] = xxx[n]; 
    xxx[n] = temp; 
}
void quickSortX(XXX *xxx, int left, int right) {
    int pivot = right, curr, index; //index之前的都是小于哨兵的,index始终指向第一个大于哨兵的
    if (left >= right) 
        return; 
    for (curr = left, index = left; curr < right; curr++) {
        if (xxx[curr].leftKey < xxx[pivot].leftKey) {
            swapX(xxx, curr, index); 
            index++; 
        }
    }
    swapX(xxx, index, pivot); 
    quickSortX(xxx, left, index - 1); 
    quickSortX(xxx, index + 1, right); 
}
int** merge(int** intervals, int intervalsSize, int* intervalsColSize, int* returnSize, int** returnColumnSizes) {
    if ((!intervals) || (0 == intervalsSize) || (!intervalsColSize)) {
        *returnSize = 0; 
        return NULL; 
    } 
    int i = 0, r, rn = 0;   //rn=0是为了应对只有一组区间的情况
    XXX *pX = calloc(intervalsSize, sizeof(XXX)); 
    for (i = 0; i < intervalsSize; i++) {
        pX[i].leftKey = intervals[i][0]; 
        pX[i].row = i; 
    }
    quickSortX(pX, 0, intervalsSize - 1); 

    int **res = calloc(intervalsSize, sizeof(int*)); 
    *returnColumnSizes = calloc(intervalsSize, sizeof(int)); 
    *returnSize = 0; 
    for (i = 0; i < intervalsSize - 1; i++) {
        r = pX[i].row; 
        rn = pX[i + 1].row; 
        if (intervals[rn][0] <= intervals[r][1]) {
            intervals[rn][0] = intervals[r][0]; 
            intervals[rn][1] = (intervals[rn][1] > intervals[r][1]) ? intervals[rn][1] : intervals[r][1]; 
        } 
        else {
            res[*returnSize] = calloc(2, sizeof(int)); 
            memcpy(res[*returnSize], intervals[r], 2 * sizeof(int)); 
            (*returnColumnSizes)[*returnSize] = 2; 
            (*returnSize)++; 
        }
    }
    res[*returnSize] = calloc(2, sizeof(int)); 
    memcpy(res[*returnSize], intervals[rn], 2 * sizeof(int)); 
    (*returnColumnSizes)[*returnSize] = 2; 
    (*returnSize)++; 
    free(pX); 
    return res; 
}
