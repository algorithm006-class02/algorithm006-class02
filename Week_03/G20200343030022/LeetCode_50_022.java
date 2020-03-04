/**
 * @Description：50. Pow(x, n)
 *
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。

示例 1:

输入: 2.00000, 10
输出: 1024.00000
-100.0 < x < 100.0
n 是 32 位有符号整数，其数值范围是 [−2^31, 2^31 − 1] 。

 注意int范围 负数转过来后会超过范围
 */
public class LeetCode_50_022 {
    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        return fastPow(x,N);
    }

    public double fastPow(double x,long n){
        if(n == 0){
            return 1.0;
        }
        double half = fastPow(x,n/2);
        return n % 2 == 0 ? half * half : half * half * x;
    }
}
