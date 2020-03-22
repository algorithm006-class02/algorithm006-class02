class Solution {
    public int countSubstrings(String s) {
        int result = 0;
        // 子问题：F(N)中是否存在回文，最后累加起来
        boolean[][] dp = new boolean[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (i == j) {
                    dp[i][j] = true;
                } else {
                    dp[i][j] = s.charAt(i) == s.charAt(j) && (j == i - 1 || dp[i - 1][j + 1]);
                }
                if (dp[i][j]) {
                    result++;
                }
            }
        }
        return result;
    }
}