//239
//https://leetcode-cn.com/problems/sliding-window-maximum

int* maxSlidingWindow(int* nums, int numsSize, int k, int* returnSize){
    if (numsSize * k == 0) {
        *returnSize = 0;
        return NULL;
    }
    if (k == 1) {
         *returnSize = numsSize;
        return nums;
    }
    
    *returnSize = numsSize - k + 1;
    int *ret = malloc(sizeof(int) * (*returnSize));

    int max = nums[0];
    //find first max
    for(int i = 1; i < k ; i++){
        if (nums[i] > max) {
            max = nums[i];
        }
    }
    ret[0] = max;
    
    for (int i = 1; i < *returnSize; i++) {
        // nums[i-1], max, nums[i+k-1]
        // one out  , max, one just in
        if (nums[i + k - 1] > max) {
            max = nums[i + k - 1];
        } else if (nums[i - 1] == max) {
            max = nums[i];
            for (int j = i; j < i + k; j++) {
                if (nums[j] > max)
                    max = nums[j];
            }
        }
        ret[i] = max;
    }
    return ret;
}
