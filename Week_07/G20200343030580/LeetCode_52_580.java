class Solution {
    public int totalNQueens(int n) {
        return dfs(n, 0, 0, 0, 0, (1 << n) - 1);
    }

    private int dfs(int n, int level, int col, int xy, int yx, int mask) {
        if (level == n) {
            return 1;
        }
        int count = 0;
        int bits = (~(col | xy | yx)) & mask;
        while (bits > 0) {
            int p = bits & (-bits);
            bits -= p;
            count += dfs(n, level + 1, col | p, (p | xy) >> 1, (p | yx) << 1, mask);
        }
        return count;
    }
}