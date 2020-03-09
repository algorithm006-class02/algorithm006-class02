/** 
 * 若nums[s]<=nums[mid]，说明左边是有序的
 * 若目标值在nums[s]和nums[mid]之间的时候，在左边部分用二分查找，否则确定到右边部分
 * 若nums[s]>nums[mid]时，说明左边部分非有序，
 * 若目标值在nums[mid]和nums[e]之间的时候，在右边部分用二分查找，否则确定到左边部分
 */ 
int search(int* nums, int numsSize, int target) {
    if ((!nums) || (numsSize < 1)) 
        return -1; 
    int s = 0, e = numsSize - 1, mid; 
    while (s <= e) {
        mid = s + ((e - s) >> 1); 
        if (target == nums[mid]) 
            return mid; 
        if (nums[s] <= nums[mid]) {
            /* 左边有序 */ 
            if ((target >= nums[s]) && (target < nums[mid])) 
                e = mid - 1; 
            else 
                s = mid + 1; 
        } 
        else {
            /* 右边有序 */ 
            if ((target > nums[mid]) && (target <= nums[e])) 
                s = mid + 1; 
            else 
                e = mid - 1; 
        }
    }
    return -1; 
}
