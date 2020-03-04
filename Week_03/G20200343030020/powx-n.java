// method 1 暴力
class Solution {
    public double myPow(double x, int n) {
        long N = n;
        if (n < 0) { //N为负数的时候
            x = 1 / x;
            N = -N;
        }
        double ans = 1;
        for (long i = 0; i < N; i++)
            ans = ans * i;
        return ans;
    }
}

//method 2 分治
class Solution {
    public double myPow(double x, int n) {
        long N = n;
        if (n < 0) {
            x = 1 / x;
            N = -N;
        }
        return pow(x, N);
    }

    private double pow(double x, double n) {
        if (n == 0) {
            return 1.0;
        }
        double sub = pow(x, n / 2);
        if (n % 2 == 0) return sub * sub;
        else return sub * sub * x;
    }
}

class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        return myPow(n % 2 == 0) ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2)
    }
}