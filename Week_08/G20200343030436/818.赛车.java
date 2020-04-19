/*
 * @lc app=leetcode.cn id=818 lang=java
 *
 * [818] 赛车
 */

// @lc code=start
class Solution {
    // 1维数组 dp, dp[i]代表走到的位置所需要的最小步数
    // 因为先向前走forword再向后走back步
    // 与先向后走back步，再向前走forword步最后达到的位置相同
    // 顾 假设永远保持第一步是向前走。
    // 1 刚好forword 步后到达目标位置i dp【i】 = forward
    // 2向前走forward步后到达了i后面，这时需要再往后走，再假设回头的一步
    // dp[i] = Math.min（dp[i],forward + 1 +dp[j - 1]）
    // 3 向前走forword 步后未到达位置i处就需要返回
    // 此时在保证返回的步数back < forward的条件下遍历 back 此时 dp【i】 = Math.min（dp[i],forword+ 1 + back + 1 dp[i - j + k]）
    public int racecar(int target) {
        int[] dp = new int[target + 1];
        for (int i = 1; i <= target; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int forward = 1; (1 << forward) - 1 < 2 * i; forward++) {
                int j = (1 << forward) - 1;
                if (j == i) {
                    dp[i] = forward;
                } else if (j > i) {
                    dp[i] = Math.min(dp[i], forward + 1 + dp[j - i]);
                } else {
                    for (int back = 0; back < forward; back++) {
                        int k = (1 << back) - 1;
                        dp[i] = Math.min(dp[i], forward + 1 + back + 1 + dp[i - j + k]);
                    }
                }
            }
        }
        return dp[target];
    }
}
// @lc code=end

