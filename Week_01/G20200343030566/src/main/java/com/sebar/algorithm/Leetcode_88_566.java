package com.sebar.algorithm;

import java.util.Arrays;

/**
 * @author liguang@youxin.com
 * @Date 2020/2/14
 * @Description
 */
public class Leetcode_88_566 {
    /**
     * 合并两个数组，并输出有序数组
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int newArrayLength = m + n;
        if (nums1.length >= newArrayLength) {
            // 将nums2加入到nums1中
            for (int i = 0; i < n; i++) {
                nums1[m + i] = nums2[i];
            }
            Arrays.sort(nums1);

        }
    }

    /**
     * 采用双指针移动的方式进行处理
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void mergeSolution(int[] nums1, int m, int[] nums2, int n) {
        // 一号数组最后下标位置
        int i = m - 1;
        // 二号数组最后下标位置
        int j = n - 1;
        // 合并后最后一个需要交换的元素下标位置
        int last = m + n - 1;
        while (i >= 0 && j >= 0) {
            // 比较两个数组中最大的元素，将其放置于尾部，
            // 如果1号数组大于二号数组，则一号数组指针前移，如果小于，则二号数组指针移动
            if (nums1[i] > nums2[j]) {
                nums1[last--] = nums1[i--];
            } else {
                nums1[last--] = nums2[j--];
            }
        }
        // 如果二号数组有元素还没有被排入数组
        while (j >= 0) {
            nums1[last--] = nums2[j--];
        }
    }
}
