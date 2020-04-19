class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        if (n == 0) {
            return result;
        }
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        Set<Integer> shu = new HashSet<>();
        Set<Integer> pie = new HashSet<>();
        Set<Integer> na = new HashSet<>();
        solve(0, n, board, shu, pie, na, result);
        return result;
    }

    private void solve(int level, int n, char[][] board, Set<Integer> shu, Set<Integer> pie, Set<Integer> na, List<List<String>> result) {
        if (level == n) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(new String(board[i]));
            }
            result.add(list);
            return;
        }
        for (int i = 0; i < n; i++) {
            int key = level * n + i;
            if (shu.contains(key) || pie.contains(key) || na.contains(key)) {
                continue;
            }
            board[level][i] = 'Q';
            for (int j = level; j < n; j++) {
                shu.add(key + n * (j - level));
            }
            for (int j = level, k = i; j < n && k < n; j++, k++) {
                pie.add(key + (n + 1) * (j - level));
            }
            for (int j = i, k = level; j > -1 && k < n; j--, k++) {
                na.add(key + (n - 1) * (i - j));
            }
            solve(level + 1, n, board, shu, pie, na, result);
            board[level][i] = '.';
            for (int j = level; j < n; j++) {
                shu.remove(key + n * (j - level));
            }
            for (int j = level, k = i; j < n && k < n; j++, k++) {
                pie.remove(key + (n + 1) * (j - level));
            }
            for (int j = i, k = level; j > -1 && k < n; j--, k++) {
                na.remove(key + (n - 1) * (i - j));
            }
        }
    }
}
