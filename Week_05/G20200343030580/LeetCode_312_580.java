class Solution {
    public int maxCoins(int[] nums) {
        int[] ext = new int[nums.length + 2];
        ext[0] = 1;
        ext[ext.length - 1] = 1;
        System.arraycopy(nums, 0, ext, 1, nums.length);
        int[][] dp = new int[ext.length][ext.length];
        for (int i = ext.length - 3; i > -1; i--) {
            for (int j = i + 2; j < ext.length; j++) {
                int max = 0;
                for (int k = i + 1; k < j; k++) {
                    max = Math.max(dp[i][k] + dp[k][j] + ext[i] * ext[k] * ext[j], max);
                }
                dp[i][j] = max;
            }
        }
        return dp[0][ext.length - 1];
    }
}
