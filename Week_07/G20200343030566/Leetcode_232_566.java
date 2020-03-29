package com.sebar.test.leetcode.seven.practice;

/**
 * https://leetcode-cn.com/problems/power-of-two/
 * 231.2的幂
 */
public class Leetcode_232_566 {

    public boolean isPowerOfTwo(int n) {
        if (n == 0) {
            return false;
        }
        long x = (long) n;
        return (x & (x - 1)) == 0;
    }
}
