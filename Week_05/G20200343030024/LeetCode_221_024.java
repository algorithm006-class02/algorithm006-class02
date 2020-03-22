class Solution {
    public int maximalSquare(char[][] matrix) {
    int M = matrix.length;
    int N = matrix[0].length;
    int[][] dp = new int[M + 1][N + 1];
    int max = 0;
    for (int i = 1; i <= M; i++) {
        for (int j = 1; j <= N; j++) {
            if (matrix[i - 1][j - 1] == '0') {
                dp[i][j] = 0;
            } else {
                dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                max = Math.max(dp[i][j], max);
            }
        }
    }
    return max * max;
    }
}