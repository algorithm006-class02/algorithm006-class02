package week08;

import java.util.Arrays;

/**
 * 最长上升子序列
 *
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 *
 * 示例:
 *
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 *
 */
public class LeetCode_300_564 {

    public static void main(String[] args) {
        LeetCode_300_564 leetCode = new LeetCode_300_564();
        System.out.println(leetCode.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
        System.out.println(leetCode.lengthOfLIS1(new int[]{10,9,2,5,3,7,101,18}));
    }

    /**
     * 动态规划：
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(n)
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;

        int[] dp = new int[nums.length];

        Arrays.fill(dp, 1);

        int res = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                // 前面有比自己小的，就在前面的基础上+1和自己相比哪个大，自己就等于那个计数值
                if (nums[j] < nums[i]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            res = Math.max(res, dp[i]);
        }

        return res;
    }

    /**
     * 动态规划 + 二分查找
     *
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(n)
     * @param nums
     * @return
     */
    public int lengthOfLIS1(int[] nums) {
        if (nums.length == 0) return 0;
        int[] tail = new int[nums.length];
        int res = 0;
        for (int num : nums) {
            int i = 0, j = res;
            while (i < j) {
                int mid = (i + j) / 2;
                if (tail[mid] < num) i = mid + 1;
                else j = mid;
            }
            // 如果是前面的数值大于中间值，则加入到数组的末尾，要不就直接替换，后面的长度的一致的，但是值不是最优的上升序列
            tail[i] = num;

            if (res == j) res++;
        }
        return res;
    }
}
