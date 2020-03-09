/*
 * @lc app=leetcode.cn id=22 lang=csharp
 *
 * [22] 括号生成
 *
 * https://leetcode-cn.com/problems/generate-parentheses/description/
 *
 * algorithms
 * Medium (73.03%)
 * Likes:    775
 * Dislikes: 0
 * Total Accepted:    79K
 * Total Submissions: 107.6K
 * Testcase Example:  '3'
 *
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * 
 * 例如，给出 n = 3，生成结果为：
 * 
 * [
 * ⁠ "((()))",
 * ⁠ "(()())",
 * ⁠ "(())()",
 * ⁠ "()(())",
 * ⁠ "()()()"
 * ]
 * 
 * 
 */

// @lc code=start
public class Solution
{
    public IList<string> GenerateParenthesis(int n)
    {
        //思路，每次都有生成左括号和右括号两种选择，可以递归求解。
        //生成左括号的条件是，左括号已有数量不等于3，生成右括号条件是，右括号数量要小于左括号
        //边界条件，如果n=0返回
        var r = new List<string>();
        if (n == 0) return r;
        Helper(r, "", n, 0, 0);
        return r;
    }

    void Helper(IList<string> result, string tmp, int n, int leftcount, int rightcount)
    {
        //terminator
        if (tmp.Length == n * 2)
        {
            result.Add(tmp);
            return;
        }
        //process
        //drilldown
        if (leftcount < n)
            Helper(result, tmp + "(", n, leftcount + 1, rightcount);
        if (leftcount > rightcount)
            Helper(result, tmp + ")", n, leftcount, rightcount + 1);
    }
}
// @lc code=end

