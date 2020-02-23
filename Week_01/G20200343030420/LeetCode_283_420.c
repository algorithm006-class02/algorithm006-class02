void moveZeroes(int* nums, int numsSize) {
    for (int slow = 0, curr = 0; curr < numsSize; curr++) {
        if (0 != nums[curr]) {
            nums[slow] = nums[curr]; 
            if (curr > slow)
                nums[curr] = 0; 
            slow++; 
        } 
    } 
}
