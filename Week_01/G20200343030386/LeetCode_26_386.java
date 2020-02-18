package com.example.leetCode.week1;

public class LeetCode_26_386 {

    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (i == 0 || nums[j] > nums[j - 1]) {
                nums[i++] = nums[j];
            }
        }
        return i;
    }

}
