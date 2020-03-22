package week03;

/**
 * 跳跃游戏 II
 *
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *
 * 示例:
 *
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 *
 */
public class LeetCode_45_564 {

    public static void main(String[] args) {
        LeetCode_45_564 leetCode = new LeetCode_45_564();
        System.out.println(leetCode.jump(new int[]{2,3,1,1,4}));
    }

    /**
     * 贪心算法：
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        int step = 0;
        int end = 0;
        int temp = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            // 找到走的最长距离
            temp = Math.max(temp, nums[i] + i);
            if (i == end) {
                end = temp;
                step++;
            }
        }
        return step;
    }
}
