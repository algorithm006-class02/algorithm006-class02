/*
 * @lc app=leetcode.cn id=283 lang=cpp
 *
 * [283] 移动零
 *
 * https://leetcode-cn.com/problems/move-zeroes/description/
 *
 * algorithms
 * Easy (59.19%)
 * Likes:    493
 * Dislikes: 0
 * Total Accepted:    105.3K
 * Total Submissions: 177.9K
 * Testcase Example:  '[0,1,0,3,12]'
 *
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 
 * 示例:
 * 
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 
 * 说明:
 * 
 * 
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 * 
 * 
 */

// @lc code=start
class Solution {
public:
    void moveZeroes(vector<int>& nums) {
        /* 解法一：遍历数组，遇到0即删除，同时计数，最后再尾部添加对应个数的0。使用vector的删除功能。数组的删除
           需要移动元素，所以效率不高；在尾部增加的性能较好。时间复杂度 O(n^2)
         *16ms 62.11 %  
        */
        int num = 0 ;
        for ( auto it = nums.begin () ; it != nums.end () ; ) {
            if ( *it == 0 ) {
                it = nums.erase ( it ) ;
                ++num;
            }
            else {
                it++;
            }     
        }

        nums.insert(nums.end(),num,0);
        
        
       /* 解法二：遍历数组，找到为0的元素后，向后寻找第一个不为0的元素，进行位置交换。每个元素只访问了一遍，时间复杂度为
       O(n)，效率大大提升
       8 ms 93.73%
       */
       int i = 0 ,j = -1 ;
       for ( ; i < nums.size() ; ++ i )
       {
           if ( nums[i] == 0 ) {
               j = j == -1 ? i + 1 : j ;
               while ( j < nums.size() && nums [ j ] == 0 ) {
                   ++ j ;
               };
               if ( j < nums.size() ) {
                   swap ( nums[i],nums[j] ) ; 
                   ++ j;
               }
               else {
                   break;
               }
           }

       }
       
    }
};
// @lc code=end

