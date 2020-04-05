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

    //用一个 dp 数组， dp [ i ] 代表字符串 s [ i, s.len-1 ]，也就是 s 从 i 开始到结尾的字符串的解码方式。
    //如果 s [ i ] 和 s [ i + 1 ] 组成的数字小于等于 26，那么
    //dp [ i ] = dp[ i + 1 ] + dp [ i + 2 ]
    public int numDecodings3(String s) {
        int len = s.length();
        int[] dp = new int[len + 1];
        dp[len] = 1;////将递归法的结束条件初始化为 1 
        
        if (s.charAt(len - 1) != '0') {//最后一个数字不等于 0 就初始化为 1
            dp[len - 1] = 1;
        }
        for (int i = len - 2; i >= 0; i--) {
            ///当前数字时 0 ，直接跳过，0 不代表任何字母
            if (s.charAt(i) == '0') {
                continue;
            }
            int ans1 = dp[i + 1];
            // //判断两个字母组成的数字是否小于等于 26
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

    // Your runtime beats 100 % of java submissions
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

