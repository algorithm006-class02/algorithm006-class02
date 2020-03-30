package Week_07.G20200343030414;

import java.util.*;

/**
 * @author Xinshuai
 * @description 题目链接：https://leetcode-cn.com/problems/n-queens/
 * @since 2020-03-29 15:45
 */
public class LeetCode_51_414 {

    /**
     * 回溯 + 剪枝（哈希表）
     */
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i;
        }
        Set<Integer> col = new HashSet<>(); // 行（用于占位）
        Set<Integer> master = new HashSet<>(); // 主对角线（用于占位）
        Set<Integer> slave = new HashSet<>(); // 副对角线（用于占位）
        Stack<Integer> stack = new Stack<>(); // 存放元素的横坐标位置
        backtrack(nums, 0, n, col, master, slave, stack, res);
        return res;
    }

    private void backtrack(int[] nums, int row, int n,
                           Set<Integer> col,
                           Set<Integer> master,
                           Set<Integer> slave,
                           Stack<Integer> stack,
                           List<List<String>> res) {

        if (row == n) {
            List<String> board = convertBoard1(stack, n);
            res.add(board);
            return;
        }
        // 针对每一列，尝试是否可以放置
        for (int i = 0; i < n; i++) {
            // 剪枝
            if (!col.contains(i) && !master.contains(row + i) && !slave.contains(row - i)) {
                stack.add(nums[i]);
                col.add(i);
                master.add(row + i);
                slave.add(row - i);
                backtrack(nums, row + 1, n, col, master, slave, stack, res);
                slave.remove(row - i);
                master.remove(row + i);
                col.remove(i);
                stack.pop();
            }
        }
    }

    private List<String> convertBoard1(Stack<Integer> stack, int n) {
        List<String> board = new ArrayList<>();
        for (Integer num : stack) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < n; i++) {
                stringBuilder.append(".");
            }
            stringBuilder.replace(num, num + 1, "Q");
            board.add(stringBuilder.toString());
        }
        return board;
    }

    /**
     * 回溯 + 剪枝（位运算）
     */
    public List<List<String>> solveNQueens2(int n) {
        List<List<String>> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i;
        }
        int col = 0;
        int master = 0;
        int slave = 0;
        Stack<Integer> stack = new Stack<>();
        backtrack(nums, 0, n, col, master, slave, stack, res);
        return res;
    }

    private void backtrack(int[] nums, int row, int n,
                           int col,
                           int master,
                           int slave,
                           Stack<Integer> stack,
                           List<List<String>> res) {

        if (row == n) {
            List<String> board = convertBoard2(stack, n);
            res.add(board);
            return;
        }
        // 针对每一列，尝试是否可以放置
        for (int i = 0; i < n; i++) {
            if (((col >> i) & 1) == 0 && ((master >> (row + i)) & 1) == 0 && ((slave >> (row - i + n - 1)) & 1) == 0) {
                stack.add(nums[i]);
                col ^= (1 << i);
                master ^= (1 << (row + i));
                slave ^= (1 << (row - i + n - 1));
                backtrack(nums, row + 1, n, col, master, slave, stack, res);
                slave ^= (1 << (row - i + n - 1));
                master ^= (1 << (row + i));
                col ^= (1 << i);
                stack.pop();
            }
        }
    }

    private List<String> convertBoard2(Stack<Integer> stack, int n) {
        List<String> board = new ArrayList<>();
        for (Integer num : stack) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < n; i++) {
                stringBuilder.append(".");
            }
            stringBuilder.replace(num, num + 1, "Q");
            board.add(stringBuilder.toString());
        }
        return board;
    }

}
