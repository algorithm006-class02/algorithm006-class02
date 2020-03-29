package com.ping.leetcode.easy;

import com.ping.leetcode.utils.BinaryUtils;

/**
 * @Author: 高一平
 * @Date: 2020/3/29
 * @Description: 编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。
 * <p>
 * 示例 1：
 * 输入：00000000000000000000000000001011
 * 输出：3
 * 解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
 * 示例 2：
 * 输入：00000000000000000000000010000000
 * 输出：1
 * 解释：输入的二进制串 00000000000000000000000010000000 中，共有一位为 '1'。
 * 示例 3：
 * 输入：11111111111111111111111111111101
 * 输出：31
 * 解释：输入的二进制串 11111111111111111111111111111101 中，共有 31 位为 '1'。
 * <p>
 * 提示：
 * 请注意，在某些语言（如 Java）中，没有无符号整数类型。在这种情况下，输入和输出都将被指定为有符号整数类型，并且不应影响您的实现，因为无论整数是有符号的
 * 还是无符号的，其内部的二进制表示形式都是相同的。
 * 在 Java 中，编译器使用二进制补码记法来表示有符号整数。因此，在上面的 示例 3 中，输入表示有符号整数 -3。
 * <p>
 * 进阶:
 * 如果多次调用这个函数，你将如何优化你的算法？
 **/
public class HammingWeight191 {

    public int hammingWeight(int n) {
        return hammingWeight2(n);
    }

    /**
     * 方法一：遍历数字的 32 位。如果某一位是 1 ，将计数器加一
     * 用操作码来检查数字的第 i 位是否为 1
     * 操作码初始为 1，1 的字节码为 0000 0000 0000 0000 0000 0000 0000 0001
     * 与任何数字 & 操作后，字节码为 0 的结果皆为 0，为 1 的位置，可判断该位是否为 1
     * 通过操作码的 1 不断前移，逐个判断 32 位字节码中 1 的数量
     *
     * @param n
     * @return
     */
    private int hammingWeight1(int n) {
        int result = 0;
        // 二进制长度
        int size = 32;
        // 检查指定位数是否为 1，的操作码
        int valid = 1;
        for (int i = 0; i < size; i++) {
            System.out.println(BinaryUtils.toBinary(n));
            System.out.println(BinaryUtils.toBinary(valid));
            System.out.println(BinaryUtils.toBinary(n & valid));
            System.out.println("====================================");

            if ((n & valid) != 0) {
                result++;
            }
            valid <<= 1;
        }
        return result;
    }

    /**
     * 方法二：不断把数字最后一个 1 反转，并把答案加一。当数字变成 0 的时候偶，我们就知道它没有 1 的位了，此时返回答案
     * 对于任意数字 n ，将 n 和 n − 1 做与运算，会把最后一个 1 的位变成 0
     *
     * @param n
     * @return
     */
    private int hammingWeight2(int n) {
        int result = 0;
        while (n != 0) {
            System.out.println(BinaryUtils.toBinary(n));
            System.out.println(BinaryUtils.toBinary(n - 1));
            System.out.println("====================================");

            result++;
            n &= (n - 1);
            System.out.println(BinaryUtils.toBinary(n));
        }
        return result;
    }

    public static void main(String[] args) {
        HammingWeight191 test = new HammingWeight191();
        int n = test.hammingWeight2(5);
        System.out.println(n);
    }
}
