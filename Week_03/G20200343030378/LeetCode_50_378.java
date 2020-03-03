public class LeetCode_50_378 {
    public double myPow(double x, int n) {
        if (n == 0)
            return 1.0;
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        return helper(x, n);
    }

    private double helper(double x, int n) {
        //termination
        if (n == 0)
            return 1.0;
        //process down
        double tmp = helper(x, n / 2);

        //merge
        return n % 2 == 0 ? tmp * tmp : tmp * tmp * x;
    }
}
