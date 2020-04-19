package com.sebar.test.leetcode.eight.pratice;

import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author LG-QCY
 * @Date :2020/4/5 16:40
 */
public class Leetcode_151_566 {
    // 反转字符串
    public String reverseWords(String s) {
        // remove leading spaces
        s = s.trim();
        // split by multiple spaces
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);

    }

    /**
     * 不采用工具类
     *
     * @param s
     * @return
     */
    public String reverseWords2(String s) {
        if (s == null) {
            return null;
        }
        char[] chars = s.toCharArray();
        int len = chars.length;
        // 反转这个数组
        reverseChars(chars, 0, len);
        // 翻转每一个单词
        wordReverse(chars, len);
        // 去除多余空格
        return cleanSpace(chars, len);
    }

    private String cleanSpace(char[] chars, int len) {
        int i = 0, j = 0;
        while (j < len) {
            while (j < len && chars[i] == ' ') {
                j++;
            }
            while (j < len && chars[i] != ' ') {
                chars[i++] = chars[j++];
            }
            while (j < len && chars[i] == ' ') {
                j++;
            }
            if (j < len) {
                chars[i++] = ' ';
            }
        }
        return new String(chars).substring(0, i);
    }

    /**
     * 翻转单词
     *
     * @param chars
     * @param len
     */
    private void wordReverse(char[] chars, int len) {
        int i = 0, j = 0;
        while (j < len) {
            // 找到第一个首字母
            while (i < len && chars[i] == ' ') {
                i++;
            }
            j = i;
            // 末位置
            while (j < len && chars[j] != ' ') {
                j++;
            }
            reverseChars(chars, i, j - 1);
            i = j;
        }
    }

    /**
     * 反转数组
     *
     * @param chars
     */
    private void reverseChars(char[] chars, int start, int end) {
        while (start < end) {
            // 首尾对调
            char temp = chars[start];
            chars[start++] = chars[end];
            chars[end--] = temp;
        }
    }

    public static void main(String[] args) {
        Leetcode_151_566 coco = new Leetcode_151_566();
        String the_sky_is_blue = coco.reverseWords("hello world!");
        System.out.println(the_sky_is_blue);
    }
}
