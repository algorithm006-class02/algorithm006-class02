package com.example.leetCode.week5;


public class LeetCode_647_386 {
//给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
//
// 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。
//
// 示例 1:
//
//
//输入: "abc"
//输出: 3
//解释: 三个回文子串: "a", "b", "c".
//
//
// 示例 2:
//
//
//输入: "aaa"
//输出: 6
//说明: 6个回文子串: "a", "a", "a", "aa", "aa", "aaa".
//
//
// 注意:
//
//
// 输入的字符串长度不会超过1000。
//
// Related Topics 字符串 动态规划

    public int countSubstrings(String s) {
        // 最小子结构：1、如果两个点相邻且相同，则为互文；2、若不相邻，则首尾两端相同，且中间区域是回文的话，则当前结构为回文
        // 状态存储结构：boolean[m][n] dp 存储m ~ n组成的字符串是否是回文
        // 转移方程（本应看右上方，但是为了程序方便，写程序时改为左下方部分）：
        //          dp[i][j] = dp[i-1][j+1] && s.charAt(i) == s.charAt(j)

        if (s == null || s.length() == 0) {
            return 0;
        }
        int size = s.length();
        int count = 0;
        boolean[][] dp = new boolean[size][size];
        for (int i = 0; i < size; i++) {
            dp[i][i] = true;
            count++;
        }
        for (int i = 1; i < size; i++) {
            for (int j = 0; j < i; j++) {
                if (j + 1 == i) {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = true;
                        count++;
                    }
                } else {
                    if (dp[i - 1][j + 1] && s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = true;
                        count++;
                    }
                }
            }
        }
        return count;
    }

}
