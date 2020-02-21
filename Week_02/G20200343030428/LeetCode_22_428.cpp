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
    void _generate(int left, int right, int n, string s) {
        if (left == n && right == n) {
            result.push_back(s);
        }
        if (left < n) _generate(left + 1, right, n, s + "(");
        if (right < left) _generate(left, right + 1, n, s + ")");
    }
    vector<string> generateParenthesis(int n) {
        _generate(0, 0, n, "");
        return result;
    }
};
// @lc code=end

