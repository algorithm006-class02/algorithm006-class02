/*
 * @lc app=leetcode.cn id=15 lang=cpp
 *
 * [15] 三数之和
 *
 * https://leetcode-cn.com/problems/3sum/description/
 *
 * algorithms
 * Medium (25.43%)
 * Likes:    1795
 * Dislikes: 0
 * Total Accepted:    156.2K
 * Total Submissions: 613K
 * Testcase Example:  '[-1,0,1,2,-1,-4]'
 *
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0
 * ？找出所有满足条件且不重复的三元组。
 * 
 * 注意：答案中不可以包含重复的三元组。
 * 
 * 
 * 
 * 示例：
 * 
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 
 * 满足要求的三元组集合为：
 * [
 * ⁠ [-1, 0, 1],
 * ⁠ [-1, -1, 2]
 * ]
 * 
 * 
 */

// @lc code=start
class Solution {
public:
    /*
    解法一：先排序数组，固定第一个元素，然后用双指针查找符合另外2个元素的情况。注意重复值的处理，时间复杂度O(n^2)，空间复杂度O(1)
    60ms 90.09%
    */
    /*
    vector<vector<int>> threeSum(vector<int>& nums) {
        //排序
        sort( nums.begin() , nums.end() ) ;

        vector<vector<int>> result ;
        //正数序列不可能存在结果；
        if ( nums.size() > 0 && nums[0] > 0 ) return result ;

        int target = 0 ;
        for ( int i = 0 ; i < nums.size() ; ++ i ) {
            //
            if ( nums[i] > 0 ) break ;
            //和之前的元素重复
            if ( i > 0 && nums[i] == nums [i - 1] ) continue ;
            target = 0 - nums[i] ;
            
            //双指针，m初始值=i+1 ，如果三数之和为0 ，排序后前面必然有负数。那么target > 0才可能有解。nums[i] 左边的数<0 ,只有右边的数有可能>0
            for ( int m = i + 1 , n = nums.size() - 1 ; m  <  n ; ) {
                if ( nums[m] + nums[n] < target ) {
                    ++ m ;
                }
                else if ( nums[m] + nums[n] > target ) {
                    -- n ;
                }
                else {
                    vector<int> one({nums[i],nums[m],nums[n]}) ;
                    result.emplace_back(one) ;

                    //排除掉重复元素
                    ++ m ;
                    while ( m < n && nums[ m - 1 ] == nums[ m ]) {
                        ++ m ;
                    }

                    if ( m >= n ) break ;
                    -- n ;
                    while ( n > m && nums[ n + 1 ] == nums[ n ]) {
                        -- n ;
                    }

                    if( n == m ) break ;
                }
            } 
        }

        return result ;
    }
    */

    /*
    解法一：先排序数组，固定第一个元素，然后用类似2sum的hash查找另外两个元素。注意重复值的处理，时间复杂度O(n^2)，空间复杂度O(n)
    60ms 90.09%
    */
    vector<vector<int>> threeSum(vector<int>& nums) {
        //排序
        sort( nums.begin() , nums.end() ) ;

        vector<vector<int>> result ;
        //正数序列不可能存在结果；
        if ( nums.size() > 0 && nums[0] > 0 ) return result ;

        int target = 0 ; 
        unordered_map<int,int> hash ;
        for ( int i = 0 ; i < nums.size() ; ++ i ) {
            //
            if ( nums[i] > 0 ) break ;
            //和之前的元素重复
            if ( i > 0 && nums[i] == nums [i - 1] ) continue ;
            target = 0 - nums[i] ;
            
            //双指针，m初始值=i+1 ，如果三数之和为0 ，排序后前面必然有负数。那么target > 0才可能有解。nums[i] 左边的数<0 ,只有右边的数有可能>0
            for ( int j = i + 1; j < nums.size() ;  ) {
                cout << j << endl;
                if ( hash.find( target - nums[j] ) == hash.end() ) {
                    hash.emplace( nums[j],j ) ;
                    ++ j ;
                }
                //找到二元组
                else {
                    vector<int> one({nums[i],target - nums[j],nums[j]}) ;
                    cout << nums[i] << "," << (target - nums[j]) << "," << nums[j] << endl;
                    result.emplace_back(one) ;
                    //过滤重复元素
                    ++ j ;
                    while ( j < nums.size() &&  nums[j] == nums[j - 1] ) {
                        ++ j ;
                    }                  
                }
            } 
            hash.clear() ;
        }

        return result ;
    }


};
// @lc code=end

