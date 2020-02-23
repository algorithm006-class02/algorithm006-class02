/*
 * @lc app=leetcode.cn id=1 lang=cpp
 *
 * [1] 两数之和
 *
 * https://leetcode-cn.com/problems/two-sum/description/
 *
 * algorithms
 * Easy (47.54%)
 * Likes:    7682
 * Dislikes: 0
 * Total Accepted:    829.9K
 * Total Submissions: 1.7M
 * Testcase Example:  '[2,7,11,15]\n9'
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * 
 * 示例:
 * 
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * 
 * 
 */

// @lc code=start
class Solution {
public:
    /*
    解法一：遍历，并用hash存储已经遍历的元素，判断sum-nums[i]在不在hash中，在则找到
    时间复杂度 O(n)，空间复杂度O(n)。此题返回的是下标，意味着不能排序处理，若返回元素值，则可以排序后双指针处理
    8ms 96.64%
    */
    vector<int> twoSum(vector<int>& nums, int target) {

        vector<int> get ;
        
        unordered_map<int,int> hash;
        for ( int i = 0 ; i < nums.size() ; ++ i ) {
            auto it = hash.find( target - nums[ i ] ) ;
            if ( it == hash.end() )
            {
                hash.emplace( nums[ i ] , i ) ;
            }
            else 
            {
                get.emplace_back( it -> second ) ;
                get.emplace_back( i ) ;
            }
        }

        return get;
    }

    /*
    解法二：暴力法，两层循环，时间复杂度O(n^2)，注意第二层循环不需要从0开始，而是从i后面第一个元素开始
    180ms 42.82%
    */
    
    vector<int> twoSum(vector<int>& nums, int target) {

        vector<int> get ;

        for ( int i = 0 ; i < nums.size() ; ++ i ) {
            for ( int j = i + 1 ; j < nums.size() ; ++ j ) {
                if ( nums[ i ] + nums[ j ] == target ) {
                    get.emplace_back( i ) ;
                    get.emplace_back( j ) ;

                    return get ;
                }
            }
        }

        return get ;
    }
    
};
// @lc code=end

