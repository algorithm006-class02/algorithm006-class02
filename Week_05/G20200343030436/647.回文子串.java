/*
 * @lc app=leetcode.cn id=647 lang=java
 *
 * [647] 回文子串
 */

// @lc code=start
class Solution {
    public int countSubstrings1(String s) {
        int retCount = 0;
        int start, end;
        for (start = 0; start < s.length(); start++) {
            for (end = start; end < s.length(); end++) {
                if (isPalindrome(s, start, end)) {
                    retCount++;
                }
            }
        }
        return retCount;
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public int countSubstrings2(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res += countSegment(s, i, i);
            res += countSegment(s, i, i + 1);
        }
        return res;
    }

    public int countSegment(String s, int start, int end) {
        int count = 0;
        while (start >= 0 && end < s.length() && s.charAt(start--) == s.charAt(end++)) {
            count++;
        }
        return count;
    }

    public int countSubstrings(String s) {
        int result = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];

        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (i == j) {
                    dp[i][j] = true;
                } else {
                    dp[i][j] = s.charAt(i) == s.charAt(j) && (j <= i + 1 || dp[i + 1][j - 1]);
                }
                if (dp[i][j]) {
                    result++;
                }
            }
        }
        return result;
    }
}
// @lc code=end

