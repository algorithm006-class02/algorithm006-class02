/*
 * @lc app=leetcode.cn id=64 lang=cpp
 *
 * [64] 最小路径和
 *
 * https://leetcode-cn.com/problems/minimum-path-sum/description/
 *
 * algorithms
 * Medium (64.50%)
 * Likes:    402
 * Dislikes: 0
 * Total Accepted:    66K
 * Total Submissions: 101.8K
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
//方法1 创建二维数组
class Solution {
public:
    int minPathSum(vector<vector<int>>& grid) {
       vector<vector<int>> res;
       res.resize(grid.size(),vector<int>(grid[0].size()));
       for(int i = grid.size()-1; i >= 0; i--) {
           for(int j = grid[0].size()-1; j >= 0; j--) {
               if(i == grid.size()-1 && j != grid[0].size()-1) {
                   res[i][j]=grid[i][j]+res[i][j+1];
               } else if(i != grid.size()-1 && j == grid[0].size()-1) {
                   res[i][j]=grid[i][j]+res[i+1][j];
               } else if(i != grid.size()-1 && j != grid[0].size()-1) {
                   res[i][j]=grid[i][j]+min(res[i+1][j],res[i][j+1]);
               }else{
                   res[i][j]=grid[i][j];
               }
           }
       }
        return res[0][0];
    }
 
};

//方法2 一位数组
//从下往上，从右往左
class Solution {
public:
    int minPathSum(vector<vector<int>>& grid) {
       vector<int> res(grid[0].size(),0);
       for(int i = grid.size()-1; i >= 0; i--) {
           for(int j = grid[0].size()-1; j >= 0; j--) {
               if(i == grid.size()-1 && j != grid[0].size()-1) {
                   res[j]=grid[i][j]+res[j+1];
               } else if(i != grid.size()-1 && j == grid[0].size()-1) {
                   res[j]=grid[i][j]+res[j];
               } else if(i != grid.size()-1 && j != grid[0].size()-1) {
                   res[j]=grid[i][j]+min(res[j],res[j+1]);
               }else{
                   res[j]=grid[i][j];
               }
           }
       }
        return res[0];
    }
 
};
// @lc code=end

