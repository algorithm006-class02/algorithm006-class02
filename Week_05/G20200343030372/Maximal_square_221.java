package G20200343030372;

/**
 * @author Chen.C
 * @date 2020/3/11
 */
public class Maximal_square_221 {

    public int maximalSquare(char[][] matrix) {
        int x = matrix.length;
        int y = 0;
        if (x > 0) {
            y = matrix[0].length;
        }
        int[] result = new int[y + 1];
        int maxX = 0;
        int prev = 0;

        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= y; j++) {
                int temp = result[j];
                if (matrix[i - 1][j - 1] == '1') {
                    int min = Math.min(result[j - 1], prev);
                    result[j] = Math.min(min, result[j]) + 1;
                    maxX = Math.max(maxX, result[j]);
                } else {
                    result[j] = 0;
                }
                prev = temp;
            }
        }
        return maxX * maxX;
    }
}
