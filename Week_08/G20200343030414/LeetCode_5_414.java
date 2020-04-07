package Week_08.G20200343030414;

/**
 * @author Xinshuai
 * @description 题目链接：https://leetcode-cn.com/problems/longest-palindromic-substring/
 * @since 2020-04-05 18:10
 */
public class LeetCode_5_414 {

    /**
     * DP方程：dp[i][j] = (s[i] == s[j]) and dp[i + 1][j - 1]（dp[i][j] 表示子串 s[i, j] 是否为回文子串。）
     */
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        int maxLen = 1;
        int start = 0;
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (s.charAt(i) == s.charAt(j)) {
                    // 边界条件：表达式 [i + 1, j - 1] 不构成区间，即长度严格小于 2，即 j - 1 - (i + 1) + 1 < 2 ，整理得 j - i < 3。
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                } else {
                    dp[i][j] = false;
                }
                if (dp[i][j]) {
                    int curLen = j - i + 1;
                    if (curLen > maxLen) {
                        maxLen = curLen;
                        start = i;
                    }
                }
            }
        }
        return s.substring(start, start + maxLen);
    }

}
