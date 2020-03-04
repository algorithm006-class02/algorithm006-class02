/*
 * @lc app=leetcode.cn id=50 lang=csharp
 *
 * [50] Pow(x, n)
 *
 * https://leetcode-cn.com/problems/powx-n/description/
 *
 * algorithms
 * Medium (33.70%)
 * Likes:    270
 * Dislikes: 0
 * Total Accepted:    53.6K
 * Total Submissions: 157.7K
 * Testcase Example:  '2.00000\n10'
 *
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 * 
 * 示例 1:
 * 
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 
 * 
 * 示例 2:
 * 
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 
 * 
 * 示例 3:
 * 
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2^-2 = 1/2^2 = 1/4 = 0.25
 * 
 * 说明:
 * 
 * 
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−2^31, 2^31 − 1] 。
 * 
 * 
 */

// @lc code=start
public class Solution
{
    public double MyPow(double x, int n)
    {
        //暴力法，O(n)
        //分治法，比如说算2^10可以转化为算2^5 * 2^5，2^5可以转化为 2^2 *2^2 * 2
        //注意边界条件，和预处理
        //分治模板

        //预处理，边界条件
        //1.如果x == 0，直接return 0，x==1，return 1
        if (x == 0 || x == 1) return x;
        //2.如果n是负数,必须要处理，如 2^-2必须转为 （1/2）^2
        return n < 0 ? Pow(1 / x, -n) : Pow(x, n);
    }

    double Pow(double x, int n)
    {
        //terminator 每次减半算，n/2，当n=0或1，本身返回0
        if (n == 0) return 1;
        //子问题
        double tmp = Pow(x, n / 2);
        //合并结果，即，把子问题产生的结果与现在的进行运算，并最终返回给上一层
        //如果n是偶数，则结果为tmp*tmp，这里的思维是当前层只处理当前层的事，不要管下一层
        return n % 2 == 0 ? tmp * tmp : tmp * tmp * x;
    }
}
// @lc code=end

