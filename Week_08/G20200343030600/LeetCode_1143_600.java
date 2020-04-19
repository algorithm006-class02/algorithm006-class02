/**
 * 1143. 最长公共子序列
 */

class Solution {
    //dp状态定义为二维数组
    public int longestCommonSubsequence1(String text1, String text2) {
        if(text1 == null || text1.length() == 0 || text2 == null || text2.length() == 0) return 0;
        int n1 = text1.length(), n2 = text2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        for(int i = 1; i <= n1; i++) {
            for(int j = 1; j <= n2; j++) {
                if(text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[n1][n2];
    }

    //使用一维数组dp
    public int longestCommonSubsequence2(String text1, String text2) {
        if(text1 == null || text1.length() == 0 || text2 == null || text2.length() == 0) return 0;
        int n1 = text1.length(), n2 = text2.length();
        int[] dp = new int[n2 + 1];
        for(int i = 0; i < n1; i++) {
            int prev = dp[0];
            for(int j = 1; j <= n2; j++) {
                int temp = dp[j];
                if(text1.charAt(i) == text2.charAt(j - 1)) {
                    dp[j] = prev + 1;
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }
                prev = temp;
            }
        }
        return dp[n2];
    }
}