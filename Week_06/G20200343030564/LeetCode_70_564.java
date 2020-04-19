package week06;

/**
 * 爬楼梯
 *
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 *
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 *
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 *
 */
public class LeetCode_70_564 {
    public static void main(String[] args) {
        LeetCode_70_564 leetCode = new LeetCode_70_564();
        System.out.println(leetCode.climbStairs(3));
        System.out.println(leetCode.climbStairs1(3));
        System.out.println(leetCode.climbStairs2(3));
    }

    /**
     * 剪枝
     * 时间复杂度：O()
     * 空间复杂度：O(n)
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        int[] cache = new int[n + 1];

        return reverse(n, cache);


    }
    private int reverse(int n, int[] cache) {
        if (n == 1 || n == 2) return n;

        if (cache[n] != 0) return cache[n];

        cache[n] = climbStairs(n - 1) + climbStairs(n - 2);

        return cache[n];
    }


    /**
     * 动态规划
     * 时间复杂度：O(1)
     * 空间复杂度：O(n)
     *
     * @param n
     * @return
     */
    public int climbStairs1(int n) {
        if (n == 1 || n == 2) return n;

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    /**
     * 动态规划 优化
     * 时间复杂度：O(1)
     * 空间复杂度：O(1)
     *
     * @param n
     * @return
     */
    public int climbStairs2(int n) {
        if (n == 1 || n == 2) return n;

        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }
}
