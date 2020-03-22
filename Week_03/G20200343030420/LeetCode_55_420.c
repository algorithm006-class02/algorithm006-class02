/* 去除回溯的正宗DP，自底向上（这个非常重要），根据已计算的状态来计算新状态 */ 
bool canJump_4(int* nums, int numsSize) {
    if ((!nums) || (numsSize < 1)) 
        return false; 
    /* dp[i]表示位置i是否可以走到最后，0:未判断；1:可以走到最后 */ 
    int i, j, maxJump; 
    int *dp = calloc(numsSize, sizeof(int)); 
    dp[numsSize - 1] = 1; 
    for (i = numsSize - 2; i >= 0; i--) {
        maxJump = (i + nums[i] < numsSize - 1) ? i + nums[i] : numsSize - 1; 
        for (j = i + 1; j <= maxJump; j++) {
            if (1 == dp[j]) {
                /* i可以走所有j的位置，只要j中有一个能走到最后，那么i肯定能走到最后，所以找到后直接break */ 
                dp[i] = 1; 
                break; 
            }
        }
    }
    free(dp); 
    return (1 == dp[0]) ? true : false; 
} 
/* 贪心：从后往前遍历，如果位置i能跳到最后，就把数组从i处截断，也即是将i视为终点。看遍历结束时，终点是否等于起点，如果是，则可以 */ 
bool canJump(int* nums, int numsSize) {
    if ((!nums) || (numsSize < 1)) 
        return false; 
    int i, target = numsSize - 1; 
    for (i = numsSize - 2; i >= 0; i--) {
        if (i + nums[i] >= target) 
            target = i; 
    }
    return (0 == target) ? true : false; 
} 
