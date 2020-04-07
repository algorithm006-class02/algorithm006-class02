/*
 * @lc app=leetcode.cn id=115 lang=java
 *
 * [115] 不同的子序列
 */

// @lc code=start
class Solution {
    //dp[i][j]:  表示 T前i字符串可以由S j字符串组成最多个数
    // dp 转移方程
    // if s[j] == T[i] dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1]
    // if s[j] != T[i] dp[i][j] = dp[i][j - 1]

    // 对于第一行, T 为空,因为空集是所有字符串子集, 所以我们第一行都是 1
    // 对于第一列, S 为空,这样组成 T 个数当然为 0` 了
    public int numDistinct(String s, String t) {
        int[][] dp = new int[t.length() + 1][s.length() + 1];
        for (int j = 0; j < s.length() + 1; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < t.length() + 1; i++) {
            for (int j = 1; j < s.length() + 1; j++) {
                if (t.charAt(i - 1) == s.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[t.length()][s.length()];
    }
}
// @lc code=end

