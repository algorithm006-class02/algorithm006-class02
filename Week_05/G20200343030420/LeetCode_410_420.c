/** 
 * n个元素分为m个连续子组(n>=m)的分法: 
 * 1 : m-1个元素分为m-1组，剩下n-m+1个为一组; 
 * 2 : m个元素分为m-1组，剩下n-m个为一组; 
 * 归纳: n个元素分为[0:k]和[k+1,n-1]两部分(m-2<=k<n-1)，[0:k]分为m-1组，[k+1,n-1]为一组
 */
int splitArray(int* nums, int numsSize, int m) {
    if ((!nums) || (numsSize < 1) || (m > numsSize)) 
        return 0; 
    int i, j, k; 
    long sum, minVal; 
    long **dp = calloc(m, sizeof(long*)); 
    for (i = 0; i < m; i++) 
        dp[i] = calloc(numsSize, sizeof(long)); 

    dp[0][0] = nums[0]; 
    for (j = 1; j < numsSize; j++) 
        dp[0][j] = dp[0][j - 1] + nums[j]; 
    
    for (i = 1; i < m; i++) 
        for (j = i; j < numsSize; j++) {
            minVal = dp[i - 1][j]; 
            for (k = i - 1; k < j; k++) {
                //sum = calcSum(nums, k + 1, j); 
                /* dp[0][j]就是[0:j]的元素和，直接做差，不用重新计算。这个优化保证测试通过，否则超时 */ 
                sum = dp[0][j] - dp[0][k]; 
                sum = (sum > dp[i - 1][k]) ? sum : dp[i - 1][k]; 
                /* 所有分法的最大和，里面取最小的 */ 
                minVal = (minVal < sum) ? minVal : sum; 
            }
            dp[i][j] = minVal; 
        }

    minVal = dp[m - 1][numsSize - 1]; 
    for (i = 0; i < m; i++) 
        free(dp[i]); 
    free(dp); 
    return minVal; 
}
