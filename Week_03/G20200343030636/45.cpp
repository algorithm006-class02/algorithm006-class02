/*
 * @lc app=leetcode.cn id=45 lang=cpp
 *
 * [45] 跳跃游戏 II
 *
 * https://leetcode-cn.com/problems/jump-game-ii/description/
 *
 * algorithms
 * Hard (33.22%)
 * Likes:    370
 * Dislikes: 0
 * Total Accepted:    31K
 * Total Submissions: 93.3K
 * Testcase Example:  '[2,3,1,1,4]'
 *
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * 
 * 示例:
 * 
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 * 从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 
 * 
 * 说明:
 * 
 * 假设你总是可以到达数组的最后一个位置。
 * 
 */

// @lc code=start
class Solution {
public:
    /*
    解法一：DP 设置dp[i] 为跳到位置i需要到最小步数，那么dp[i+1] = min(dp[i] + 1,dp[i])
    */
    int jump(vector<int>& nums) {
        if(nums.size() <= 0) return 0;
        vector<int> dp(nums.size(),INT_MAX) ;
        
        dp[0] = 0;
        
        for(int i = 1 ; i < nums.size() ;++ i) {
            int one = 0 ;
            for( int j = 0 ; j < i ; ++ j) {
                if(nums[j] >= i-j) {
                    dp [ i ] = min(dp[i],dp[j]+1);
                    one = max(nums[j]) ;
                }
            
            }
        }
        return  dp[nums.size()-1] ;
    }
};
// @lc code=end
