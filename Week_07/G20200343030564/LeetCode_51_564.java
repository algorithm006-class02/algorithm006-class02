package week03.pratice;

import java.util.ArrayList;
import java.util.List;

/**
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 *
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *
 * 示例:
 *
 * 输入: 4
 * 输出: [
 *  [".Q..",  // 解法 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // 解法 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 * 解释: 4 皇后问题存在两个不同的解法。
 *
 */
public class LeetCode_51_564 {

    public List<List<String>> out = new ArrayList<List<String>>();

    public static void main(String[] args) {
        LeetCode_51_564 leetCode = new LeetCode_51_564();
        List<List<String>> out = leetCode.solveNQueens(8);
        System.out.println(out);
    }


    /**
     * 递归求解
     * @param n
     * @return
     */
    public List<List<String>> solveNQueens(int n) {

        // 初始化数组，n是行数
        int[] result = new int[n];

        callNQueens(0, result, n);

        return out;
    }

    /**
     * 打印
     * @param result
     * @param n
     */
    private void printRes(int[] result, int n) {
        List<String> temp = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < n; row++) {
            for (int column = 0; column < n; column++) {
                if (result[row] == column) sb.append("Q");
                else sb.append(".");
            }
            sb.append(",");
        }
        temp.add(sb.toString());
        out.add(temp);
    }

    /**
     * 递归调用
     * @param row
     * @param result
     */
    private void callNQueens(int row, int[] result, int n) {
        // terminator 如果行数等于了传入的行数，退出
        if (row == n) {
            // 按照行和列放入集合中
            printRes(result, n);
            return;
        }

        // process cuerrent login 从第一列开始遍历到最后一列
        for (int column = 0 ; column < n; column++) {
            if (isOk(row, column, result, n)) {
                result[row] = column;
                // drill down
                callNQueens(row + 1, result, n);
            }
        }
    }

    /**
     * 判断这行这列能不能放下皇后
     * @param row
     * @param column
     * @return
     */
    private boolean isOk(int row, int column, int[] result, int n) {
        // 计算当前列左右边界
        int left = column - 1; int right = column + 1;
        // 判断上一行
        for (int i = row - 1; i >= 0; i--) {
            // 如果上一行存的列值和这行的列值一样，退出循环
            if (result[i] == column) return false;
            // 左边大于0且这行的左上方已经有值，退出循环
            if (left >= 0) if (result[i] == left) return false;
            // 右边小于n且这行的右上方已经有值，退出循环
            if (right < n) if (result[i] == right) return false;

            left--;right++;
        }
        return true;
    }
}
