/*
 * @lc app=leetcode.cn id=88 lang=cpp
 *
 * [88] 合并两个有序数组
 *
 * https://leetcode-cn.com/problems/merge-sorted-array/description/
 *
 * algorithms
 * Easy (46.53%)
 * Likes:    417
 * Dislikes: 0
 * Total Accepted:    108.6K
 * Total Submissions: 233K
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
    void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {
       //先插入
       int a=m-1 ,b=n-1;
       int count=m+n-1;
       //再排序nums1
        while(a>=0||b>=0) {
            if(a>=0&&b>=0&&nums1[a]>=nums2[b]) {
                nums1[count--]=nums1[a--];      
                continue;      
            }
            if(a>=0&&b>=0){
                nums1[count--]=nums2[b--];
                continue;
            }
            if (a>=0) {
                 nums1[count--]=nums1[a--];
                 continue;
            }
             if (b>=0) {
                 nums1[count--]=nums2[b--];
                 continue;
            }
            
        }
        
    }
};
// @lc code=end

