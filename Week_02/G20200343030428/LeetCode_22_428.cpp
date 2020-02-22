/*
 * @lc app=leetcode.cn id=22 lang=cpp
 *
 * [22] 括号生成
 */

// @lc code=start
class Solution {
private:
    vector<string> result;
public:
    void backtrack(int left, int right, int n, string s) {
        // 退出条件 => 左括号数 == 右括号数 == n
        if (left == n && right == n) {
            result.push_back(s);
        }
        // 1. 左括号小于n 递归，每次+1 保证最后一次为n 
        if (left < n) backtrack(left + 1, right, n, s + "(");
        // 2. 右括号小于n 并且 小于左括号 保证最后一次等于左括号
        if (right < left) backtrack(left, right + 1, n, s + ")");
    }
    // 入口函数
    vector<string> generateParenthesis(int n) {
        backtrack(0, 0, n, "");
        return result;
    }
};
// @lc code=end

