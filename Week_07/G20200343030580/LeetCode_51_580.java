class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] store = new char[n][n];
        List<List<String>> result = new ArrayList<>();
        dfs(n, 0, 0, 0, 0, (1 << n) - 1, store, result);
        return result;
    }

    private void dfs(int n, int level, int col, int xy, int yx, int mask, char[][] store, List<List<String>> result) {
        if (level == n) {
            List<String> answer = new ArrayList<>(n);
            for (char[] cs : store) {
                answer.add(new String(cs));
            }
            result.add(answer);
            return;
        }
        int bits = (~(col | xy | yx)) & mask;
        while (bits > 0) {
            int p = bits & (-bits);
            bits -= p;
            for (int i = 1 << n - 1, j = 0; i > 0; i = i >> 1, j++) {
                if (i == p) {
                    store[level][j] = 'Q';
                } else {
                    store[level][j] = '.';
                }
            }
            dfs(n, level + 1, col | p, (p | xy) >> 1, (p | yx) << 1, mask, store, result);
            Arrays.fill(store[level], '.');
        }
        return;
    }
}
