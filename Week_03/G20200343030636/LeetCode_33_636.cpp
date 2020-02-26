/*
 * @lc app=leetcode.cn id=33 lang=cpp
 *
 * [33] 搜索旋转排序数组
 *
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/description/
 *
 * algorithms
 * Medium (36.44%)
 * Likes:    530
 * Dislikes: 0
 * Total Accepted:    77.2K
 * Total Submissions: 211.7K
 * Testcase Example:  '[4,5,6,7,0,1,2]\n0'
 *
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * 
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * 
 * 你可以假设数组中不存在重复的元素。
 * 
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 
 * 示例 1:
 * 
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 
 * 
 * 示例 2:
 * 
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 * 
 */

// @lc code=start
class Solution {
public:
    /*
    1.find the minest num(problem 153) ,seperate the array to 2 sorted array
    2.binary search
    O(logn)
    4ms 89.83%
    */
    int search(vector<int>& nums, int target) {
        if( nums.size() <= 0 ) return -1 ;
        //binary-search
        int left = 0 , right = nums.size() - 1 , mid = -1 ;

        if(nums[right] < nums[left]) {   
            //get the minest pos
            while ( left <= right) {
                mid = left + right >> 1;
                if( mid > 0 && nums[mid] < nums[mid-1] ) {
                    break;
                } 
                
                else if(mid+1 <nums.size() && nums[mid] > nums[mid+1]) {
                    mid = mid + 1;
                    break;
                }
                else if(nums[mid] > nums[left]) {
                    left = mid + 1;
                }
                else {
                    right = mid - 1;
                }
            }
            
            //less than the min
            if ( target < nums[mid]) return -1;

            //refresh
            left = 0 , right = nums.size() - 1 ;

            //in the small side
            if ( target <= nums[nums.size() - 1])  {
                left = mid ;
            }
            //in the big side
            else {
                right = mid - 1 ;
            }
        }


        //normal binary search
        while ( left <= right) {
            mid = right + left >> 1;
            
            if (target == nums[mid])  {
                return mid ;
            }
            else if(target < nums[mid]) {
                right = mid - 1 ;
            }
            else {
               left = mid + 1;
            }
        }

        return -1 ;

    }
};
// @lc code=end

