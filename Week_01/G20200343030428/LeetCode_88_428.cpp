/*
 * @lc app=leetcode.cn id=88 lang=cpp
 *
 * [88] 合并两个有序数组

 * ### 解题思路
 * 如果采用顺序解法的话，会产生位置向后偏移，这样的话每次需要拷贝nums1后面的数据
 * 所以这里倒序放数据，这样的话，就不会重复时间复杂度是O(n),遍历一次
 * ### 代码

*/
/* ----- 第一次实现
class Solution {
public:
    void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {
        for (int i = m + n - 1; i >= 0; i--) {
            if (n == 0) return;
            if (m == 0) {
                for (int i = 0 ; i < n; i++) {
                    nums1[i] = nums2[i];
                }
                return;
            }
            if (nums1[m - 1] > nums2[n - 1]) {
                nums1[m + n - 1] = nums1[m - 1];
                m--;
            }
            else {
                nums1[m + n - 1] = nums2[n - 1];
                n--;
            }
        }
    }
};
*/
// @lc code=start
class Solution {
public:
    void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {
        int i = m - 1, j = n - 1, k= m + n -1;
        while (i >=0 && j >= 0){
            if (nums1[i] >= nums2[j]) nums1[k--] = nums1[i--];
            else nums1[k--] = nums2[j--];
        }
        while (i>=0) nums1[k--] = nums1[i--];
        while (j>=0) nums1[k--] = nums2[j--];
    }
};
// @lc code=end