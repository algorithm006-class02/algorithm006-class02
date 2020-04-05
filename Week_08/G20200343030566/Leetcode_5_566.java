package com.sebar.test.leetcode.eight.pratice;

/**
 * @Author LG-QCY
 * @Date :2020/4/5 17:47
 */
public class Leetcode_5_566 {
    public String longestPalindrome(String s) {
        if (s.isEmpty()) {
            return s;
        }
        String reverse = new StringBuilder(s).reverse().toString();
        int len = s.length();
        int[][] arr = new int[len][len];
        int maxLen = 0;
        int maxEnd = 0;

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (s.charAt(i) == reverse.charAt(j)) {
                    if (i == 0 || j == 0) {
                        arr[i][j] = 1;
                    } else {
                        arr[i][j] = arr[i - 1][j - 1] + 1;
                    }
                }
                if (arr[i][j] > maxLen) {
                    int before = len - 1 - j;
                    if (before + arr[i][j] - 1 == i) {
                        maxLen = arr[i][j];
                        maxEnd = i;
                    }
                }
            }
        }
        return s.substring(maxEnd - maxLen + 1, maxEnd + 1);
    }
}
