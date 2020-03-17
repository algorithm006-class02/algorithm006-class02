class Solution {
    //并查集的解法，非并查集的解法放在了笔记里。
    class UnionFind {
        private int[] parent;

        public UnionFind(char[][] grid) {
            int n = grid.length;
            int m = grid[0].length;
            parent = new int[n * m];
            for (int i = 0; i < n * m; i++) {
                parent[i] = i;
            }
        }

        public int find(int i, int j, int m) {
            int p = i * m + j;
            int pa = p;
            while (pa != parent[pa]) {
                parent[pa] = parent[parent[pa]];
                pa = parent[pa];
            }
            parent[p] = pa;
            return pa;
        }

        public void union(int i1, int j1, int i2, int j2, int n, int m) {
            int root1 = find(i1, j1, m);
            int root2 = find(i2, j2, m);
            if (root1 == root2) {
                return;
            }
            if (isBoarder(root1, n, m)) {
                parent[root2] = root1;
            } else {
                parent[root1] = root2;
            }
        }
    }

    public void solve(char[][] board) {
        int n = board.length;
        if (n == 0) {
            return;
        }
        int m = board[0].length;
        UnionFind uf = new UnionFind(board);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                unid(board, i, j, n, m, uf);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O') {
                    int pa = uf.find(i, j, m);
                    if (isBoarder(pa, n, m) == false) {
                        board[i][j] = 'X';
                    }
                }
            }
        }
    }

    private static boolean isBoarder(int i, int n, int m) {
        if (i >= 0 && i < m) {
            return true;
        }
        if (i >= (n - 1) * m && i < m * n) {
            return true;
        }
        for (int j = 1; j < n - 1; j++) {
            if (i == j * m || i == (j + 1) * m - 1) {
                return true;
            }
        }
        return false;
    }

    private void unid(char[][] grid, int i, int j, int n, int m, UnionFind uf) {
        if (j < m - 1) {
            if (grid[i][j] == 'O' && grid[i][j + 1] == 'O') {
                uf.union(i, j, i, j + 1, n, m);
            }
        }
        if (i < n - 1) {
            if (grid[i][j] == 'O' && grid[i + 1][j] == 'O') {
                uf.union(i, j, i + 1, j, n, m);
            }
        }
    }
}
