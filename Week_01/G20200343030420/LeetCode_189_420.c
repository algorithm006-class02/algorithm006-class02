void swapInt(int* num1, int* num2) {
    int temp = *num1; *num1 = *num2; *num2 = temp; 
}
void reverseArray(int *nums, int numsSize) {
    int i = 0, mid = numsSize / 2; 
    for ( ; i < mid; i++) {
        swapInt(nums + i, nums + numsSize - 1 - i); 
    }
}
void rotate(int* nums, int numsSize, int k) {
    if ((NULL == nums) || (numsSize <= 1) || (k <= 0)) 
        return; 
    k %= numsSize; 
    reverseArray(nums, numsSize); 
    reverseArray(nums, k); 
    reverseArray(nums + k, numsSize - k);
}
