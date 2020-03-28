int getIndex(int* arr2, int arr2Size, int val) {
    for (int i = 0; i < arr2Size; i++) 
        if (val == arr2[i])
            return i; 
    return -1; 
}
/**
 * Note: The returned array must be malloced, assume caller calls free().
 * 存在于arr2中的元素采用计数排序 + 不存在于arr2中的元素采用插入排序
 */
int* relativeSortArray(int* arr1, int arr1Size, int* arr2, int arr2Size, int* returnSize) {
    int *res = calloc(arr1Size, sizeof(int)); 
    int *num = calloc(arr2Size, sizeof(int)); 
    int i, j, id, cnt = 0; 
    int left = arr1Size - 1; 
    for (i = 0; i < arr1Size; i++) {
        id = getIndex(arr2, arr2Size, arr1[i]); 
        if (-1 == id) {
            //插入排序，大的放最后
            if (left == arr1Size - 1) 
                res[left--] = arr1[i]; 
            else {
                j = left + 1; 
                while ((j <= arr1Size - 1) && (arr1[i] >= res[j])) {
                    res[j - 1] = res[j]; 
                    j++; 
                }
                res[j - 1] = arr1[i]; 
                left--; 
            }
        }
        else 
            num[id]++; 
    }
    for (i = 0; i < arr2Size; i++) 
        while (num[i]--) 
            res[cnt++] = arr2[i]; 
    *returnSize = arr1Size; 
    free(num); 
    return res; 
}
