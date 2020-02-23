package com.leetcode.base;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    /**
     * 题五：两数之和
     * 思路：通过空间换时间升维的方式，将暴力双层循环拆解为遍历单遍哈希表的方式解决，时间复杂度由O(n^2)降为O(n)。
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int result = target - nums[i];
            if (map.containsKey(result)) {
                return new int[]{map.get(result), i};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
