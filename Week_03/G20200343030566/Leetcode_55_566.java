package com.sebar.test.leetcode.three.practice.greedy;

/**
 * @author liguang
 * @Date 2020/2/28
 * @Description 55. 跳跃游戏
 * https://leetcode-cn.com/problems/jump-game/
 */

public class Leetcode_55_566 {
    /**
     * 回溯算法计算是否能完成跳跃游戏
     *
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        if (nums == null) {
            return false;
        }

        return canJumpBackTrack(nums, 0);
    }

    /**
     * 跳跃游戏回溯算法
     * 用回溯计算每一个位置能不能到达最后位置，回溯全部路径
     *
     * @param nums 步数数组
     * @param i    起始位置
     */
    private Boolean canJumpBackTrack(int[] nums, int i) {
        // 满足条件退出
        if (i == nums.length - 1) {
            // 到达最后一个位置
            return true;
        }
        int futureJump = Math.min(i + nums[i], nums.length - 1);
        // 选择列表
        for (int i1 = i; i1 <= futureJump; i1++) {
            //做出选择
            if (canJumpBackTrack(nums, i1 + 1)) {
                return true;
            }

            // 撤回操作
        }
        return false;
    }

    /**
     * 贪心算法解决跳跃问题
     *
     * @return
     */
    public Boolean canJumpGreedy(int[] nums) {
        int lastPosition = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            // 如果最后一个位置能跳过去，则将最后满足位置前移
            if (i + nums[i] >= lastPosition) {
                lastPosition = i;
            }
        }
        return lastPosition == 0;
    }
}
