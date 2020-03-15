class Solution {
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        if (n == 0) {
            return 0;
        }
        int m = matrix[0].length;
        int[][] opt = new int[n + 1][m + 1];
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '1') {
                    opt[i + 1][j + 1] = Math.min(Math.min(opt[i][j], opt[i + 1][j]), opt[i][j + 1]) + 1;
                    max = Math.max(opt[i + 1][j + 1] * opt[i + 1][j + 1], max);
                }
            }
        }
        return max;
    }
}
