/*
 * @lc app=leetcode.cn id=45 lang=cpp
 *
 * [45] 跳跃游戏 II
 *
 * https://leetcode-cn.com/problems/jump-game-ii/description/
 *
 * algorithms
 * Hard (33.04%)
 * Likes:    374
 * Dislikes: 0
 * Total Accepted:    31.6K
 * Total Submissions: 94.9K
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
    解法一：DP，定义d[i]为能到达位置i到跳跃次数，则d[i] = min (d[i-1] , d[i-2] ,d[j],.....d[0]) (i-j<=nums[j])
     从头开始自下而上计算d[i]，超时
	 
    */ 
    int jump(vector<int>& nums) {
       if ( nums.size() <= 1 ) return 0 ;
        //
        vector<int> dp(nums.size(),INT_MAX);

        //初始化dp
        dp[0] = 0 ;
        dp[1] = 1 ;
        
        //nums[2] > 2- 0 dp[2] = dp[0] + 1 
        for( int i = 2; i < nums.size() ; ++i) {
            for( int j = 0 ; j < i; ++ j) {
                if( (nums[j] >= i - j )) {
                    dp[i] = min(dp[j] + 1,dp[i] ) ;
                    dp[i] = dp[j] + 1 ;
                } 
            }
        }
        return dp[nums.size()-1];

    }


    /*
    解法二：高赞答案，判定跳1步，2步分别能到哪些位置，逐步计算，判定最后一个元素是在第几步
    */
    int jump(vector<int>& nums) {
        if ( nums.size() < 2) return 0;

        int step = 0 , curMax = 0 , nextMax = 0 ;
        while( curMax - i + 1 > 0 ) {//该步内能覆盖到位置还没有完
            step ++ ; //跳一步
            //计算下一步能跳到到最远位置
            for( ; i <= curMax ; i++ ) {
                nextMax = max(nextMax,nums[i]+i) ;
                if(nextMax >= nums.size()-1) return step ;
            }
            curMax = nextMax ;
        }
        return 0 ;
    }


    /*
    解法三，高赞答案，nums = [2, 3, 1, 1, 4]，从位置0开始，可以跳nums[0] = 2 步，到达位置nums[1] = 3 和 nums[2] = 1
    这2步覆盖到位置里面，下一个可以到达到最远位置是 max(nums[1] + 1 = 4 ,nums[2] + 2  = 3) = 4，思路总结为
    这每一步跳到到范围内，计算下一步能跳到到最远位置，每一次都是最远到，那么总步数一定是最小到
    12ms 73.52%
    */
    int jump(vector<int> &nums) {
         if(nums.size() < 2) return 0;
        //首次end一定是nums[0]+0，且必然要跳1步；
        int end = nums[0] , i = 1 , next = 0 , step = 1 ;
        while(end < nums.size()-1) {
            step ++ ;
            for(;i <= end ; ++i) {
                next = max(next,nums[i]+i) ;
            }

            end = next;
        }
        return step;
        
    }

   int jump(vector<int>& nums) {
        int i = 0, n = nums.size(), step = 0, end = 0, maxend = 0;
        while (end < n - 1) {//还未到达终点
        	step++;
            //计算下一个可以跳到的最远end；
            for (;i <= end; i++) {
            	maxend = max(maxend, i + nums[i]);
                if (maxend >= n - 1) return step;
            }
            if(end == maxend) break;
            end = maxend; //更新
        }
        return n == 1 ? 0 : -1;
    }

    /*
	解法四，高赞答案，贪心策略，当前要跳的距离段是[curBegin,curEnd]，curFarthest是这个区域内所有点能跳的最远距离；一旦当前的点i到达了
    最远距离，表示要开始下一次起跳
	12ms 74.08%
	*/
     int canJump(vector<int>& nums) {
		 int curFarthest = 0 , curEnd = 0 , jumps = 0 ;
		 //i+nums[i]表示从位置i~i+nums[i]都是可达的，那么只需要看i~i+nums[i]中的每个位置能到达的最远的位置即可
		 for(int i = 0 ; i < nums.size() ;++i ) {
			 //curFarthest表示当前能到达的最远距离
			 curFarthest = max ( curFarthest,i + nums[i] ) ;
             
             //跳到了能跳的最远位置
             if ( i == curEnd ) {
                 jumps ++ ;
                 curEnd = curFarthest ;
                 if(curEnd >= nums.size()-1 ) break;
             }
		 }

		 return jumps ;
         
    }
};
// @lc code=end

