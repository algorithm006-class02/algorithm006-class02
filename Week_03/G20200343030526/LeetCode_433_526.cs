/*
 * @lc app=leetcode.cn id=433 lang=csharp
 *
 * [433] 最小基因变化
 *
 * https://leetcode-cn.com/problems/minimum-genetic-mutation/description/
 *
 * algorithms
 * Medium (48.35%)
 * Likes:    23
 * Dislikes: 0
 * Total Accepted:    2.4K
 * Total Submissions: 5K
 * Testcase Example:  '"AACCGGTT"\n"AACCGGTA"\n["AACCGGTA"]'
 *
 * 一条基因序列由一个带有8个字符的字符串表示，其中每个字符都属于 "A", "C", "G", "T"中的任意一个。
 * 
 * 假设我们要调查一个基因序列的变化。一次基因变化意味着这个基因序列中的一个字符发生了变化。
 * 
 * 例如，基因序列由"AACCGGTT" 变化至 "AACCGGTA" 即发生了一次基因变化。
 * 
 * 与此同时，每一次基因变化的结果，都需要是一个合法的基因串，即该结果属于一个基因库。
 * 
 * 现在给定3个参数 — start, end,
 * bank，分别代表起始基因序列，目标基因序列及基因库，请找出能够使起始基因序列变化为目标基因序列所需的最少变化次数。如果无法实现目标变化，请返回
 * -1。
 * 
 * 注意:
 * 
 * 
 * 起始基因序列默认是合法的，但是它并不一定会出现在基因库中。
 * 所有的目标基因序列必须是合法的。
 * 假定起始基因序列与目标基因序列是不一样的。
 * 
 * 
 * 示例 1:
 * 
 * 
 * start: "AACCGGTT"
 * end:   "AACCGGTA"
 * bank: ["AACCGGTA"]
 * 
 * 返回值: 1
 * 
 * 
 * 示例 2:
 * 
 * 
 * start: "AACCGGTT"
 * end:   "AAACGGTA"
 * bank: ["AACCGGTA", "AACCGCTA", "AAACGGTA"]
 * 
 * 返回值: 2
 * 
 * 
 * 示例 3:
 * 
 * 
 * start: "AAAAACCC"
 * end:   "AACCCCCC"
 * bank: ["AAAACCCC", "AAACCCCC", "AACCCCCC"]
 * 
 * 返回值: 3
 * 
 * 
 */

// @lc code=start
public class Solution
{
    public int MinMutation(string start, string end, string[] bank)
    {
        //找出start和end存在的差异，判断中间值在不在bank中
        //关键问题是如何转化中间值
        //边界条件，如果start为空，end为空或bank为空，返回-1
        //如果end不在bank中，返回-1
        //以下是错误思路，默认按index顺序变化了
        // if (string.IsNullOrEmpty(start) || string.IsNullOrEmpty(end) || bank.Length == 0) return -1;
        // if (bank.Contains(end) == false) return -1;
        // int count = -1;
        // char[] tmp = start.ToCharArray();
        // for (int i = 0; i < start.Length; i++)
        // {
        //     if (start[i] != end[i])
        //     {
        //         tmp[i] = end[i];
        //         string str = new string(tmp);
        //         if (bank.Contains(str) == false) return -1;
        //         if(count == -1) count = 0;
        //         count++;
        //     }
        // }
        // return count;

        //从start开始到end有多种路径，只要start bank end存在其中一条最小路径，则返回路径深度。
        //符合bfs特点，层序遍历时，只有当start[i]!=end[i]时才需要处理
        //如果当前层任何一个值都不在bank中，则返回-1，否则count++

        //边界条件，如果start为空，end为空或bank为空，返回-1
        //如果end不在bank中，返回-1
        if (string.IsNullOrEmpty(start) || string.IsNullOrEmpty(end) || bank.Length == 0) return -1;
        if (bank.Contains(end) == false) return -1;

        int count = 0;
        Queue<string> queue = new Queue<string>();
        queue.Enqueue(start);
        ISet<string> visited = new HashSet<string>();
        while (queue.Count != 0)
        {
            int size = queue.Count;//当前层有多少个元素
            for (int i = 0; i < size; i++)
            {
                string current = queue.Dequeue();
                if (current == end) return count;
                for (int j = 0; j < start.Length; j++)
                {
                    char[] tmp = current.ToCharArray();
                    foreach (var c in "ACGT")
                    {
                        if (tmp[j] != c) tmp[j] = c;
                        string str = new string(tmp);
                        if (visited.Contains(str) == false && bank.Contains(str))
                        {
                            visited.Add(str);
                            queue.Enqueue(str);
                        }
                    }
                }
            }
            count++;
        }
        return -1;
    }
}
// @lc code=end

