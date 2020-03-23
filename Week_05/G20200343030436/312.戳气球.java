/*
 * @lc app=leetcode.cn id=312 lang=java
 *
 * [312] 戳气球
 */

// @lc code=start
class Solution {
    //动态规划本身就是逆向的思维


    /**
     * 【分析】区间型dp（了解更多可以看下我的博客哈），从最后一步出发，最后一步必定扎破一个气球，编号为i，这一步获得金币1* nums[i] * 1，此时i前面的气球1～i-1以及i后面的气球i+1～n都被扎破了，需要知道两边最多能获得多少个金币，再加上最后一步，就是结果。

【状态转移方程】由于最后一步是1 * nums[i] * 1，我们可以认为两端有两个不能扎破的气球，值为1，dp[i][j]代表扎破i+1号气球～j-1号气球能获得的金币数，i和j是不能被扎破的，因为是两端，并且当前气球k不能被扎破，要分别考虑k的左侧（i～k-1）和右侧（k+1～j），状态转移方程为：

dp[i][j] = max{dp[i][k] + dp[k][j] + a[i] * a[k] * a[j]},k∈(i,j)
dp[i][k]代表扎破i+1～k-1号气球，dp[k][j]代表扎破k+1～j-1号气球，再加上扎破这个气球获得的金币数
【初始条件】没有气球要扎破就获得0个金币

dp[0][1] = dp[1][2] = ... = dp[n-2][n-1] = 0

作者：jerry_nju
链接：https://leetcode-cn.com/problems/burst-balloons/solution/dong-tai-gui-hua-jie-ti-si-lu-by-sha-yu-la-jiao-2/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    public int maxCoins(int[] nums) {
        int[] newNums = new int[nums.length + 2];
        int[][] dp = new int[newNums.length][newNums.length];
        newNums[0] = 1;
        newNums[nums.length + 1] = 1;

        for (int i = 0; i < nums.length; i++) {
            newNums[i + 1] = nums[i];
        }
        //init
        for (int i = 0; i < newNums.length - 1; i++) {
            dp[i][i + 1] = 0;
        }
        for (int len = 3; len <= newNums.length; len++) {
            for (int i = 0; i <= newNums.length - len; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MIN_VALUE;
                //枚举中间的气球
                for (int k = i + 1; k <= j - 1; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + newNums[i] * newNums[k] * newNums[j]);
                }
            }
        }
        return dp[0][newNums.length - 1];
    }
}
// @lc code=end

