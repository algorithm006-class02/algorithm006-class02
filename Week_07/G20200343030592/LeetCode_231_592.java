package com.gsf.geekbang_demo.arithmetic.leetCode.week07;

/**
 * 231. 2的幂
 */
public class Demo231 {

    public boolean isPowerOfTwo1(int n) {
        if (n == 0) return false;
        while (n % 2 == 0) {
            n /= 2;
        }
        return n == 1;
    }

    public boolean isPowerOfTwo2(int n) {
        if (n == 0) return false;
        long x = (long) n;
        return (x & -x) == x;
    }

    public boolean isPowerOfTwo3(int n) {
        if (n == 0) return false;
        long x = (long) n;
        return (x & (x - 1)) == 0;
    }
}
