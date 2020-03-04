


/*
实现 pow(x, n) ，即计算 x 的 n 次幂函数。

示例 1:

输入: 2.00000, 10
输出: 1024.00000
示例 2:

输入: 2.10000, 3
输出: 9.26100
示例 3:

输入: 2.00000, -2
输出: 0.25000
解释: 2-2 = 1/22 = 1/4 = 0.25
说明:

-100.0 < x < 100.0
n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 */


package Week_03.G20200343030512;

//1.暴力方式解决

class Solution {
    public double myPow(double x, int n) {
        long N = n;
        if(n<0){
            x = 1/x;
            N= -N;
        }

        double res = 1;
        for(long i=0;i<N;i++){
            res = res * x;
        }

        return res;
    }
}


//2、递归处理
class Solution1 {
    public double fastpow(double x ,long n){
        if(n == 0 ){
            return 1.0;
        }
        double half = fastpow(x, n / 2);
        if(n % 2 == 0){
            return half * half;
        }else {return half * half* x;}
    }



    public double myPow(double x, int n) {
        long  N = n;
        if(n<0){
            x = 1/x;
            N= -N;
        }
        return fastpow(x,N);
    }
}