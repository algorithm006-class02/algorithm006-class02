class Solution {
    class UnionFind {
        private int count = 0;
        private int[] parent;

        public UnionFind(char[][] grid) {
            int n = grid.length;
            int m = grid[0].length;
            count = 0;
            parent = new int[m * n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    int num = i * m + j;
                    parent[num] = num;
                    if (grid[i][j] == '1') {
                        count++;
                    }
                }
            }
        }

        public int find(int p) {
            int pa = p;
            while (pa != parent[pa]) {
                parent[pa] = parent[parent[pa]];
                pa = parent[pa];
            }
            parent[p] = pa;
            return pa;
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) {
                return;
            }
            parent[rootP] = rootQ;
            count--;
        }
    }

    public int numIslands(char[][] grid) {
        int n = grid.length;
        if (n == 0) {
            return 0;
        }
        int m = grid[0].length;
        boolean[][] pass = new boolean[n][m];
        UnionFind uf = new UnionFind(grid);
        unid(grid, 0, 0, n, m, uf, pass);
        return uf.count;
    }

    private void unid(char[][] grid, int i, int j, int n, int m, UnionFind uf, boolean[][] pass) {
        if (pass[i][j] == true) {
            return;
        } else {
            pass[i][j] = true;
        }
        if (i < n - 1) {
            if (grid[i][j] == '1' && grid[i + 1][j] == '1') {
                uf.union(i * m + j, (i + 1) * m + j);
            }
            unid(grid, i + 1, j, n, m, uf, pass);

        }
        if (j < m - 1) {
            if (grid[i][j] == '1' && grid[i][j + 1] == '1') {
                uf.union(i * m + j, i * m + j + 1);
            }
            unid(grid, i, j + 1, n, m, uf, pass);
        }
    }
}
