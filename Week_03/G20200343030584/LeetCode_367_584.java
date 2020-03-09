package week3;

/**
 * 367. 有效的完全平方数
 * <p>
 * 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
 * <p>
 * 说明：不要使用任何内置的库函数，如  sqrt。
 * 示例 1：
 * 输入：16
 * 输出：True
 * <p>
 * https://leetcode-cn.com/problems/valid-perfect-square/submissions/
 */
public class ValidPerfectSquare {
    public static void test() {
//        int num = 15;
        int num = 808201; // true
        System.out.println("是否完全平方数：" + new ValidPerfectSquare().isPerfectSquare(num));
    }

    public boolean isPerfectSquare(int num) {
        if (num <= 1) {
            // 0、1都是完全平方数
            return true;
        }
        // 这里的坑在于，参与计算的参数不能用int，只能用long
        long start = 2;
        long end = num / 2;
        while (start <= end) {
            long mid = start + (end - start) / 2;
            long midSquareValue = mid * mid;
            if (midSquareValue == num) {
                return true;
            } else if (midSquareValue < num) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }

    public boolean isPerfectSquare2(int num) {
        if (num <= 1) {
            return true;
        }
        // 牛顿迭代法
        long x = num / 2;
        while (x * x > num) {
            x = (x + num / x) / 2;
        }
        return x * x == num;
    }
}
