package com.sebar.test.leetcode.three.practice.greedy;

/**
 * @author liguang@youxin.com
 * @Date 2020/2/28
 * @Description 45. 跳跃游戏 II
 * https://leetcode-cn.com/problems/jump-game-ii/
 */

public class Leetcode_45_566 {
    /**
     * 贪心算法每一次都走最大步数，看能不能到底
     *
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        // 能跳到的最远距离
        int maxPosition = 0;
        // 步数
        int step = 0;
        // 当前能跳到的位置的边界
        int end = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            maxPosition = Math.max(maxPosition, nums[i] + i);
            if (i == end) {
                end = maxPosition;
                step++;
            }
        }
        return step;
    }
}
