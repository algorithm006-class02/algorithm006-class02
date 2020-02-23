package com.ping.leetcode.easy;

import java.util.*;

/**
 * @Author: 高一平
 * @Date: 2020/1/29
 * @Description: 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * <p>
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * <p>
 * 分析
 * 看了题解我很疑惑，没有考虑有多组题解存在的可能
 * 我未注意不能重复利用这个数组中同样的元素，代码中没有对此做相关操作，依然被通过了...
 * <p>
 * 解惑
 * 只需要返回一组结果即可
 **/
public class TwoSum1 {

    /**
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

    /**
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            Integer index = map.get(target - nums[i]);
            if (index != null) {
                if (i != index) {
                    return new int[]{i, index};
                }
            }
        }
        return new int[]{};
    }

    /**
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            Integer index = map.get(target - nums[i]);
            if (index != null) {
                if (i != index) {
                    return new int[]{i, index};
                }
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}
