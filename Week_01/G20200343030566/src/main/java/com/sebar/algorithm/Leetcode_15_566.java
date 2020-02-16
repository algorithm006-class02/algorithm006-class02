package com.sebar.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liguang@youxin.com
 * @Date 2020/2/12
 * @Description 给定一个包含 n 个整数的数组 nums，判断 nums 中
 * 是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？
 * 找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 */
public class Leetcode_15_566 {
    public List<List<Integer>> solutionOne(int[] nums) {
        List<List<Integer>> resList = new ArrayList<List<Integer>>();
        // 少于三个直接返回空
        if (nums.length < 3) {
            return resList;
        }

        // 先将当前数据进行数据排序，这样可以避免重复
        Arrays.sort(nums);

        // 双指针法进行数据求解，第一个指针ha等于当前循环1+1,
        // 第二个指针la等于最后一个元素，
        // 如果三个数字相加大于0，则 la后退一位，如果三个数字相加小于0，则ha前进一位
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                // 相同元素则进行跳过
                continue;
            }
            int target = 0 - nums[i];
            int ha = i + 1;
            int la = nums.length - 1;

            while (ha < la) {
                // 比目标值大
                if (nums[ha] + nums[la] > target) {
                    la--;
                }
                // 比目标值小
                else if (nums[ha] + nums[la] < target) {
                    ha++;
                }
                // 相等
                else {
                    // 记录到数组中去
                    resList.add(Arrays.asList(nums[i], nums[ha], nums[la]));
                    ha++;
                    la--;
                    // 移动两个指针
                    while (ha < la && nums[ha] == nums[ha - 1]) {
                        ha++;
                    }
                    while (ha < la && nums[la] == nums[la + 1]) {
                        la--;
                    }
                }
            }


        }
        return resList;
    }

}
