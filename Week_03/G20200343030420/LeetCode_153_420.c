/* 找到第一个比num[0]小的元素 */ 
int findMin(int* nums, int numsSize) {
    if ((!nums) || (numsSize < 1)) 
        return -1; 
    if ((1 == numsSize) || (nums[numsSize - 1] > nums[0])) 
        return nums[0];  
    int l = 0, r = numsSize - 1, mid; 
    while (l < r) {
        mid = l + ((r - l) >> 1); 
        if (nums[0] <= nums[mid]) {
            /* 在右边找最小元素。=是为了防止mid为0的情况 */ 
            l = mid + 1; 
        } 
        else {
            /* 已经找到比nums[0]小的，尝试继续找更小的 */ 
            r = mid; 
        }
    }
    /* 结束时 l==r */ 
    return nums[l]; 
}
