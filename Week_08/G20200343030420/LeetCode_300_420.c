int lengthOfLIS(int* nums, int numsSize) {
    if ((!nums) || (0 == numsSize))
        return 0; 
    int i, j, res = 0; 
    int *dp = calloc(numsSize, sizeof(int)); 
    dp[0] = 1; 
    for (i = 1; i < numsSize; i++) {
        dp[i] = 1; 
        for (j = 0; j < i; j++) {
            if (nums[i] > nums[j]) 
                dp[i] = (dp[i] > dp[j] + 1) ? dp[i] : dp[j] + 1; 
        }
    }
    for (i = 0; i < numsSize; i++) 
        res = (res > dp[i]) ? res : dp[i]; 
    free(dp); 
    return res; 
}
