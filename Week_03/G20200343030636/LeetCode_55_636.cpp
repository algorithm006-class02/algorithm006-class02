/*
 * @lc app=leetcode.cn id=55 lang=cpp
 *
 * [55] 跳跃游戏
 *
 * https://leetcode-cn.com/problems/jump-game/description/
 *
 * algorithms
 * Medium (38.14%)
 * Likes:    477
 * Dislikes: 0
 * Total Accepted:    62.8K
 * Total Submissions: 164.5K
 * Testcase Example:  '[2,3,1,1,4]'
 *
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 
 * 判断你是否能够到达最后一个位置。
 * 
 * 示例 1:
 * 
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 * 
 * 
 * 示例 2:
 * 
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 * 
 * 
 */

// @lc code=start
class Solution {
public:
    /*
    解法一：每个位置pos从1到nums[pos]逐个验证是否能到达，该解法无法通过最长到case，会超时
    */
    bool canJump(vector<int>& nums) {
        if ( nums.size() <= 0 ) return false ;
        unordered_map<int,bool> visited;
        return canJump( nums , 0  , visited) ;
         
    }

    bool canJump(vector<int>& nums , int pos , unordered_map<int,bool> &visited) {
        if ( visited.find(pos) != visited.end() ) return visited[pos] ;
        
        if ( pos >= (nums.size() - 1 ) ) {
            
            return true;
        }
        else {
            for ( int i = nums[pos] ; i >= 1 ; -- i ) {

                if ( ( pos + i ) >= (nums.size()-1) ) {
                    
                    return true ;
                }
                if ( visited.find( pos + i) == visited.end()  ) {
                    visited[pos + i] = canJump(nums,pos + i,visited ) ;
                }
                
                if ( visited[pos + i] ) return true ;
            }
        }
        
        return false;
    }
	
	/*
	解法二,动态规划，从后往前判定，看是否能到位置0
	*/
	bool canJump(vector<int>& nums) {
		vector<int> dp(nums.size());
		dp[nums.size()-1] = 1 ;
		//从倒数第二个位置判定能否调到终点
		for(int i = nums.size() -2 ; i >= 0 ; i--) {
			int jump = (i+nums[i]) < (nums.size()-1) ? i + nums[i] : nums.size() - 1;
			//从位置i+1到位置jump ,如果有一个任意一个位置dp[j]=1的，说明d[i] = 1，即从位置i能调到一个位置j，而这个j能调到最后
			for ( int j = i + 1 ; j <= jump ; ++ j) {
				if(dp[j] == 1) {
					dp[i] = 1;
					break;
				}
			}
		}

		return dp[0];
	}

	/*
    解法三：DP，定义d[i]为能否到达位置i到结果，则d[i] 与 d[i-1]的关系是：(d[i-1] && nums[i-1] > 0) || (d[i-2] && nums[i-2] > 1) || (d[0] && nums[0] > i)
     从头开始自下而上计算d[i]，
	 12ms 74.08%
    */    
    
    bool canJump(vector<int>& nums) {
        if ( nums.size() <= 0 ) return false ;
        //
        vector<bool> dp(nums.size(),false);

        //初始化dp
        dp[0] = true ;
        for( int i = 1; i < nums.size() ; ++i) {
			//判断dp[i]时，从距离i最近的位置判定，只要找到一个满足条件即可。从0开始遍历，会从距离i最远的位置判定，可能要循环的次数更多
            for( int j = i-1 ; j >= 0 ; -- j) {
                dp[i] = dp[j] && (nums[j] >= i - j ) ;
                //已经为true，不用继续探查路径
                if(dp[i]) break;
            }
        }

        return dp[nums.size()-1];

        
    }

	/*
	解法四，高赞答案，每次都更新能到达的最大距离，贪心策略
	12ms 74.08%
	*/
     bool canJump(vector<int>& nums) {
		 int reach = 0 ;
		 //i+nums[i]表示从位置i~i+nums[i]都是可达的，那么只需要看i~i+nums[i]中的每个位置能到达的最远的位置即可
		 for(int i = 0 ; i < nums.size() ;++i ) {
			 //能到达的位置小于位置i，说明存在0
			 if ( reach < i ) return false ;
			 reach = max ( reach,i + nums[i] ) ;
			 if ( reach >= nums.size()-1 ) return true ;
		 }

		 return false ;
         
    }

};
// @lc code=end

