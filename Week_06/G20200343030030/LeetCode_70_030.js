/*
 * @lc app=leetcode.cn id=70 lang=javascript
 *
 * [70] 爬楼梯
 */

// @lc code=start
/**
 * @param {number} n
 * @return {number}
 */
var climbStairs = function(n) {
    //var memo = new Array(n+1);
    //climb_stairs(0,n,memo);
    if (n == 1) {
        return 1;
    }
    var dp = new Array(n+1);
    dp[1] = 1;
    dp[2] = 2;
    for (var i = 3; i <= n; i++) {
        dp[i] = dp[i - 1] + dp[i - 2];
    }
    return dp[n];
};
function climb_stairs(i,n,memo) {
    if (i > n) {
        return 0;
    }
    if (i == n) {
        return 1;
    }
    if (memo[i] > 0) {
        return memo[i];
    }
    memo[i] = climb_stairs(i+1,n,memo) + climb_stairs(i+2,n,memo);
    return memo[i];
}



// @lc code=end

