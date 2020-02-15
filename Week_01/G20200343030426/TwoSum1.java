package com.ping.leetcode.easy;

import java.util.*;
import java.util.stream.IntStream;

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
 **/
public class TwoSum1 {

    /**
     * 此代码已通过，但有一点需要注意
     * 我未注意不能重复利用这个数组中同样的元素，代码中没有对此做相关操作，依然被通过了...
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum1(int[] nums, int target) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    list.add(i);
                    list.add(j);
                }
            }
        }

        int[] result = new int[list.size()];
        IntStream.range(0, result.length).forEach(i -> result[i] = list.get(i));
        return result;
    }

    /**
     * 考虑不能重复利用这个数组中同样的元素
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    set.add(i);
                    set.add(j);
                }
            }
        }

        int[] result = new int[set.size()];
        Iterator<Integer> iterator = set.iterator();
        IntStream.range(0, result.length).forEach(i -> result[i] = iterator.next());
        return result;
    }
}
