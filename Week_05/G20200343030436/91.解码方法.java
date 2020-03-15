import sun.security.krb5.internal.crypto.crc32;

/*
 * @lc app=leetcode.cn id=91 lang=java
 *
 * [91] 解码方法
 */

// @lc code=start
class Solution {
    //Your runtime beats 5 % of java submissions
   // Your memory usage beats 5.01 % of java submissions (38.1 MB)
    public int numDecodings1(String s) {
        return getAns(s, 0);
    }

    private int getAns(String s, int start) {
        if (start == s.length()) {
            return 1;
        }
        if (s.charAt(start) == '0') {
            return 0;
        }
        int ans1 = getAns(s, start + 1);
        int ans2 = 0;
        if (start < s.length() - 1) {
            int ten = (s.charAt(start) - '0') * 10;
            int one = s.charAt(start + 1) - '0';
            if ((ten + one) <= 26) {
                ans2 = getAns(s, start + 2);
            }
        }
        return ans1 + ans2;
    }

//     Your runtime beats 53.45 % of java submissions
// Your memory usage beats 5.01 % of java submissions (37.9 MB)
    public int numDecodings2(String s) {
        HashMap<Integer, Integer> memoMap = new HashMap<>();
        return getAns(s, 0, memoMap);
    }

    private int getAns(String s, int start, HashMap<Integer, Integer> memo) {
        if (start == s.length()) {
            return 1;
        }
        if (s.charAt(start) == '0') {
            return 0;
        }
        int m = memo.getOrDefault(start, -1);
        if (m != -1) {
            return m;
        }
        int ans1 = getAns(s, start + 1, memo);
        int ans2 = 0;
        if (start < s.length() - 1) {
            int ten = (s.charAt(start) - '0') * 10;
            int one = s.charAt(start + 1) - '0';
            if (ten + one <= 26) {
                ans2 = getAns(s, start + 2, memo);
            }
        }
        memo.put(start, ans1 + ans2);
        return ans1 + ans2;
    }

    public int numDecodings3(String s) {
        int len = s.length();
        int[] dp = new int[len + 1];
        dp[len] = 1;
        if (s.charAt(len - 1) != '0') {
            dp[len - 1] = 1;
        }
        for (int i = len - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                continue;
            }
            int ans1 = dp[i + 1];
            int ans2 = 0;
            int ten = (s.charAt(i) - '0') * 10;
            int one = s.charAt(i + 1) - '0';
            if (ten + one <= 26) {
                ans2 = dp[i + 2];
            }
            dp[i] = ans1 + ans2;
        }
        return dp[0];
    }

//     Your runtime beats 100 % of java submissions
// Your memory usage beats 5.01 % of java submissions (37.7 MB)
    public int numDecodings(String s) {
        int len = s.length();
        int end = 1;
        int curr = 0;
        if (s.charAt(len - 1) != '0') {
            curr = 1;
        }
        for (int i = len - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                end = curr;
                curr = 0;
                continue;
            }
            int ans1 = curr;
            int ans2 = 0;
            int ten = (s.charAt(i) - '0') * 10;
            int one = s.charAt(i + 1) - '0';
            if (ten + one <= 26) {
                ans2 = end;
            }
            end = curr;
            curr = ans1 + ans2;
        }
        return curr;
    }
}
// @lc code=end

