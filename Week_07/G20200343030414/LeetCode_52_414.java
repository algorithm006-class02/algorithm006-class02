package Week_07.G20200343030414;

/**
 * @author Xinshuai
 * @description 题目链接：https://leetcode-cn.com/problems/n-queens-ii/
 * @since 2020-03-29 16:50
 */
public class LeetCode_52_414 {

    /**
     * DFS + 位运算剪枝
     */
    int count = 0;
    public int totalNQueens(int n) {
        dfs(0, 0, 0, 0, n); // 从0开始遍历就行了，dfs会自动遍历所有可能方案
        return count;
    }

    private void dfs(int row, int col, int pie, int na, int n) {
        if (row >= n) {
            count++;
        }
        // 获取所有可以放置皇后的位置，并用1标志
        int bits = (~(col | pie | na)) & ((1 << n) - 1);
        while (bits != 0) {
            int tryBit = bits & -bits; // 代表除最后一位1保留，其它位全部为0
            dfs(row + 1, col | tryBit,(pie | tryBit) >> 1, (na | tryBit) << 1, n); // 把刚刚拿的最后位置放置皇后
            bits &= bits - 1; // 代表将最后一位1变成0（既然已经防止皇后了，就把位置占上）
        }
    }

}
