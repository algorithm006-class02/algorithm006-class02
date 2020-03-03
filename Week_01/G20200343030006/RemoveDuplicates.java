package com.leetcode.base;

public class RemoveDuplicates {
    /**
     * 题一：删除排序数组中的重复项
     * 快慢指针方式：前提条件数组或者链表有序，慢指针作为一个边界，快指针作为另一个边界，移动数据到慢指针边界(替换操作)
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int index = 0;
        for(int i = 1;i < nums.length ; ++i){
            if(nums[i] != nums[index]){
                nums[++index] = nums[i];
            }
        }
        return index + 1;
    }
}
