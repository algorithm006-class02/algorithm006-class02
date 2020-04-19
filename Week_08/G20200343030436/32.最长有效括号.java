/*
 * @lc app=leetcode.cn id=32 lang=java
 *
 * [32] 最长有效括号
 */

// @lc code=start
class Solution {
    public int longestValidParentheses1(String s) {
        int maxlen = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 2; j <= s.length(); j += 2) {
                if (isValid(s.substring(i, j))) {
                    maxlen = Math.max(maxlen, j - i);
                }
            }
        }
        return maxlen;
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push('(');
            } else if (!stack.empty() && stack.peek() == '(') {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.empty();
    }

    //dp[i] 表示 小标为i字符结尾的最长有效字符串的长度
    // if s[i] == ')'
    //1 s[i - 1] == '('，也就是字符串形如 “……()”，我们可以推出：
    // dp[i] = dp[i − 2] + 2。

    //2 s[i - 1] == ')'，也就是字符串形如 “.......))”
    // if s[i - dp[i - 1] - 1] == '('， 也就是 除了后面的两个 右括号之外 的位置 某一处有 2个 左括号
    // dp[i] = dp[i − 1] + dp[i − dp[i − 1] − 2] + 2
    // 因为如果倒数第二个 )是一个有效子字符串的一部分（记为subs）
    // 需要判断 subs 前面一个符号是不是 ( ，如果恰好是(，我们就用 subs 的长度(dp[i - 1)加上 2 去更新 dp[i]
    // 也会把子字符串 subs 前面的有效字符串的长度加上，也就是 dp[i − dp[i − 1] − 2].
    public int longestValidParentheses2(String s) {
        int maxlen = 0;
        int dp[] = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = ((i > 2) ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] +
                            (
                                    (i - dp[i - 1]) >= 2
                                            ?
                                            dp[i - dp[i - 1] - 2] : 0
                            )
                            + 2;
                }
                maxlen = Math.max(maxlen, dp[i]);
            }
        }
        return maxlen;
    }

    public int longestValidParentheses(String s) {
        int maxlen = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    maxlen = Math.max(maxlen, i - stack.peek());
                }
            }
        }
        return maxlen;
    }

}
// @lc code=end

