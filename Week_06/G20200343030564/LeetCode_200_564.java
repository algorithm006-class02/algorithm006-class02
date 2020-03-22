package week06;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 岛屿数量
 *
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方
 * 向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 *
 * 示例 1:
 *
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * 输出: 1
 * 示例 2:
 *
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * 输出: 3
 */
public class LeetCode_200_564 {
    public static void main(String[] args) {
        LeetCode_200_564 leetCode = new LeetCode_200_564();
//        System.out.println(leetCode.numIslands(new char[][]{
//                {'1', '1', '1', '1', '0'},
//                {'1', '1', '0', '1', '0'},
//                {'1', '1', '0', '0', '0'},
//                {'0', '0', '0', '0', '0'}
//        }));
//
//        System.out.println(leetCode.numIslands1(new char[][]{
//                {'1', '1', '1', '1', '0'},
//                {'1', '1', '0', '1', '0'},
//                {'1', '1', '0', '0', '0'},
//                {'0', '0', '0', '0', '0'}
//        }));

        System.out.println(leetCode.numIslands2(new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        }));
    }

    /**
     * 深度优先
     * 时间复杂度：O(M×N)，其中 M 和 N 分别为行数和列数。
     * 空间复杂度：O(M×N)，深度优先搜索的深度达到 M×N。
     *
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid == null) return 0;

        int out = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    out++;
                    dfs(grid, i, j);
                }
            }
        }
        return out;
    }

    private void dfs(char[][] grid, int i, int j) {
        // terminator
        if (i < 0 || j < 0 || grid[i][j] == '0') return;

        // process current logic
        grid[i][j] = '0';

        // 上下左右进行递归
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }

    /**
     * 广度优先
     * 时间复杂度：O(M×N)，其中 M 和 N 分别为行数和列数。
     * 空间复杂度：O(min(M, N))
     *
     * @param grid
     * @return
     */
    public int numIslands1(char[][] grid) {
        if (grid == null || grid[0].length == 0) return 0;

        int nr = grid.length;
        int nc = grid[0].length;
        int num_islands = 0;

        for (int r = 0; r < nr; r++) {
            for (int c = 0; c < nc; c++) {
                if (grid[r][c] == '1') {
                    // 岛屿数加一且设置1为0
                    num_islands++;
                    grid[r][c] = '0';

                    Queue<Integer> queue = new LinkedList<>();
                    // 投影
                    queue.add(r * nc + c);
                    while (!queue.isEmpty()) {
                        Integer id = queue.poll();
                        int row = id / nc;
                        int column = id % nc;
                        // 上下左右都计算
                        if (row - 1 > 0 && grid[row - 1][column] == '1') {
                            queue.add((row - 1) * nc + c);
                            grid[row - 1][column] = '0';
                        }
                        if (row + 1 < nr && grid[row + 1][column] == '1') {
                            queue.add((row + 1) * nc + c);
                            grid[row + 1][column] = '0';
                        }
                        if (column - 1 > 0 && grid[row][column - 1] == '1') {
                            queue.add(row * nc + (column - 1));
                            grid[row][column - 1] = '0';
                        }
                        if (column + 1 < nc && grid[row][column + 1] == '1') {
                            queue.add(row * nc + (column + 1));
                            grid[row][column + 1] = '0';
                        }
                    }
                }
            }
        }
        return num_islands;
    }

    /**
     * 并查集
     * 时间复杂度：
     * 空间复杂度：
     *
     * @param grid
     * @return
     */
    public int numIslands2(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        // 1.构建并查集
        // 2.找到为1的位置，换成0，然后合并上下左右为1的数据
        // 3.合并的时候调用并查集的查找方法[并查集里面存的是父节点]，然后再合并父节点
        // 当rank大的当父节点，当rank相同的时候随便选一个当父节点，但是rank要加1

        UnionFind uf = new UnionFind(grid);
        int nr = grid.length;
        int nc = grid[0].length;
        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                if (grid[i][j] == '1') {
                    grid[i][j] = '0';
                    if (i - 1 >= 0 && grid[i - 1][j] == '1') {
                        uf.union(i * nc + j, (i - 1) * nc + j);
                    }
                    if (i + 1 < nr && grid[i + 1][j] == '1') {
                        uf.union(i * nc + j, (i + 1) * nc + j);
                    }
                    if (j - 1 >= 0 && grid[i][j - 1] == '1') {
                        uf.union(i * nc + j, i * nc + j - 1);
                    }
                    if (j + 1 < nc && grid[i][j + 1] == '1') {
                        uf.union(i * nc + j, i * nc + j + 1);
                    }
                }
            }
        }
        return uf.getCount();
    }
}

class UnionFind {
    int count;

    int[] parent;

    int[] rank;

    public UnionFind(char[][] grid) { // for problem 200
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

    public int findParent(int i){
        // 这一步是把父类放在当下，方便下次快速查询
        if (parent[i] != i) parent[i] = findParent(parent[i]);
        return parent[i];
    }

    public void union(int x, int y){
        int rootX = findParent(x);
        int rootY = findParent(y);
        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else if (rank[rootY] > rank[rootX]) {
                parent[rootX] = rootY;
            } else {
                parent[rootX] = rootY;
                rank[rootY]++;
            }
            count--;
        }
    }


    public int getCount(){
        return this.count;
    }
}