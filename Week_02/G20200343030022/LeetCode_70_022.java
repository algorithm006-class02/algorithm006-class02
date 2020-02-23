/**
 * @Date ：Created in 15:00 2020/2/21
 * @Description：
 *
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。

每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

注意：给定 n 是一个正整数。

示例 1：

输入： 2
输出： 2
解释： 有两种方法可以爬到楼顶。
1.  1 阶 + 1 阶
2.  2 阶
 */
public class LeetCode_70_022 {

    public int climbStairs(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int l0 = 1;
        int l1 = 1;
        int res = 0;
        for(int i = 2;i <= n;i++) {
            res = l0+l1;
            l0 = l1;
            l1 = res;
        }
        return res;
    }
}
