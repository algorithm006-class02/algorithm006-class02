package com.ping.leetcode.utils;

/**
 * @Author: 高一平
 * @Date: 2020/3/29
 * @Description:
 **/
public class StringUtils {

    /**
     * 填充字符串
     * 前缀
     *
     * @param string 待填充字符串
     * @param str    填充内容
     * @param length 字符串需达到长度
     * @return
     */
    public static String fillStrPrefix(String string, char str, int length) {
        int num = length - string.length();
        if (num > 0) {
            return fillStrContest(str, num) + string;
        } else {
            return string;
        }
    }

    /**
     * 获取填充内容
     *
     * @param str
     * @param length
     * @return
     */
    private static String fillStrContest(char str, int length) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            builder.append(str);
        }
        return builder.toString();
    }
}
