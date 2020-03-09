package com.sebar.test.leetcode.three.homework;

/**
 * @author liguang
 * @Date 2020/2/28
 * @Description 33. 搜索旋转排序数组
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 */

public class Leetcode_33_566 {
    public static void main(String[] args) {
        Leetcode_33_566 code = new Leetcode_33_566();
//        int search = code.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0);
        int search = code.search2(new int[]{3, 1}, 1);
//        int search = code.search2(new int[]{4, 5, 6, 7, 8, 9, 0, 1, 2}, 0);
        System.out.println(search);
    }

    /**
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        // 左下标
        int left = 0;
        // 右下标
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // 需要判断一波截断的位置，左边升序
            if (nums[left] <= nums[mid]) {
                if (target >= nums[left] && target <= nums[mid]) {
                    // 在左边范围内
                    right = mid - 1;
                } else {
                    // 只能从右边找
                    left = mid + 1;
                }
            } else {
                // 右边升序
                if (target >= nums[mid] && target <= nums[right]) {
                    // 只能从右边找
                    left = mid + 1;
                } else {
                    // 在左边范围内
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    /**
     * 关于判定逻辑进行修缮
     *
     * @param nums
     * @param target
     * @return
     */
    public int search2(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // 断定target所在的位置
            if ((nums[mid] - nums[right]) * (target - nums[right]) > 0) {
                if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            } else if (target > nums[left]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
//        if (nums[left] == target) {
//            return left;
//        }
        return -1;
    }
}
