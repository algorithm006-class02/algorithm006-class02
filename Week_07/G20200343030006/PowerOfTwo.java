package com.leetcode.base.week07;

public class PowerOfTwo {
    //思路：
    // 1、2的幂二进制表示只含有一个 1;
    //2、x & (x -1)操作会将2的幂设置为0，因此判断是否为2的幂是：判断x & (x - 1) == 0
    public boolean isPowerOfTwo(int n) {
        if (n == 0) {
            return false;
        }
        long x = (long) n;
        return (x & (x - 1)) == 0;
    }
}
