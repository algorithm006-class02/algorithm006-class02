/*
 * @lc app=leetcode.cn id=20 lang=csharp
 *
 * [20] 有效的括号
 *
 * https://leetcode-cn.com/problems/valid-parentheses/description/
 *
 * algorithms
 * Easy (40.64%)
 * Likes:    1382
 * Dislikes: 0
 * Total Accepted:    202.6K
 * Total Submissions: 496.1K
 * Testcase Example:  '"()"'
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 
 * 有效字符串需满足：
 * 
 * 
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 
 * 
 * 注意空字符串可被认为是有效字符串。
 * 
 * 示例 1:
 * 
 * 输入: "()"
 * 输出: true
 * 
 * 
 * 示例 2:
 * 
 * 输入: "()[]{}"
 * 输出: true
 * 
 * 
 * 示例 3:
 * 
 * 输入: "(]"
 * 输出: false
 * 
 * 
 * 示例 4:
 * 
 * 输入: "([)]"
 * 输出: false
 * 
 * 
 * 示例 5:
 * 
 * 输入: "{[]}"
 * 输出: true
 * 
 */

// @lc code=start
public class Solution
{
    public bool IsValid(string s)
    {
        //参考国际站most voted java的代码，如果是左括号就压对应的右括号进栈。
        //如果是右括号就弹栈并看是否匹配，不匹配直接返回false。匹配之后栈应为空
        if (string.IsNullOrEmpty(s)) return true;
        if (s[0] == ']' || s[0] == '}' || s[0] == ')') return false;
        Stack<char> stack = new Stack<char>();
        foreach (char c in s.ToCharArray())
        {
            if (c == '(') { stack.Push(')'); }
            else if (c == '[') { stack.Push(']'); }
            else if (c == '{') { stack.Push('}'); }
            else if (stack.Count == 0 || c != stack.Pop()) return false;
        }
        return stack.Count == 0;
    }
}
// @lc code=end

