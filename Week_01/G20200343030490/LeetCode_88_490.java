/**
 * @author:
 * @Date: 2020-02-14 18:08
 * @Copyright: 2019 www.lenovo.com Inc. All rights reserved.
 */

//给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
//
// 说明:
//
//
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
// 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
//
//
// 示例:
//
// 输入:
//nums1 = [1,2,3,0,0,0], m = 3
//nums2 = [2,5,6],       n = 3
//
//输出: [1,2,2,3,5,6]
// Related Topics 数组 双指针

public class LeetCode_88_490 {
    /**
     * 逆向思维，因为nums1.length >= nums1.length + nums2.length;所以可以从末尾 从大到小排序
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n - 1;
        while( p1 >= 0 && p2 >= 0 ) {
            nums1[p--] = nums1[p1] < nums2[p2] ? nums2[p2--] : nums1[p1--];
        }
        //p1等于0 直接结束
        for(int i = 0 ; i < p2 + 1 ;i++) {
            nums1[i] = nums2[i];
        }
    }
}
