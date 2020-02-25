package com.leetcode.base;

public class MoveZeroes {
    /**
     * 题六：移动零
     * 思路：与题一相似，通过快慢指针解决(交换)
     * @param nums
     */
    //1,0,1,0,1,2
    //第一遍：index=0,i=0  1,0,1,0,1,2   index++
    //第二遍：index=1,i=2  1,1,0,0,1,2   index++
    //第三遍：index=2,i=4  1,1,1,0,0,2   index++
    //第四遍：index=3,i=5  1,1,1,2,0,0
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int index = 0;//慢指针
        for (int i = 0; i < nums.length; i++) { //i快指针
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index++] = temp;
            }
        }
    }
}
