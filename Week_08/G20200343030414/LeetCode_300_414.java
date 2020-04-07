package Week_08.G20200343030414;

import java.util.Arrays;

/**
 * @author Xinshuai
 * @description 题目链接：https://leetcode-cn.com/problems/longest-increasing-subsequence/
 * @since 2020-04-05 17:23
 */
public class LeetCode_300_414 {

    /**
     * 动态规划
     * <p>
     *     DP方程：dp[i] = Math.max(dp[i], dp[i - 1] + 1)（dp[i] 表示以 nums[i] 结尾的「上升子序列」的长度）
     */
    public int lengthOfLIS1(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return len;
        }
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < len; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    /**
     * 贪心算法 + 二分查找
     */
    public int lengthOfLIS2(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return len;
        }
        // tail 数组定义：长度为 i + 1 的上升子序列的末尾最小是几
        int[] tail = new int[len];
        tail[0] = nums[0];
        // end 表示有序数组 tail 的最后一个已经赋值元素的索引
        int end = 0;
        for (int i = 1; i < len; i++) {
            int left = 0;
            int right = end + 1;
            while (left < right) {
                int mid = (left + right) >>> 1;
                if (tail[mid] < nums[i]) {
                    // 中位数不是要找的数字，则把它写在分支的外边
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            tail[left] = nums[i];
            // 当前仅当更新位置在当前 end 的下一位
            if (left == end + 1) {
                end++;
            }
        }
        end++;
        return end;
    }

}
