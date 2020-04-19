package com.gsf.geekbang_demo.arithmetic.leetCode.week07;

/**
 * 190. 颠倒二进制位
 */
public class Demo190 {

    public int reverseBits1(int n) {
        int res = 0;
        for (int i = 31; n != 0; n >>>= 1, i--) {
            res += ((n & 1) << i);
        }
        return res;
    }

    public int reverseBits2(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res = res << 1 | (n & 1);
            n >>>= 1;
        }
        return res;
    }
}
