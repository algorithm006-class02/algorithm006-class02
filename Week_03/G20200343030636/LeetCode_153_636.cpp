/*
 * @lc app=leetcode.cn id=153 lang=cpp
 *
 * [153] 寻找旋转排序数组中的最小值
 *
 * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/description/
 *
 * algorithms
 * Medium (50.21%)
 * Likes:    143
 * Dislikes: 0
 * Total Accepted:    33.1K
 * Total Submissions: 66K
 * Testcase Example:  '[3,4,5,1,2]'
 *
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * 
 * ( 例如，数组 [0,1,2,4,5,6,7]  可能变为 [4,5,6,7,0,1,2] )。
 * 
 * 请找出其中最小的元素。
 * 
 * 你可以假设数组中不存在重复元素。
 * 
 * 示例 1:
 * 
 * 输入: [3,4,5,1,2]
 * 输出: 1
 * 
 * 示例 2:
 * 
 * 输入: [4,5,6,7,0,1,2]
 * 输出: 0
 * 
 */

// @lc code=start
class Solution {
public:
    /*
    binary search O(logn)
    4ms 88.84%
    */
    
    int findMin(vector<int>& nums) {
        if(nums.size() <= 0) return 0 ;

        int left = 0 , right = nums.size() - 1 ;

        if(nums[right] >= nums[left]) return nums[left] ;


        int mid = -1 ;
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

        return mid != -1 ? nums[mid] : mid ;
    }
    
    /*
    O(n)
    */
    int findMin(vector<int>& nums) {
       if(nums.size() <= 0) return 0 ;

        int left = 0 , right = nums.size() - 1 ;

        if(nums[right] >= nums[left]) return nums[left] ;

        int i = 0 ;
        for( ; i < nums.size() ; ++ i) {
            if( i < nums.size()-1 && nums[i] > nums[i+1] ) {
                break;
            }
        }

        return i< nums.size() - 1 ? nums[i+1] : nums[i];


    }
    
};
// @lc code=end

