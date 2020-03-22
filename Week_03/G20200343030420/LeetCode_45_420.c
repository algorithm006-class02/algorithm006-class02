int jump(int* nums, int numsSize) {
    if ((!nums) || (numsSize < 1)) 
        return -1; 
    int i, j, minVal, maxPos; 
    int *dp = calloc(numsSize, sizeof(int)); 
    dp[numsSize - 1] = 0;   //最后元素无需跳跃  
    for (i = numsSize - 2; i >= 0; i--) {
        //maxPos表示位置i可以到达的最大位置
        maxPos = ((i + nums[i]) < (numsSize - 1)) ? (i + nums[i]) : (numsSize - 1); 
        //从nums[i+1 : maxPos]中选择最小值，然后 + 1作为dp[i]。
        minVal = dp[i + 1]; 
        for (j = i + 1; j <= maxPos; j++) {
            if (minVal > dp[j]) 
                minVal = dp[j]; 
        }
        dp[i] = minVal + 1; 
    }

    minVal = dp[0]; 
    free(dp); 
    return minVal; 
}
