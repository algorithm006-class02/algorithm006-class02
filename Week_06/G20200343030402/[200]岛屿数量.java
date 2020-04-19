//给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设
//网格的四个边均被水包围。 
//
// 示例 1: 
//
// 输入:
//11110
//11010
//11000
//00000
//
//输出: 1
// 
//
// 示例 2: 
//
// 输入:
//11000
//11000
//00100
//00011
//
//输出: 3
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numIslands(char[][] grid) {
        if (null == grid || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        UnionFind unionFind = new UnionFind(grid);
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    if (i + 1 < m && grid[i + 1][j] == '1') {
                        unionFind.union(i * n + j, (i + 1) * n + j);
                    }
                    if (j + 1 < n && grid[i][j + 1] == '1') {
                        unionFind.union(i * n + j, i * n + j + 1);
                    }
                }
            }
        }

        return unionFind.getCount();
    }

    class UnionFind {

        private int[] parent;
        int m, n;
        int count;

        public UnionFind(char[][] grid) {
            this.m = grid.length;
            this.n = grid[0].length;
            this.parent = new int[m * n];
            this.count = 0;

            for (int r = 0; r < m; r++) {
                for (int c = 0; c < n; c++) {
                    if (grid[r][c] == '1') {
                        parent[r * n + c] = r * n + c;
                        count++;
                    }
                }
            }
        }

        public int find(int i) {
            if (parent[i] != i) {
                // 路径压缩
                parent[i] = find(parent[i]);
            }
            return parent[i];
        }

        public void union(int a, int b) {
            int parentA = find(a);
            int parentB = find(b);

            if (parentA != parentB) {
                parent[parentA] = parentB;
                count--;
            }
        }

        public int getCount() {
            return count;
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)
