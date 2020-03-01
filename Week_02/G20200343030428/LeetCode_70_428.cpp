/*
 * @lc app=leetcode.cn id=70 lang=cpp
 *
 * [70] 爬楼梯
 */

// @lc code=start

class Solution {
public:
    // 1 1 2 3 5 8 13 21 ...
    // 直接for循环加判断是优化dp思想
    // 递归的话数字越大申请栈空间越多，容易栈溢出！！！
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