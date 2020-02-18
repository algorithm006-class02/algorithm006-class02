/*
 * @lc app=leetcode.cn id=189 lang=cpp
 *
 * [189] 旋转数组
 *
 * https://leetcode-cn.com/problems/rotate-array/description/
 *
 * algorithms
 * Easy (40.34%)
 * Likes:    482
 * Dislikes: 0
 * Total Accepted:    96.5K
 * Total Submissions: 239K
 * Testcase Example:  '[1,2,3,4,5,6,7]\n3'
 *
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * 
 * 示例 1:
 * 
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 
 * 
 * 示例 2:
 * 
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释: 
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 * 
 * 说明:
 * 
 * 
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的 原地 算法。
 * 
 * 
 */

// @lc code=start
class Solution {
public:
    /*
    解法一：从结果上看，就是数组的后K位搬到了前面。逻辑上非常简单，但效率地下，数组删除和插入都要移动元素；本次在尾部删除复杂度位O(1),在头部插入复杂度位O(n)
    最终时间复杂度为O(n)；
    8ms 82.62%
    */
    
    void rotate(vector<int>& nums, int k) {
        
        int n = nums.size() ;

        //操作后结果并未发生变化；
        k %= n ;
        if ( k == 0 ) return ;

        //后k个位置的第一个元素位置是n-k,将k个数据拷贝到最前面;
        nums.insert ( nums.begin() , nums.begin() + n - k , nums.end() ) ;

        //将最后到k个元素删除；
        nums.erase ( nums.begin() + n , nums.end() ) ;
    }
    
     /*
    解法二：思路同解法一，只是不使用拷贝，删除的做法，先开辟空间存储后k个元素，同时移动前面的n-k个元素
    空间复杂度O(k),时间复杂度O(max(n-k,k)+k)
    4ms 97.18%
    */
    void rotate(vector<int>& nums, int k) {
        int n = nums.size() ;

        //操作后结果并未发生变化；
        k %= n ;
        if ( k == 0 ) return ;    

        vector<int> tmp(k) ;
        for ( int i = n - 1 , j = n - k - 1 , pos = k - 1 ;  pos >= 0 || j >= 0 ; -- i , -- j ) {
            //从最后一个数开始，只存储后面k个数 
            if ( pos >= 0 ) {
                tmp [ pos --  ] = nums[ i ]  ; 
            }
            
            if ( j >= 0 ) {
                nums [ i ] = nums [ j ] ; //将前面的数往后挪动
            }
            
        }   

        for ( int i = 0 ; i < k ; ++ i ) {
            nums [ i ] = tmp [ i ] ;
        }

    }
     /*
    解法三：一次一次移动并计数,时间复杂度O(kn) ,数组较长时，无法AC
    */  
    void rotate(vector<int>& nums, int k) {
        
        int n = nums.size() ;

        //操作后结果并未发生变化；
        k %= n ;
        if ( k == 0 ) return ;

        for ( int i = 0 ; i < k ; ++ i ) {
            //保留最后一位数据
            int val = nums [ n-1 ] ;
            for ( int j = n-1 ; j >= 1 ; -- j ) {
                //向前移动一位
                nums[ j ] = nums[ j-1 ] ;
            }
            nums [ 0 ] = val ;
        }
    } 

    /*
    解法四：高赞答案，三次反转
    */  
    void rotate(vector<int>& nums, int k) {
        int n = nums.size() ;

        //操作后结果并未发生变化；
        k %= n ;
        if ( k == 0 ) return ;
        //reverse翻转的范围定义是[first,last)
        //翻转前面n-k个元素 [1,2,3,4,5,6,7] -> [4,3,2,1,5,6,7]
        reverse( nums , nums + n - k ) ;

        //翻转后面k个元素 [4,3,2,1,5,6,7] -> [4,3,2,1,7,6,5]
        reverse( nums + n - k , nums + n ) ; 

        //翻转整个数组
        reverse( nums , nums + n ) ;
    }

    /*
    解法五：一行代码
    */
    void rotate(vector<int>& nums, int k) {
        std::rotate( nums.rbegin(), nums.rbegin() + k%nums.size(), nums.rend() ) ;
    }
     
};
// @lc code=end

