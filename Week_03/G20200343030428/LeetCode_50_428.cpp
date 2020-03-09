/*
 * @lc app=leetcode.cn id=50 lang=cpp
 *
 * [50] Pow(x, n)
 */

// @lc code=start
class Solution {
public:
    double falg = 1.0;
    double cloth = 1.0;
    double myPow(double x, int n) {
        
        if (n == 1)
            return x;
        if (n == 0)
            return 1;
        if (n == -1)
            return 1 / x;
        
        falg = myPow(x, n/2.0);
        cloth = myPow(x, n % 2);

        return falg * falg * cloth;
    }
};
// @lc code=end

