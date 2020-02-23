package com.gsf.geekbang_demo.arithmetic.week01;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
 */
public class Work01 {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (map.get(target - nums[i]) != null) {
                result[0] = map.get(target - nums[i]);
                result[1] = i;
                break;
            }
            map.put(nums[i], i);
        }
        return result;
    }
}
