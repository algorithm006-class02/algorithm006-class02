import java.util.LinkedList;
import java.util.Queue;

public class LeetCode_200_378 {
    public int numIslandsI(char[][] grid) {
        if (null == grid || 0 == grid.length)
            return 0;
        int landCount = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    landCount++;
                    dfsMark(grid, i, j);
                }
            }
        }
        return landCount;
    }

    private void dfsMark(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid[0].length || j >= grid[0].length || grid[i][j] == '0')
            return;
        grid[i][j] = '0';
        dfsMark(grid, i + 1, j);
        dfsMark(grid, i - 1, j);
        dfsMark(grid, i, j + 1);
        dfsMark(grid, i, j - 1);
    }

    public int numIslands(char[][] grid) {
        if (null == grid || 0 == grid.length)
            return 0;

        int landCount = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    landCount++;
                    grid[i][j] = '0';
                    Queue<Integer> queue = new LinkedList<>();
                    queue.offer(i * cols + j);
                    while (!queue.isEmpty()) {
                        Integer poll = queue.poll();
                        int k = poll / cols;
                        int f = poll % cols;
                        if (k - 1 >= 0 && grid[k - 1][f] == '1') {
                            queue.offer((k - 1) * cols + f);
                            grid[k - 1][f] = '0';
                        }
                        if (k + 1 < rows && grid[k + 1][f] == '1') {
                            queue.offer((k + 1) * cols + f);
                            grid[k + 1][f] = '0';
                        }
                        if (f - 1 >= 0 && grid[k][f - 1] == '1') {
                            queue.offer(k * cols + (f - 1));
                            grid[k][f - 1] = '0';
                        }
                        if (f + 1 < cols && grid[k][f + 1] == '1') {
                            queue.offer(k * cols + (f + 1));
                            grid[k][f + 1] = '0';
                        }
                    }
                }
            }
        }
        return landCount;

    }






}
