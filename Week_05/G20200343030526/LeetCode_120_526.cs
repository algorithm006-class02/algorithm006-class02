/*
 * @lc app=leetcode.cn id=120 lang=csharp
 *
 * [120] 三角形最小路径和
 *
 * https://leetcode-cn.com/problems/triangle/description/
 *
 * algorithms
 * Medium (63.31%)
 * Likes:    332
 * Dislikes: 0
 * Total Accepted:    44.3K
 * Total Submissions: 69.4K
 * Testcase Example:  '[[2],[3,4],[6,5,7],[4,1,8,3]]'
 *
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * 
 * 例如，给定三角形：
 * 
 * [
 * ⁠    [2],
 * ⁠   [3,4],
 * ⁠  [6,5,7],
 * ⁠ [4,1,8,3]
 * ]
 * 
 * 
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * 
 * 说明：
 * 
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 * 
 */

// @lc code=start
public class Solution
{
    public int MinimumTotal(IList<IList<int>> triangle)
    {
        //1.子问题，要找2到下的最小路径和，就是找3，4的最小路径和+2
        //2.定义状态 f[i,j]
        //3.DP 方程 f[i,j] += Min(f[i+1,j],f[i+1,j+1])
        int[] array = new int[triangle[triangle.Count - 1].Count+1];//这里注意数组要开Count + 1
        for (int i = triangle.Count - 1; i >= 0; i--)//这里要从Count -1 开始倒着循环
        {
            var row = triangle[i];
            for (int j = 0; j < row.Count; j++)
            {
                array[j] = System.Math.Min(array[j + 1], array[j]) + triangle[i][j];
            }
        }
        return array[0];
    }
}
// @lc code=end

