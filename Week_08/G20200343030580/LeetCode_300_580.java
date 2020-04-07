class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int max = 0;
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int dpmax = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[j] + 1 > dpmax) {
                        dp[i] = dp[j] + 1;
                        dpmax = dp[i];
                    }
                }
            }
            if (dpmax > max) {
                max = dpmax;
            }
        }
        return max + 1;
    }
}