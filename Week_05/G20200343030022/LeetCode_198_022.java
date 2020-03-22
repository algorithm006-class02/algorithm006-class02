/**
 * @Description：198. 打家劫舍
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 */
public class LeetCode_198_022 {
    /**
     * 分解子问题
     * 状态定义 a[i] 0...i 能偷到 max value : a[n-1]
     * DP方程
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int n = nums.length;
        int[][] a = new int[n][2];

        a[0][0] = 0;
        a[0][1] = nums[0];

        for(int i = 1;i < n;i++){
            a[i][0] = Math.max(a[i-1][0],a[i-1][1]);
            a[i][1] = a[i-1][0] + nums[i];
        }
        return Math.max(a[n-1][0],a[n-1][1]);
    }

    /**
     * 状态方程：a[i] 0..i天且nums[i]必偷的最大值
     * DP方程
     * a[i] = Max(a[i-1], a[i-2] + nums[i])
     */
    public int rob2(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        if(nums.length == 1)
            return nums[0];
        int n = nums.length;
        int[] a = new int[n];

        a[0] = nums[0];
        a[1] = Math.max(nums[0], nums[1]);
        int res = Math.max(a[0], a[1]);
        for(int i = 2; i < n; i++){
            a[i] = Math.max(a[i-1], a[i-2] + nums[i]);
            res = Math.max(res,a[i]);
        }
        return res;
    }
}
