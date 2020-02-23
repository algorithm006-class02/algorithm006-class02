package com.youzi.leetcode;//给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。 
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


//leetcode submit region begin(Prohibit modification and deletion)
class MergeTwoArrays {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 循环倒叙比较，时间复杂度O(m + n)， 空间复杂度O(1)

        int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n - 1;

        // 如果n等于0，则说明num2遍历完了，剩下的num1里的元素已经是排好序的，直接退出
        while (p2 >= 0) {

            // 如果m等于0，说明num1的所有元素遍历完了，只需将num2中未遍历的复制到num1的前面即可
            if (p1 < 0) {
                System.arraycopy(nums2, 0, nums1, 0, p2);
                break;
            }

            // 倒叙比较
            nums1[p--] = (nums1[p1] > nums2[p2]) ? nums1[p1--] : nums2[p2--];
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
