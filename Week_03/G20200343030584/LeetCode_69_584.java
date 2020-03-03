package week3;

/**
 * 69. x 的平方根
 * 实现 int sqrt(int x) 函数。
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * <p>
 * 示例 1:
 * 输入: 4
 * 输出: 2
 * <p>
 * 示例 2:
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 * 由于返回类型是整数，小数部分将被舍去。
 * <p>
 * https://leetcode-cn.com/problems/sqrtx/
 */
public class SqrtX {
    public static void test() {
//        int target = 25;
        int target = 2147395599; //
        System.out.println("平方根是：" + new SqrtX().mySqrt(target));
    }

    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        long start = 2;
        long end = x / 2;
        while (start <= end) {
            long mid = start + (end - start) / 2;
            // 注意这里的
            long midValue = mid * mid;
            if (midValue == x) {
                return (int) mid;
            } else if (midValue < x) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        System.out.println("不是完全平方数");
        return (int) end;
    }
}
