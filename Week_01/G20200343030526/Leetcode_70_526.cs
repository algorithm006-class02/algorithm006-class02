/*
 * @lc app=leetcode.cn id=70 lang=csharp
 *
 * [70] 爬楼梯
 *
 * https://leetcode-cn.com/problems/climbing-stairs/description/
 *
 * algorithms
 * Easy (47.63%)
 * Likes:    817
 * Dislikes: 0
 * Total Accepted:    128.2K
 * Total Submissions: 268.7K
 * Testcase Example:  '2'
 *
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 
 * 注意：给定 n 是一个正整数。
 * 
 * 示例 1：
 * 
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 
 * 示例 2：
 * 
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 * 
 * 
 */

// @lc code=start
public class Solution
{
    public int ClimbStairs(int n)
    {
        //数学归纳法，将问题转换为求最后的斐波那契数
        //1.n=1 1
        //2.n=2 2
        //3 n=3 猜想是否是n=2的走法+n=1的走法
        //4 第n阶台阶有两种走法，1），从第 n-1阶跨到 n 阶。 2），从第n-2阶跨到 n 阶
        // 所以 f(n) = f(n-1) + f(n-2)
        if (n < 3)
        {
            return n;
        }
        int f1 = 1,f2 = 2,f3 = 3;
        for (int i = 3; i <= n; i++)
        {
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        return f3;
    }
}
// @lc code=end

