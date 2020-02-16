package com.sebar.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liguang@youxin.com
 * @Date 2020/2/12
 * @Description 给定一个整数数组 nums 和一个目标值 target，
 * 请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。
 * 但是，你不能重复利用这个数组中同样的元素。
 * <p>
 * 示例:
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 */
public class Leetcode_1_566 {
    /**
     * 暴力枚举的方式
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];

        for (int i = 0; i < nums.length; i++) {
            int needNum = target - nums[i];
            for (int i1 = i + 1; i1 < nums.length; i1++) {
                if (nums[i1] == needNum) {
                    res[0] = i;
                    res[1] = i1;
                    return res;
                }
            }
        }
        return res;
    }

    public int[] solutionTwo(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> mayResMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            mayResMap.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (mayResMap.containsKey(target - nums[i]) && mayResMap.get(target - nums[i]) != i) {
                res[0] = i;
                res[1] = mayResMap.get(target - nums[i]);
                return res;
            }
        }
        return res;
    }

    /**
     * 一遍遍历hashmap
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] solutionThree(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> mayResMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int dif = target - nums[i];
            if(mayResMap.containsKey(dif)){
                return new int[]{mayResMap.get(dif),i};
            }
            mayResMap.put(nums[i], i);
        }
        return res;
    }
}
