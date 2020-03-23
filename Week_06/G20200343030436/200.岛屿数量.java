/*
 * @lc app=leetcode.cn id=200 lang=java
 *
 * [200] 岛屿数量
 */

// @lc code=start
class Solution {
    // public int numIslands(char[][] grid) {
    //     if (grid == null || grid.length == 0) {
    //         return 0;
    //     }
    //     int nr = grid.length;
    //     int nc = grid[0].length;
    //     int num_island = 0;
    //     for (int r = 0; r < nr; ++r) {
    //         for (int c = 0; c < nc; ++c) {
    //             if (grid[r][c] == '1') {
    //                 ++num_island;
    //                 dfs(grid, r, c);//下沉 去找它的上下左右是否有1 有1炸！
    //             }
    //         }
    //     }
    //     return num_island;
    // }

    // private void dfs(char[][] grid, int r, int c) {
    //     int nr = grid.length;
    //     int nc = grid[0].length;
    //     if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
    //         return;
    //     }
    //     grid[r][c] = '0';
    //     dfs(grid, r - 1, c);
    //     dfs(grid, r + 1, c);
    //     dfs(grid, r, c - 1);
    //     dfs(grid, r, c + 1);
    // }
    

    public int numIslands2(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int nr = grid.length;
        int nc = grid[0].length;
        int num_islands = 0;
        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == '1') {
                    ++num_islands;
                    grid[r][c] = '0';
                    Queue<Integer> queue = new LinkedList<>();
                    queue.add(r * nc + c);
                    while (!queue.isEmpty()) {
                        int id = queue.remove();
                        int row = id / nc;
                        int col = id % nc;
                        if (row - 1 >= 0 && grid[row - 1][col] == '1') {
                            queue.add((row - 1) * nc + col);
                            grid[row - 1][col] = '0';
                        }
                        if (row + 1 < nr && grid[row + 1][col] == '1') {
                            queue.add((row + 1) * nc + col);
                            grid[row + 1][col] = '0';
                        }
                        if (col - 1 >= 0 && grid[row][col - 1] == '1') {
                            queue.add((row) * nc + col - 1);
                            grid[row][col - 1] = '0';
                        }
                        if (col + 1 < nc && grid[row][col + 1] == '1') {
                            queue.add((row) * nc + col + 1);
                            grid[row][col + 1] = '0';
                        }
                    }
                }
            }
        }
        return num_islands;
    }

    class UnionFind {
        int count;
        int[] parent;
        int[] rank;

        public UnionFind(char[][] grid) {
            count = 0;
            int m = grid.length;
            int n = grid[0].length;
            parent = new int[m * n];
            rank = new int[m * n];
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (grid[i][j] == '1') {
                        parent[i * n + j] = i * n + j;
                        ++count;
                    }
                    rank[i * n + j] = 0;
                }
            }
        }

        public int find(int i) {
            if (parent[i] != i) {
                parent[i] =  find(parent[i]);
            }
            return parent[i];
        }

        public void union(int x, int y){
            int rootx = find(x);
            int rooty = find(y);
            if (rootx != rooty) {
                if (rank[rootx] > rank[rooty]) {
                    parent[rooty] = rootx;
                } else if (rank[x] < rank[rooty]) {
                    parent[rootx] =  rooty;
                } else {
                    parent[rooty] = rootx;
                    rank[rootx] += 1;
                }
                --count;
            }
        }

        public int getCount() {
            return count;
        }
    }


    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int nr = grid.length;
        int nc = grid[0].length;
        // int num_island = 0;
        UnionFind uf = new UnionFind(grid);
        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == '1') {
                    grid[r][c] = '0';
                    if (r - 1 >= 0 && grid[r - 1][c] == '1') {
                        uf.union(r * nc + c, (r - 1) * nc + c);
                    }
                    if (r + 1 < nr && grid[r + 1][c] == '1') {
                        uf.union(r * nc + c, (r + 1) * nc + c);
                    }
                    if (c - 1 >= 0 && grid[r][c - 1] == '1') {
                        uf.union(r * nc + c, r * nc + c - 1);
                    }
                    if (c + 1< nc && grid[r][c + 1] == '1') {
                        uf.union(r * nc + c, r * nc + c + 1);
                    }
                }
            }
        }
        return uf.getCount();
    }
}
// @lc code=end

