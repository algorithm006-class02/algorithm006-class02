/**
 * @author : Hyuk
 * @description : LeetCode_53_536
 * @date : 2020/3/14 7:42 下午
 */
public class LeetCode_53_536 {

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) { return 0; }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = nums[0];
        for (int i = 1, len = nums.length; i < len; ++i) {
            dp[i] = dp[i - 1] < 0 ? nums[i] : dp[i - 1] + nums[i];
            if (dp[i] > res) { res = dp[i]; }
        }
        return res;
    }
}
