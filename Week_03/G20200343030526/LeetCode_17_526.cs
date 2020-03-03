/*
 * @lc app=leetcode.cn id=17 lang=csharp
 *
 * [17] 电话号码的字母组合
 *
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/description/
 *
 * algorithms
 * Medium (52.14%)
 * Likes:    598
 * Dislikes: 0
 * Total Accepted:    82.5K
 * Total Submissions: 156.5K
 * Testcase Example:  '"23"'
 *
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 
 * 
 * 
 * 示例:
 * 
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 
 * 
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 * 
 */

// @lc code=start
public class Solution
{
    public IList<string> LetterCombinations(string digits)
    {
        //深度优先
        var result = new List<string>();
        if(string.IsNullOrEmpty(digits)) return result;
        Dictionary<char, string> dic = new Dictionary<char, string>{{'2',"abc"},{'3',"def"},{'4',"ghi"},{'5',"jkl"},
        {'6',"mno"},{'7',"pqrs"},{'8',"tuv"},{'9',"wxyz"}};
        Dfs(digits, 0, dic, "", result);
        return result;
    }

    void Dfs(string digits, int level, Dictionary<char, string> dic, string tmp, IList<string> result)
    {
        //terminator
        if (level == digits.Length)
        {
            result.Add(tmp);
            return;
        }
        //process
        //drill down
        string letter = dic[digits[level]];
        foreach (char c in letter)
        {
            string tmp1 = tmp + c;//需要用一个新的变量
            Dfs(digits, level + 1, dic, tmp1, result);
        }
    }
}
// @lc code=end

