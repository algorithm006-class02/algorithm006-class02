/**
 * @author : Hyuk
 * @description : LeetCode_200_536
 * @date : 2020/3/22 6:41 下午
 */
public class LeetCode_200_536 {

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;
        int[] parent = init(m * n);
        boolean[] isLand = new boolean[m * n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == '1') {
                    isLand[i * n + j] = true;
                    if (i - 1 >= 0 && grid[i - 1][j] == '1') {
                        union(parent, i * n + j, (i - 1) * n + j);
                    }
                    if (i + 1 < m && grid[i + 1][j] == '1') {
                        union(parent, i * n + j, (i + 1) * n + j);
                    }
                    if (j - 1 >= 0 && grid[i][j - 1] == '1') {
                        union(parent, i * n + j, i * n + j - 1);
                    }
                    if (j + 1 < n && grid[i][j + 1] == '1') {
                        union(parent, i * n + j, i * n + j + 1);
                    }
                }
            }
        }

        int res = 0;
        for (int i = 0; i < n * m; ++i) {
            if (parent[i] == i && isLand[i]) {
                res++;
            }
        }
        return res;
    }

    private int[] init(int n) {
        int[] parent = new int[n];
        for (int i = 0; i < n; ++i) {
            parent[i] = i;
        }
        return parent;
    }

    private int find(int[] parent, int i) {
        if (parent[i] == i) { return i; }
        return find(parent, parent[i]);
    }

    private void union(int[] parent, int x, int y) {
        int parentX = find(parent, x);
        int parentY = find(parent, y);
        parent[parentX] = parentY;
    }

    public static void main(String[] args) {
        char[][] grid = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        System.out.println(new LeetCode_200_536().numIslands(grid));
    }

}
