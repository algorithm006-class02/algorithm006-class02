/*
 * @lc app=leetcode.cn id=45 lang=java
 *
 * [45] 跳跃游戏 II
 */

// @lc code=start
class Solution {
    public int jump(int[] nums) {
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxPosition = Math.max(maxPosition, nums[i] + i);
            if (i == end) {
                // 边界 在此题的含义就是 上一个位置跳到此时此刻位置的边界
                // 也就是说是上一个位置所能跳的最大跳跃极限值
                //所以if如果 i 到了这个最大跳跃所能到的极限位置 
                // 那么就更新这个 end 边界值 为了下一个能到最大位置做准备  
                // 如此往复 
                //                
                //                就会汇总出一个最小的跳跃次数
                //                而达到数据末尾的最终目的
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }
}
// @lc code=end

