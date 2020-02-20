package com.sebar.algorithm;

/**
 * @author liguang@youxin.com
 * @Date 2020/2/14
 * @Description
 */
public class Leetcode_189_566 {
    /**
     * 思路：
     * 1.先用指针从最后一个位置开始移动，
     * 2.旋转结束后，先遍历指针+1到数组底部的元素加入到新数组
     * 再遍历0-指针下标位置的元素加入到数组位置中
     * 3.将新数组的元素赋值给原先数组
     *
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        int lastPoint = nums.length - 1;
        for (int i = 0; i < k; i++) {
            if (lastPoint == 0) {
                lastPoint = nums.length - 1;
            } else {
                lastPoint--;
            }
        }
        int[] newArray = new int[nums.length];
        for (int j = 0; j < nums.length - lastPoint - 1; j++) {
            newArray[j] = nums[j + lastPoint + 1];
        }
        for (int j = 0; j <= lastPoint; j++) {
            newArray[nums.length - 1 - lastPoint + j] = nums[j];
        }
        for (int i = 0; i < newArray.length; i++) {
            nums[i] = newArray[i];
        }
    }

    /**
     * @param nums
     * @param k
     */
    public void solutionTwo(int[] nums, int k) {
        int[] a = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int i1 = (i + k) % nums.length;
            a[i1] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = a[i];
        }
    }

    public void solutionThree(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    /**
     * 对调反转
     *
     * @param nums
     * @param start
     * @param end
     */
    private void reverse(int[] nums, int start, int end) {
        int temp;
        while (start < end) {
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
