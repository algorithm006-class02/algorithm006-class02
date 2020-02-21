/*
 * @lc app=leetcode.cn id=70 lang=cpp
 *
 * [70] 爬楼梯
 */

// @lc code=start

class Solution {
public:
    int climbStairs(int n) {
        if (n == 1 or n == 0) return 1;
        int first = 1;
        int second = 1;
        for (int i = 1; i < n; i++) {
            second = first + second;
            first = second - first;
        }
        return sum;
    }
};