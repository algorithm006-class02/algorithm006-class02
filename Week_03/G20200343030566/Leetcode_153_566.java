package com.sebar.test.leetcode.three.homework;

/**
 * @author liguang
 * @Date 2020/2/28
 * @Description 153. 寻找旋转排序数组中的最小值
 * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
 */

public class Leetcode_153_566 {
    public static void main(String[] args) {
        Leetcode_153_566 code = new Leetcode_153_566();
//        int min = code.findMin2(new int[]{4, 5, 6, 7, 0, 1, 2});
        int min = code.findMin2(new int[]{2, 1});
        System.out.println(min);
    }

    /**
     * 二分查找法进行查找最小元素
     *
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        //【1,2】可以通过这种没有逆转的测试用例
        if (nums[right] > nums[left]) {
            return nums[0];
        }
        while (left < right) {
            // 最终情况落差点，即数组中只有两个元素，left最大元素和right最小元素
            if (right == left + 1) {
                return nums[right];
            }
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }

    /**
     * 寻找最小元素
     *
     * @param nums
     * @return
     */
    public int findMin2(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int left = 0;
        int right = nums.length - 1;

        // 如果是有序递增的，则第一个是最小的
        if (nums[right] > nums[left]) {
            return nums[0];
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }
            if (nums[mid - 1] > nums[mid]) {
                return nums[mid];
            }
            if (nums[mid] > nums[0]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
