package com.sebar.test.leetcode.two.practice.tree;

import java.util.ArrayList;
import java.util.List;

public class Leetcode_22_566 {
    List<String> resList = new ArrayList<>();

    /**
     * 递归生成括号
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        generate(0, 0, 3, "");
        return resList;
    }

    /**
     * 生成括号
     *
     * @param left  左括号
     * @param right 右括号
     * @param s     拼接结果
     */
    private void generate(int left, int right, int n, String s) {
        // terminator
        if (left == n && right == n) {
            resList.add(s);
            return;
        }
        // process  logic
        // 左括号的使用量小于总数就可以使用左括号
        if (left < n) {
            generate(left + 1, right, n, s + "(");
        }
        // 右括号的使用数量小于左括号就可以使用左括号
        if (left > right) {
            generate(left, right + 1, n, s + ")");
        }
        // drill down

        // return
    }
}
