/*
 * @lc app=leetcode.cn id=44 lang=java
 *
 * [44] 通配符匹配
 */

// @lc code=start
class Solution {
    //状态 dp[i][j] : 表示 s 的前 i 个字符和 p 的前 j 个字符是否匹配 (true 的话表示匹配)
    //状态转移方程：
    // 1 当 s[i] == p[j] 或者 p[j] == ? 那么 dp【i】[j] = dp[i - 1][j - 1]
    // 2 当 p[j] == * 那么 dp[i][j] = dp[i][j - 1]|| dp[i - 1][j]
    // 例如 dp[i][j - 1] 表示 * 代表 空字符 例如 ab , ab*
    // dp[i - 1][j] 表示 * 代表 * 代表的是非空字符 例如 abcd，ab*
    //初始化
    //  dp[0][0]表示什么都没有 其值为true
    // 第一行 dp【0】[j] 可以理解为 s为空， 与p匹配，所以只要p开始为 *才为true
    // 第1列 dp[i][0] 当然全部为false
    public boolean isMatch(String s, String p){
        int m = s.length();
        int n = p.length();
         // 状态 dp[i][j] : 表示 s 的前 i 个字符和 p 的前 j 个字符是否匹配
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        //init
        for(int i = 1; i <= n; i++) {
            dp[0][i] = dp[0][i - 1] && p.charAt(i - 1) == '*';
        }
        //状态转移
        for (int i = 1; i <= m; i++){
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                } 
            }
        }
        return dp[m][n];
    }
}
// @lc code=end

