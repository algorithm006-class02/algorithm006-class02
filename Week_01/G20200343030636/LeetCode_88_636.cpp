/*
 * @lc app=leetcode.cn id=88 lang=cpp
 *
 * [88] 合并两个有序数组
 *
 * https://leetcode-cn.com/problems/merge-sorted-array/description/
 *
 * algorithms
 * Easy (46.52%)
 * Likes:    412
 * Dislikes: 0
 * Total Accepted:    107.3K
 * Total Submissions: 230.6K
 * Testcase Example:  '[1,2,3,0,0,0]\n3\n[2,5,6]\n3'
 *
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * 
 * 说明:
 * 
 * 
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 
 * 
 * 示例:
 * 
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * 
 * 输出: [1,2,2,3,5,6]
 * 
 */

// @lc code=start
class Solution {
public:
    /*
    解法一：开辟空间，先逐个从头比较，存储合并结果之后再复制会nums1；时间复杂度O(m+n)
    4ms 87.84%
    */
     void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {
        //边界条件判断
        if ( n == 0 ) return ;
        //可以直接合并
        if ( m > 0 && nums1[m-1] <= nums2[0] ) {       
            for ( int i = 0 ; i < n ; ) {
                nums1[ m++ ] = nums2 [ i++ ] ;
            } 
            return ;            
        }

        //时间换空间
        vector<int> nums;
    
        int i = 0 , j = 0 , pos = 0 ;
        
        for ( ; i < m && j < n ;  ) {
            if ( nums1[ i ] <= nums2[ j ]) {
                nums.emplace_back ( nums1 [ i++ ] );
            }
            else {
                nums.emplace_back ( nums2 [ j++ ] );
            }
        }
        
        while ( i < m ) {
            nums.emplace_back ( nums1[ i++ ] ) ; 
        }

        while ( j < n ) {
            nums.emplace_back ( nums2[ j++ ] );
        }
        
        for ( pos = 0 ; pos < nums.size() ; ++ pos ) {
            nums1[ pos ] = nums[ pos ] ;
        }
    } 

    /*
    解法二：最终的元素个数是m+n个，从数组尾部开始比较，将最大的数从尾部开始填充；
    时间复杂度为O(m+n)
    4ms 87.84%
    */
    void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {
        int i = m -1 ;
        int j = n - 1;
        int pos = m + n - 1 ;
        while ( i >= 0 && j >= 0 ) 
        {
            if ( nums1[ i ] > nums2 [ j ]) {
                nums1 [ pos -- ] = nums1 [ i -- ] ;
            }
            else {
                nums1 [ pos -- ] = nums2 [ j -- ] ;
            }
        }
        /*
            若j < 0 说明nums2的数据已经填充完毕了，合并完成
        */
        while ( j >= 0 ) {
            nums1 [ pos -- ] = nums2 [ j -- ] ;
        }
    }
};
// @lc code=end

