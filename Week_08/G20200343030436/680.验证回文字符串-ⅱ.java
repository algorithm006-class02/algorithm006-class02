/*
 * @lc app=leetcode.cn id=680 lang=java
 *
 * [680] 验证回文字符串 Ⅱ
 */

// @lc code=start
class Solution {
    //对于给定字符串中的每个索 i，让我们删除该字符，然后检查结果字符串是否是回文。
    //如果是（或者原始字符串是回文），那么我们将返回 true。
    //回文串 就是串 从前向后 和从后向前 的 比对到中间撞见之前 是相等的  
    // 题目是这可以删一次 如何还是就是回文串 那么就是要么从前面删一次 要么从后面删一次 去枚举遍历去判断就行了

    public boolean validPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if(s.charAt(i) != s.charAt(j)) {
                //分两种情况，一是右边减一，二是左边加一
                return isPalindrome(s, i, j - 1) || isPalindrome(s, i + 1, j);
            }
        }
        return true;
    }

    public boolean isPalindrome(String s,int i,int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

