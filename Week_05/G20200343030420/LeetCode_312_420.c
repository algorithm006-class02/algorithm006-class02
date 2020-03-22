/**
 * 1. 暴力回溯，dfs，每次递归处理一个气球。肯定会超时，暂不考虑
 * 2. 分治，分解为独立子问题。n个气球，对于中间第k个气球(0<=k<n)，将气球分为三组：[0:k-1],[k],[k+1:n-1].
 * 假设先戳破k，子问题之间会产生干扰。转变下思路，最后戳破k，这样k前后的两个区间不会干扰，子问题独立。
 * 例如：(1),3,1,5,8,(1) ---> (1),3,1,(1) + (1),5,(1) + (1),8,(1). (1)表示虚拟气球，不可戳
 * 因此对于区间[s:e],f[s,e]表示第s个到第e个气球的最大得分，s-1和e+1表示虚拟气球。
 * f[s,e] = MAX{f[s,k-1] + nums[s-1] * nums[k] * nums[e+1] + f[k+1,e]}, 其中s<=k<=e;
 * f[s,e]用二维数组缓存起来，递归来求解
 * 3. DP，在2的基础上，自底向上，将递归转为递推。
 */
int maxCoins(int* nums, int numsSize) {
    if ((!nums) || (0 == numsSize)) 
        return 0; 
    int s, e, k, d, maxVal, res; 
    int kLeftVal, kRightVal;  
    int **dp = calloc(numsSize, sizeof(int*)); 
    for (k = 0; k < numsSize; k++) 
        dp[k] = calloc(numsSize, sizeof(int)); 

    for (d = 0; d < numsSize; d++) 
        for (s = 0; s < numsSize - d; s++) {
            e = s + d; 
            maxVal = 0; 
            for (k = s; k <= e; k++) {
                kLeftVal = (s <= k - 1) ? dp[s][k - 1] : 0; 
                kRightVal =  (k + 1 <= e) ? dp[k + 1][e] : 0; 
                res = kLeftVal + kRightVal + ((s - 1 >= 0) ? nums[s - 1] : 1) * nums[k] * ((e + 1 < numsSize) ? nums[e + 1] : 1); 
                maxVal = (res > maxVal) ? res : maxVal; 
            }
            dp[s][e] = maxVal; 
        }

    res = dp[0][numsSize - 1]; 
    for (k = 0; k < numsSize; k++) 
        free(dp[k]); 
    free(dp); 
    return res; 
}
