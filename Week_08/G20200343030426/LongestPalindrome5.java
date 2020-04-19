package com.ping.leetcode.medium;

/**
 * @Author: 高一平
 * @Date: 2020/4/5
 * @Description: 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * 输入: "cbbd"
 * 输出: "bb"
 **/
public class LongestPalindrome5 {

    /**
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        return longestPalindrome4(s);
    }

    /**
     * 中心扩展算法
     * 回文中心的两侧互为镜像。因此，回文可以从它的中心展开，并且只有 2n-1 个这样的中心
     * 中心可能为某个字母，也可能为两个字母中间
     * 即回文字符串的长度，可能为偶数，也可能为奇数
     *
     * @param s
     * @return
     */
    private String longestPalindrome4(String s) {
        if (s == null || s.length() < 1) {
            return "";
        } else {
            int start = 0, end = 0;
            for (int i = 0; i < s.length(); i++) {
                // 指定字符串中某一字符为回文串中心
                int length1 = expandAroundCenter(s, i, i);
                // 指定字符串中某两字符中心为回文串中心
                int length2 = expandAroundCenter(s, i, i + 1);
                int length = Math.max(length1, length2);
                // 判断回文串长度是否比已知的大
                if (length > end - start) {
                    start = i - (length - 1) / 2;
                    end = i + length / 2;
                }
            }
            return s.substring(start, end + 1);
        }
    }

    /**
     * 获取指定位置的回文串最大长度
     * 当 left == right 时，指定字符串中某一字符为回文串中心
     * 当 left != right 时，指定字符串中某两字符中心为回文串中心
     *
     * @param s     原字符串
     * @param left  指定位置的左边索引
     * @param right 指定位置的右边索引
     * @return
     */
    private int expandAroundCenter(String s, int left, int right) {
        int l = left, r = right;
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return r - l - 1;
    }

}
