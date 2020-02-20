package com.leetcode.base;

public class Merge {
    /**
     * 题四：合并两个有序数组
     * 思路：双指针方法，指针从前往后或者从后往前。根据本题情景，nums1后面元素需要填充，直接选用从后往前比较的方式更好。
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n - 1;
        while(p1 >= 0 && p2 >= 0){
            nums1[p--] = nums1[p1] < nums2[p2] ? nums2[p2--] : nums1[p1--];
        }
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }
}
