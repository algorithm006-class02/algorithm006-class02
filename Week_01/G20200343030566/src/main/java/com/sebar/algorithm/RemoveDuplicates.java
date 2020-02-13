package com.sebar.algorithm;

/**
 * @author liguang@youxin.com
 * @Date 2020/2/13
 * @Description
 */
public class RemoveDuplicates {
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
                pointA ++;
                nums[pointA] = nums[j];
            }
        }
        return pointA + 1;
    }

}
