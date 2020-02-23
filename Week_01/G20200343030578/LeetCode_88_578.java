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


class Solution88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        // 先把 nums 所有元素移到最后，记录开始位置
        for (int i = m - 1; i >= 0; i--) {
            nums1[i + n] = nums1[i];
        }

        // 再遍历比较，写入到 nums1 前半部分
        int k = 0;
        int i = 0, j = n;
        while (i < n && j < n + m) {
            if (nums1[j] < nums2[i]) {
                nums1[k++] = nums1[j++];
            } else {
                nums1[k++] = nums2[i++];
            }
        }

        // 处理 nums1 剩余元素
        while (j < n + m){
            nums1[k++] = nums1[j++];
        }

        // 处理 nums2 剩余元素
        while (i < n){
            nums1[k++] = nums2[i++];
        }

    }
}

