/*
 * @lc app=leetcode.cn id=22 lang=cpp
 *
 * [22] 括号生成
 *
 * https://leetcode-cn.com/problems/generate-parentheses/description/
 *
 * algorithms
 * Medium (73.22%)
 * Likes:    773
 * Dislikes: 0
 * Total Accepted:    78.6K
 * Total Submissions: 107K
 * Testcase Example:  '3'
 *
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * 
 * 例如，给出 n = 3，生成结果为：
 * 
 * [
 * ⁠ "((()))",
 * ⁠ "(()())",
 * ⁠ "(())()",
 * ⁠ "()(())",
 * ⁠ "()()()"
 * ]
 * 
 * 
 */

// @lc code=start
class Solution {
public:
    vector<string> generateParenthesis(int n) {
      //动态规划，第n步的结果来源于n-1步的基础
      //i对括号的组合，在i-1对括号的基础上得到
      //dp[i] = "(" + dp[可能的括号对数] + ")" + dp[剩下的括号对数]
      //( ()() )()
      //可能的+剩下的=n-1
      //可能的>=0 <n;剩下的>=0  <n
      vector<vector<string>> resu;
      resu.push_back({""});     
      for (int i = 1; i <=n; i++) {        
         for ( int j = 0; j < i; j++ ) {
             for (auto a : resu[i]) {
                 for (auto b: resu[i-1-j]) {
                     resu[i].push_back("("+a+")"+b);
                 }
             }
         }
  
      }
      return resu[n];
    } 
    
};
// @lc code=end

