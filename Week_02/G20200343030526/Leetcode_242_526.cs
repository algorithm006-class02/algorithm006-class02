/*
 * @lc app=leetcode.cn id=242 lang=csharp
 *
 * [242] 有效的字母异位词
 *
 * https://leetcode-cn.com/problems/valid-anagram/description/
 *
 * algorithms
 * Easy (58.03%)
 * Likes:    157
 * Dislikes: 0
 * Total Accepted:    74.2K
 * Total Submissions: 127K
 * Testcase Example:  '"anagram"\n"nagaram"'
 *
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 
 * 示例 1:
 * 
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 
 * 
 * 示例 2:
 * 
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 
 * 说明:
 * 你可以假设字符串只包含小写字母。
 * 
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 * 
 */

// @lc code=start
using System.Collections.Generic;
public class Solution
{
    public bool IsAnagram(string s, string t)
    {
        if (s.Length != t.Length)
        {
            return false;
        }
        //字母出现的频次一致
        Dictionary<char, int> dic = new Dictionary<char, int>();
        foreach (char cs in s)
        {
            if (dic.ContainsKey(cs)) dic[cs]++;
            else dic[cs] = 1;
        }
        foreach (char ts in t)
        {
            if (dic.ContainsKey(ts))
            {
                dic[ts]--;
                if (dic[ts] == 0) dic.Remove(ts);
            }
            else return false;
        }
        return dic.Count == 0;
    }
}
// @lc code=end

