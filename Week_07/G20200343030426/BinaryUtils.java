package com.ping.leetcode.utils;

/**
 * @Author: 高一平
 * @Date: 2020/3/29
 * @Description: 二进制相关方法
 **/
public class BinaryUtils {

    public static String toBinary(int n) {
        StringBuilder builder = new StringBuilder();
        if (n == 0) {
            return "0";
        }
        while (n > 0) {
            if (n % 2 == 1) {
                builder.insert(0, "1");
            } else {
                builder.insert(0, "0");
            }
            n = n / 2;
        }
        return StringUtils.fillStrPrefix(builder.toString(), '0', 32);
    }

}
