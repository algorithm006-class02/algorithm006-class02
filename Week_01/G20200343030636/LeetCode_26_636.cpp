/*
 * @lc app=leetcode.cn id=26 lang=cpp
 *
 * [26] 删除排序数组中的重复项
 *
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/description/
 *
 * algorithms
 * Easy (48.43%)
 * Likes:    1323
 * Dislikes: 0
 * Total Accepted:    243.9K
 * Total Submissions: 503.4K
 * Testcase Example:  '[1,1,2]'
 *
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * 
 * 示例 1:
 * 
 * 给定数组 nums = [1,1,2], 
 * 
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。 
 * 
 * 你不需要考虑数组中超出新长度后面的元素。
 * 
 * 示例 2:
 * 
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 * 
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 * 
 * 你不需要考虑数组中超出新长度后面的元素。
 * 
 * 
 * 说明:
 * 
 * 为什么返回数值是整数，但输出的答案是数组呢?
 * 
 * 请注意，输入数组是以“引用”方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 * 
 * 你可以想象内部操作如下:
 * 
 * // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
 * int len = removeDuplicates(nums);
 * 
 * // 在函数里修改输入数组对于调用者是可见的。
 * // 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
 * for (int i = 0; i < len; i++) {
 * print(nums[i]);
 * }
 * 
 * 
 */

// @lc code=start
class Solution {
public:
    
    /*
    解法一：常规解法，遇到后一个和当前相同的元素则删除，涉及到数组元素到删除，需要多次搬迁数据，效率较低，时间复杂度O(n^2)
    332ms 5.09%
    */
    int removeDuplicates(vector<int>& nums) {    
        for ( auto it = nums.begin() ; it != nums.end() ; )
        {
            auto next = it+1;
            if ( next != nums.end() && *it == *next){
                it = nums.erase( it );
            }   
            else if ( next == nums.end() ) {
                break;
            }
            else {
                ++ it;
            }
        }
        return nums.size();
    }

    /*
    解法二：使用2个数组下标i，j；i代表当前最后一个不重复元素到位置，j代表遍历到到位置；把遍历到到不重复的元素替换到位置 i 处；
    每个元素只遍历一遍，时间复杂度O(n)
    12ms 97.81%
    */
    int removeDuplicates(vector<int>& nums) {
        int i = 0 , j = -1 ;
        for ( ; i < nums.size() ; ) {
            if ( i + 1 >= nums.size() ) break;
            j = j == -1 ? i + 1 : j ;
            while ( j < nums.size() && nums[ i ] == nums[ j ] ) {
                ++ j;
            }
            //重复端结束，将第一个一个不重复到元素放置 i+1 处 , 
            if ( j < nums.size() ) {
                ++ i;
                nums [ i ] = nums [ j ++ ] ; //j 指向下一个元素
            }
            else {
                break;
            }

        }
        return  nums.size() > 0 ? i + 1 : 0 ;  //注意判定空数组情况
    }

   /*
    解法三：高赞解法：通过计算重复元素的个数来计算下标
    12ms 97.81%
    */
    int removeDuplicates(vector<int>& nums) {
        //count 代表重复的个数；
        int count = 0 ;
        for ( int i = 1 ; i < nums.size() ; ++ i ) {
            //计算重复个数
            if ( nums[ i ] == nums [ i - 1 ] ) {
                count ++ ;
            }
            else {
                //此处不易理解，不重复元素可填充的下标 = 当前下标-重复的个数；
                //含义是：前 i 个元素里有 count 个重复的元素。那么不重复元素即为 i - count 个；
                //下标从0 开始， 那么当前不重复元素的下标即为 i - count 
                nums [ i - count ] = nums [ i ] ;
            }
        }

        return n - count ;
    }    

    /*
    解法四：高赞解法：思路同解法二，只是代码更简单，时间复杂度O(n)
    12ms 97.81%
    */
    int removeDuplicates(vector<int>& nums) {
        //count 代表重复的个数；
        int i = 0 ;  // 
        for ( int n : nums ) {
            if ( i == 0 || n > nums [ i - 1 ] ) {
                nums [ i++ ] = n;
            }
        }

        return i ;
    }        
};
// @lc code=end

