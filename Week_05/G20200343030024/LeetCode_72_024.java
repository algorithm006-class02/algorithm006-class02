class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        if (n * m == 0){
            return n + m;
        }

        int[][] f = new int[n+1][m+1];
        for (int i = 0; i < n + 1; i++){
            f[i][0] = i;
        }

        for (int i = 0; i < m + 1; i++){
            f[0][i] = i;
        }
        // 子问题：从word1中i变换到word2中的j的最少编辑方式
        // 当 word1[i] == word2[j]，dp[i][j] = dp[i-1][j-1]；
        // 否则 min(dp[i-1][j-1],dp[i-1][j],dp[i][j-1])+1
        // dp[i-1][j-1] 表示替换操作，dp[i-1][j] 表示删除操作，dp[i][j-1] 表示插入操作
        for (int i = 1; i < n + 1; i++){
            for (int j = 1; j < m + 1; j++){
                int left = f[i - 1][j] + 1;
                int down = f[i][j - 1] + 1;
                int left_down = f[i - 1][j - 1];

                if (word1.charAt(i - 1) != word2.charAt(j - 1)){
                    left_down += 1;
                }
                f[i][j] = Math.min(left, Math.min(down, left_down));
            }
        }
        return f[n][m];
    }
}