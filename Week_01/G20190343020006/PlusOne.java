package com.leetcode.base;

public class PlusOne {
    /**
     * 题七：加一
     * 思路：数组倒序遍历，（数组元素+1）% 10 != 0 结束，否则继续遍历，特殊情况99这种，数组扩容1位。
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        for (int i = len -1; i >= 0; i++) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        digits = new int[len + 1];
        digits[0] = 1;
        return digits;
    }
}
