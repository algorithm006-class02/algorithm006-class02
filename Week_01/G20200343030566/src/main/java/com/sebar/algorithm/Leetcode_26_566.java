package com.sebar.algorithm;

/**
 * @author liguang@youxin.com
 * @Date 2020/2/13
 * @Description
 */
public class Leetcode_26_566 {
    /**
     * 双指针
     * 一根指针不动，另外一根指针移动，每次移动一步，相同则继续移动，
     * 不同，则将数据替换当前指针位置，当前指针++
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int pointA = 0;
        int j = 1;

        for (; j < nums.length; j++) {
            if (nums[pointA] != nums[j]) {
                pointA++;
                nums[pointA] = nums[j];
            }
        }
        return pointA + 1;
    }

    /**
     * 优化
     *
     * @param nums
     * @return
     */
    public int removeDuplicatesImprove(int[] nums) {
        int pointA = 0;
        int j = 1;

        for (; j < nums.length; j++) {
            if (nums[pointA] != nums[j]) {
                // 不用每次都赋值，中间有差距的是否才需要赋值，否则不需要操作
                if (j - pointA > 1) {
                    nums[pointA + 1] = nums[j];
                }
                pointA++;
            }
        }
        return pointA + 1;
    }
}
