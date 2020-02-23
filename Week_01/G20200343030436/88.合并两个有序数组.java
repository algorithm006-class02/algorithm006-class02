/*
 * @lc app=leetcode.cn id=88 lang=java
 *
 * [88] 合并两个有序数组
 */

// @lc code=start
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int mFlag = m - 1;
        int nFlag = n - 1;
        int resFlag = m + n - 1;
        while (mFlag >= 0 && nFlag >= 0) {
            if (nums1[mFlag] > nums2[nFlag])
                nums1[resFlag--] = nums1[mFlag--];
            else
                nums1[resFlag--] = nums2[nFlag--];
        }
        while (nFlag >= 0) {
            nums1[resFlag--] = nums2[nFlag--];
        }
    }
}
// @lc code=end

