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

    private static final char WATER = '0';
    private static final char ISLAND = '1';

    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == ISLAND) {
                    count++;
                    remarkIsland(i, j, grid);
                }
            }
        }
        return count;
    }

    private void remarkIsland(int i, int j, char[][] grid) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == WATER) {
            return;
        }
        grid[i][j] = WATER;
        remarkIsland(i - 1, j, grid);
        remarkIsland(i + 1, j, grid);
        remarkIsland(i, j - 1, grid);
        remarkIsland(i, j + 1, grid);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
