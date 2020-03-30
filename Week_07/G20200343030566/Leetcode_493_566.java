package com.sebar.test.leetcode.seven.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/reverse-pairs/
 * 493. 翻转对
 */
public class Leetcode_493_566 {
    public int retNum = 0;

    public int reversePairs(int[] nums) {
        merge(nums, 0, nums.length - 1, new int[nums.length]);
        return retNum;
    }

    private void merge(int[] nums, int start, int end, int[] tNums) {
        if (start >= end) {
            return;
        }
        merge(nums, start, (start + end) >> 1, tNums);
        merge(nums, (start + end) >> 1 + 1, end, tNums);
        mergeSort(nums, start, end, tNums);
    }

    private void mergeSort(int[] nums, int start, int end, int[] tNums) {
        int index = 0;
        int middle = (start + end) >> 1;
        int front = start, back = middle + 1;
        int tFront = front, tBack = back;

        while (tFront <= middle && tBack <= end) {
            if ((long) nums[tFront] > 2 * (long) nums[tBack]) {
                retNum = (middle - tFront) + 1;
                tBack += 1;
            } else {
                tFront += 1;
            }
        }

        while (tFront <= middle && back <= end) {
            if (nums[front] <= nums[back]) {
                tNums[index++] = nums[front++];
            } else {
                tNums[index++] = nums[back++];
            }
        }
        while (front <= middle) {
            tNums[index++] = nums[front++];
        }
        while (back <= end) {
            tNums[index++] = nums[back++];
        }
        for (int i = 0; i <= end - start; i++) {
            nums[start + i] = tNums[i];
        }
    }

    /**
     * 第二种解法
     * 暴力求解，先进行两个两个元素的分组，分完组再进行挑选
     * 缺陷 ：复杂度O(n^2)
     *
     * @param nums
     * @return
     */
    public int reversePairs2(int[] nums) {

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] <= nums[j]) {
                    continue;
                }
                if ((long) nums[i] > 2 * (long) nums[j]) {
                    retNum++;
                }
            }
        }
        return retNum;
    }
}
