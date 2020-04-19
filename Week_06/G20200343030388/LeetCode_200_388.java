
public class LeetCode_200_388 {

    private int[] union;
    int count = 0;

    LeetCode_200_388(char[][] grid) {
        int len1 = grid.length, len2 = grid[0].length;
        union = new int[len1 * len2];

        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if (grid[i][j] == '1') {
                    int index = i * len2 + j;
                    union[index] = index;
                    count++;
                }
            }
        }
    }


    private int find(int index) {
        if (union[index] == index) {
            return index;
        }
        int end = find(union[index]);
        while (union[index] != end) {
            int temp = index;
            index = union[index];
            union[temp] = end;
        }
        return end;
    }


    private void union(int index1, int index2) {
        int end1 = find(index1);
        int end2 = find(index2);
        if (end1 != end2) {
            union[end2] = end1;
            count--;
        }
    }


    private int[] moveX = {-1, 1, 0, 0},
            moveY = {0, 0, -1, 1};

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length < 1) {
            return 0;
        }
        LeetCode_200_388 union = new LeetCode_200_388(grid);
        int len1 = grid.length;
        for (int i = 0; i < len1; i++) {
            int len2 = grid[0].length;
            for (int j = 0; j < len2; j++) {
                if (grid[i][j] == '1') {
                    for (int k = 0; k < moveX.length; k++) {
                        int x = i + moveX[k], y = j + moveY[k];
                        if (isValid(grid, len1, len2, x, y)) {
                            union.union(i * len2 + j, x * len2 + y);
                        }
                    }
                }
            }
        }
        return union.count;
    }


    private boolean isValid(char[][] grid, int len1, int len2, int x, int y) {
        return x >= 0 && x < len1 && y >= 0 && y < len2 && grid[x][y] == '1';
    }
}
