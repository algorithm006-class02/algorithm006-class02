package com.gsf.geekbang_demo.arithmetic.leetCode.week07;

/**
 * 191. 位1的个数
 */
public class Demo191 {

    public int hammingWeight1(int n) {
        int bits = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                bits ++;
            }
            mask <<= 1;
        }
        return bits;
    }

    public int hammingWeight2(int n) {
        int sum = 0;
        while (n != 0) {
            sum++;
            n &= (n - 1);
        }
        return sum;
    }
    
    public static void main(String[] args) {
        System.err.println(Integer.toBinaryString(1));
        System.err.println(11 & 1);
    }
}
