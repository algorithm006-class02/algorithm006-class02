/*
 * @lc app=leetcode.cn id=64 lang=cpp
 *
 * [64] 最小路径和
 *
 * https://leetcode-cn.com/problems/minimum-path-sum/description/
 *
 * algorithms
 * Medium (64.49%)
 * Likes:    398
 * Dislikes: 0
 * Total Accepted:    63.8K
 * Total Submissions: 98.5K
 * Testcase Example:  '[[1,3,1],[1,5,1],[4,2,1]]'
 *
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 
 * 说明：每次只能向下或者向右移动一步。
 * 
 * 示例:
 * 
 * 输入:
 * [
 * [1,3,1],
 * ⁠ [1,5,1],
 * ⁠ [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 * 
 * 
 */

// @lc code=start
class Solution {
public:
    /*
    解法一：动态规划思路，定义d[i][j]为到达位置[i,j]的最小路径和，那么有2种方式能到达位置[i,j]，分别是[i-1,j]和[i,j-1]，那么得到递推公式;
    d[i][j] = min(d[i-1][j],d[i][j-1])+v[i][j]
    */
    int minPathSum(vector<vector<int>>& grid) {
        if(grid.size() == 0 || grid[0].size() == 0) return 0;

        vector<vector<int>> dp(grid.size(),vector<int>(grid[0].size(),0));

        dp[0][0] = grid[0][0];

        //处理第一行,第一行的每一个位置只能是往右走到达
        for(int i = 1 ; i < grid[0].size();++i)
            dp[0][i] = dp[0][i-1]+grid[0][i] ;

        //处理第一列，第一列的每一个位置只能是往下走到达
        for(int i = 1 ; i < grid.size();++i)
            dp[i][0] = dp[i-1][0]+grid[i][0] ;

        for(int i = 1 ; i < grid.size() ;++i) {
            for(int j = 1 ; j < grid[i].size();++j) {
                dp[i][j] = min(dp[i-1][j],dp[i][j-1])+grid[i][j] ;
            }
        }

        return dp[grid.size()-1][grid[0].size()-1];
    }



    /*
    社区高赞做法：思路一摸一样，但是减少了空间复杂度，解法一的空间复杂度是O(m*n)，优化之后可做到O(m+n) 或者 O(n)
    */
    int minPathSum(vector<vector<int>>& grid) {
        int m = grid.size();
        int n = grid[0].size();
        vector<int> pre(m, grid[0][0]);
        vector<int> cur(m, 0);
        
        //处理第一列
        for (int i = 1; i < m; i++)
            pre[i] = pre[i - 1] + grid[i][0];

        //先处理列
        for (int j = 1; j < n; j++) { 
            cur[0] = pre[0] + grid[0][j]; 
            for (int i = 1; i < m; i++)
                cur[i] = min(cur[i - 1], pre[i]) + grid[i][j];
            swap(pre, cur); 
        }
        return pre[m - 1];
    }

    int minPathSum(vector<vector<int>>& grid) {
        int m = grid.size();
        int n = grid[0].size();
        vector<int> cur(m, grid[0][0]);

        //处理第一列
        for (int i = 1; i < m; i++)
            cur[i] = cur[i - 1] + grid[i][0]; 

        //先处理列
        for (int j = 1; j < n; j++) {
            cur[0] += grid[0][j]; 
            for (int i = 1; i < m; i++)
                cur[i] = min(cur[i - 1], cur[i]) + grid[i][j];
        }
        return cur[m - 1];
    }
};
// @lc code=end

