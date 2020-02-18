package com.ping.leetcode.easy;

/**
 * @Author: 高一平
 * @Date: 2020/1/7
 * @Description: 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 示例:
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * <p>
 * 说明:
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 **/
public class MoveZeroes283 {

    public static void moveZeroes1(int[] nums) {
        // 1.定义第一个0的位置zeroIndex，初始值为0
        int zeroIndex = -1;
        // 2.遍历数组，获取第一个0的位置
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroIndex = i;
                break;
            }
        }
        // 3.将第一个0后面的非0数字交换，且zeroIndex+1，如遇数字0，直接+1
        if (zeroIndex != -1) {
            int start = zeroIndex + 1;
            for (int i = start; i < nums.length; i++) {
                if (nums[i] != 0) {
                    nums[zeroIndex] = nums[i];
                    nums[i] = 0;
                    zeroIndex += 1;
                }
            }
        }
    }

    public static void moveZeroes2(int[] nums) {
        int j = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                if (i != j) {
                    nums[i] = 0;
                }
                j++;
            }
        }
    }

}
