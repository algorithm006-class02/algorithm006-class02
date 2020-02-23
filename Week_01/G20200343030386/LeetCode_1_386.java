package com.example.leetCode.week1;

import java.util.HashMap;

public class LeetCode_1_386 {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = target - nums[i];
            if (map.containsKey(num)) {
                return new int[]{map.get(num), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }

}
