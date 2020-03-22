package Week_05.G20200343030414;

/**
 * @author Xinshuai
 * @description 题目链接：https://leetcode-cn.com/problems/maximal-square/
 * @since 2020-03-15 17:09
 */
public class LeetCode_221_414 {

    // 以下均参考自题解：https://leetcode-cn.com/problems/maximal-square/solution/li-jie-san-zhe-qu-zui-xiao-1-by-lzhlyle/

    /**
     * 重复子问题：从右下角开始第一个等于1的位置开始，if (matrix[i][j] == '1') {dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1}
     * 状态定义：int dp[][]
     * DP方程：if (matrix[i][j] == '1') {dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1}
     * <p>
     *     时间复杂度：O(mn)
     *     空间复杂度：0(mn)
     */
    public int maximalSquare1(char[][] matrix) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return 0;
        }
        int[][] dp = new int[matrix.length + 1][matrix[0].length + 1]; // 长宽都加1，防止数组越界
        int maxSide = 0;
        for (int i = 0; i < matrix.length; i++) { // 行
            for (int j = 0; j < matrix[0].length; j++) { // 列
                if (matrix[i][j] == '1') {
                    dp[i + 1][j + 1] = Math.min(Math.min(dp[i][j + 1], dp[i + 1][j]), dp[i][j]) + 1;
                    maxSide = Math.max(maxSide, dp[i + 1][j + 1]);
                }
            }
        }
        return maxSide * maxSide;
    }

    /**
     * 重复子问题：增加一个左上角的缓存，二维降一维，从右下角开始第一个等于1的位置开始，if (matrix[i][j] == '1') {dp[j + 1] = Math.min(Math.min(dp[j], dp[j + 1]), northwest) + 1}
     * 状态定义：int dp[]
     * DP方程：if (matrix[i][j] == '1') {dp[j + 1] = Math.min(Math.min(dp[j], dp[j + 1]), northwest) + 1}
     *
     * <p>
     *     时间复杂度：O(mn)
     *     空间复杂度：0(n)
     */
    public int maximalSquare2(char[][] matrix) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return 0;
        }
        int[] dp = new int[matrix[0].length + 1];
        int northwest; // 西北角，左上角
        int maxSide = 0;
        for (char[] chars : matrix) { // 行
            northwest = 0;
            for (int j = 0; j < matrix[0].length; j++) { // 列
                int nextNorthwest = dp[j + 1]; // 每次右一一列
                if (chars[j] == '1') {
                    dp[j + 1] = Math.min(Math.min(dp[j + 1], dp[j]), northwest) + 1;
                    maxSide = Math.max(maxSide, dp[j + 1]);
                } else {
                    dp[j + 1] = 0; // 因为开辟的是一维数组，当到下一行的时候，此位置还会被重用，故归 0
                }
                northwest = nextNorthwest;
            }
        }
        return maxSide * maxSide;
    }

}
