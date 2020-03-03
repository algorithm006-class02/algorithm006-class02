/*
 * @lc app=leetcode.cn id=127 lang=csharp
 *
 * [127] 单词接龙
 *
 * https://leetcode-cn.com/problems/word-ladder/description/
 *
 * algorithms
 * Medium (39.14%)
 * Likes:    219
 * Dislikes: 0
 * Total Accepted:    23.6K
 * Total Submissions: 58.9K
 * Testcase Example:  '"hit"\n"cog"\n["hot","dot","dog","lot","log","cog"]'
 *
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord
 * 的最短转换序列的长度。转换需遵循如下规则：
 * 
 * 
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 
 * 
 * 说明:
 * 
 * 
 * 如果不存在这样的转换序列，返回 0。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * 
 * 
 * 示例 1:
 * 
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * 
 * 输出: 5
 * 
 * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * ⁠    返回它的长度 5。
 * 
 * 
 * 示例 2:
 * 
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * 
 * 输出: 0
 * 
 * 解释: endWord "cog" 不在字典中，所以无法进行转换。
 * 
 */

// @lc code=start
using System.Collections.Generic;
public class Solution
{
    public int LadderLength(string beginWord, string endWord, IList<string> wordList)
    {
        //双bfs从头尾遍历
        if (!wordList.Contains(endWord)) return 0;
        if (beginWord == endWord) return 2;
        HashSet<string> visited = new HashSet<string>();
        HashSet<string> wordSet = new HashSet<string>(wordList);
        HashSet<string> beginQueue = new HashSet<string>();
        beginQueue.Add(beginWord);
        HashSet<string> endQueue = new HashSet<string>();
        endQueue.Add(endWord);

        int distance = 0;

        while (beginQueue.Count > 0 && endQueue.Count > 0)
        {
            distance++;
            //选择最小的队列进行遍历
            if (beginQueue.Count > endQueue.Count)
            {
                var tmp = beginQueue;
                beginQueue = endQueue;
                endQueue = tmp;
            }

            HashSet<string> current = new HashSet<string>();//利用hashset查询O(1),但没有队列的功能，所以重新new一个
            foreach (var word in beginQueue)
            {
                HashSet<string> candidates = GetNextCandidates(word, wordSet);
                foreach (var c in candidates)
                {
                    //两向遍历在中间相遇
                    if (endQueue.Contains(c)) return distance + 1;
                    if (!visited.Contains(c))
                    {
                        current.Add(c);
                        visited.Add(c);
                    }
                }
            }
            beginQueue = current;
        }
        return 0;
    }

    HashSet<string> GetNextCandidates(string word, HashSet<string> wordSet)
    {
        HashSet<string> result = new HashSet<string>();


        for (int j = 0; j < word.Length; j++)
        {
            for (int i = 0; i < 26; i++)
            {
                char[] c = word.ToCharArray();
                c[j] = (char)('a' + i);
                if (c[j] != word[j])
                {
                    string tmp = new string(c);
                    if (wordSet.Contains(tmp))
                        result.Add(tmp);
                }
            }
        }
        return result;
    }
}
// @lc code=end

