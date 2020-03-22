package week3;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 200. 岛屿数量
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 * <p>
 * 示例 1:
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 * 输出: 1
 * <p>
 * 示例 2:
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 * 输出: 3
 * <p>
 * https://leetcode-cn.com/problems/number-of-islands/
 */
public class IslandNumber {
    public static void test() {
//        char[][] grid = {
//                {'1', '1', '1', '1', '0'},
//                {'1', '1', '0', '1', '0'},
//                {'1', '1', '0', '0', '0'},
//                {'0', '0', '0', '0', '0'}
//        };
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        System.out.println("岛屿数量：" + new IslandNumber().numIslands2(grid));
    }

    public int numIslands(char[][] grid) {
        // 深度优先搜索DFS
        // 线性扫描整个二维网格，如果一个结点包含 1，则以其为根结点启动深度优先搜索。
        // 在深度优先搜索过程中，每个访问过的结点被标记为 0。
        // 计数启动深度优先搜索的根结点的数量，即为岛屿的数量。
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int height = grid.length;
        int width = grid[0].length;
        int count = 0;
        // 逐层搜索：从上到下，向左到右
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (grid[i][j] == '1') {
                    dfsHelper(grid, i, j);
                    ++count;
                }
            }
        }
        return count;
    }

    private void dfsHelper(char[][] grid, int i, int j) {
        int height = grid.length;
        int width = grid[0].length;
        //边界条件即是终结条件
        if (i < 0 || i >= height || j < 0 || j >= width || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        // 上下左右搜索
        dfsHelper(grid, i - 1, j);
        dfsHelper(grid, i + 1, j);
        dfsHelper(grid, i, j - 1);
        dfsHelper(grid, i, j + 1);
    }


    public int numIslands2(char[][] grid) {
        // 广度优先搜索BFS
        // 线性扫描整个二维网格，如果一个结点包含 1，则以其为根结点启动广度优先搜索。
        // 将其放入队列中，并将值设为 0 以标记访问过该结点。搜索队列中的每个结点，直到队列为空。
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int height = grid.length;
        int width = grid[0].length;
        int count = 0;
        // 逐层搜索：从上到下，从左到右
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (grid[i][j] == '1') {
                    ++count;
                    grid[i][j] = '0';
                    // 里面的元素存的是二维元素在一维数组中的位置
                    Queue<Integer> near = new LinkedList();
                    near.add(i * width + j);
                    while (!near.isEmpty()) {
                        int pos = near.remove();
                        int row = pos / width;
                        int col = pos % width;
                        // 对当前元素的上下左右进行搜索
                        if (row - 1 >= 0 && grid[row - 1][col] == '1') {
                            grid[row - 1][col] = '0';
                            near.add((row - 1) * width + col);
                        }
                        if (row + 1 < height && grid[row + 1][col] == '1') {
                            grid[row + 1][col] = '0';
                            near.add((row + 1) * width + col);
                        }
                        if (col - 1 >= 0 && grid[row][col - 1] == '1') {
                            grid[row][col - 1] = '0';
                            near.add(row * width + col - 1);
                        }
                        if (col + 1 < width && grid[row][col + 1] == '1') {
                            grid[row][col + 1] = '0';
                            near.add(row * width + col + 1);
                        }
                    }
                }
            }
        }
        return count;
    }
}
