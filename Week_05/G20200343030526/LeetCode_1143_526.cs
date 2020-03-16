/*
 * @lc app=leetcode.cn id=1143 lang=csharp
 *
 * [1143] 最长公共子序列
 *
 * https://leetcode-cn.com/problems/longest-common-subsequence/description/
 *
 * algorithms
 * Medium (58.11%)
 * Likes:    68
 * Dislikes: 0
 * Total Accepted:    10.7K
 * Total Submissions: 18.2K
 * Testcase Example:  '"abcde"\n"ace"'
 *
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列。
 * 
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde"
 * 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
 * 
 * 若这两个字符串没有公共子序列，则返回 0。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 输入：text1 = "abcde", text2 = "ace" 
 * 输出：3  
 * 解释：最长公共子序列是 "ace"，它的长度为 3。
 * 
 * 
 * 示例 2:
 * 
 * 输入：text1 = "abc", text2 = "abc"
 * 输出：3
 * 解释：最长公共子序列是 "abc"，它的长度为 3。
 * 
 * 
 * 示例 3:
 * 
 * 输入：text1 = "abc", text2 = "def"
 * 输出：0
 * 解释：两个字符串没有公共子序列，返回 0。
 * 
 * 
 * 
 * 
 * 提示:
 * 
 * 
 * 1 <= text1.length <= 1000
 * 1 <= text2.length <= 1000
 * 输入的字符串只含有小写英文字符。
 * 
 * 
 */

// @lc code=start
public class Solution
{
    public int LongestCommonSubsequence(string text1, string text2)
    {
        //如果text1 和 text2 有一个长度为0，返回0
        if (text1.Length == 0 || text2.Length == 0) return 0;
        //如果text1和text2的最后一个字符相同，
        //则最长公共子序列为text1,text2去除最后一个字符后的新字符串的最长公共子序列+1
        //如 ....A和....A
        //如果text1和text2最后一个字符不相同，则最长公共子序列为Max(Lcs(text1-1,text2),Lcs(text1,text2-1))
        //递归超时，因为没有记忆化存储，重复计算
        // int r = 0;
        // if (text1[text1.Length - 1] == text2[text2.Length - 1])
        //     r = LongestCommonSubsequence(text1.Remove(text1.Length - 1), text2.Remove(text2.Length - 1)) + 1;
        // else
        //     r =System.Math.Max(LongestCommonSubsequence(text1.Remove(text1.Length - 1),text2),
        //                         LongestCommonSubsequence(text1,text2.Remove(text2.Length - 1)));
        // return r;
        int m = text1.Length;
        int n = text2.Length;
        int[,] dp = new int[m + 1, n + 1];
        for (int i = 1; i < m + 1; i++)
        {
            for (int j = 1; j < n + 1; j++)
            {
                if (text1[i - 1] == text2[j - 1])
                    dp[i, j] = dp[i - 1, j - 1] + 1;
                else
                    dp[i, j] = Math.Max(dp[i - 1, j], dp[i, j - 1]);
            }
        }
        return dp[m, n];
    }
}
// @lc code=end

