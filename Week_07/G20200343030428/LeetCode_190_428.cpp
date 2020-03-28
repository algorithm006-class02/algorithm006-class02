/*
 * @lc app=leetcode.cn id=190 lang=cpp
 *
 * [190] 颠倒二进制位
 */

// @lc code=start
class Solution {
public:
    uint32_t reverseBits(uint32_t n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result = result << 1;
            if (n & 1) {
                result = result | 1;
            }
            n = n >> 1;
        }
        return result;
    }
};
// @lc code=end

