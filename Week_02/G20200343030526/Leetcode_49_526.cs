/*
 * @lc app=leetcode.cn id=49 lang=csharp
 *
 * [49] 字母异位词分组
 *
 * https://leetcode-cn.com/problems/group-anagrams/description/
 *
 * algorithms
 * Medium (60.31%)
 * Likes:    266
 * Dislikes: 0
 * Total Accepted:    50.1K
 * Total Submissions: 82.5K
 * Testcase Example:  '["eat","tea","tan","ate","nat","bat"]'
 *
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * 
 * 示例:
 * 
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 * ⁠ ["ate","eat","tea"],
 * ⁠ ["nat","tan"],
 * ⁠ ["bat"]
 * ]
 * 
 * 说明：
 * 
 * 
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 * 
 * 
 */

// @lc code=start
public class Solution
{
    public IList<IList<string>> GroupAnagrams(string[] strs)
    {
        //设计一种hash算法 f(s)使得 f("abo") == f("aob") == f("oba")等等
        //将该值作为key存入dictionary，遍历时如果key相同，则加入到dictionary中
        var dic = new System.Collections.Generic.Dictionary<string, IList<string>>();
        foreach (string s in strs)
        {
            string code = GetCode(s);
            if (dic.ContainsKey(code)) dic[code].Add(s);
            else dic.Add(code, new System.Collections.Generic.List<string>() { s });
        }
        return dic.Values.ToList();
    }

    string GetCode(string str)
    {
        byte[] array = new byte[26];
        foreach (char c in str)
        {
            byte b = (byte)(c - 'a');
            array[b]++;
        }
        return System.Text.Encoding.UTF8.GetString(array);
    }

}
// @lc code=end

