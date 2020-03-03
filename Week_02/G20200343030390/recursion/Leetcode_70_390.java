/**
 *
 * 70.爬楼梯（简单）
 *
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
 *
 *
 *
 * 思路（精简）：
 *
 * 1.斐波那契数
 * 第n个台阶= 第n-1台阶的方法 + 第n-2个台阶的方法
 * 时间复杂度：O(n)，单循环到 n，需要计算第 n 个斐波那契数。
 * 空间复杂度：O(1)，使用常量级空间
 *
 * 2.动态规划
 * 数组
 *
 * 时间复杂度：O(n)，单循环到 n 。
 * 空间复杂度：O(n)，dp 数组用了n 的空间。
 *
 *
 */
public class Leetcode_70_390 {

    /**
     * 1.斐波那契数
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if(n == 0) {
            return 0;
        }
        if(n == 1) {
            return 1;
        }
        if(n == 2) {
            return 2;
        }
        int a = 1;
        int b = 2;
        int c = 0;
        for(int i = 3; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    /**
     * 2.动态规划
     * @param n
     * @return
     */
    public int climbStairsTwo(int n) {
        if(n == 0) {
            return 0;
        }
        if(n == 1) {
            return 1;
        }
        if(n == 2) {
            return 2;
        }
        int[] a = new int[n+1];
        a[0] = 0;
        a[1] = 2;
        a[2] = 2;
        for(int i = 3; i <= n; i++) {
            a[i] = a[i - 1] + a[i - 2];
        }
        return a[n];
    }

}
