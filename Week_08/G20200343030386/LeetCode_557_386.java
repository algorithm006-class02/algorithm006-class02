package com.example.leetCode.Week8;


public class LeetCode_557_386 {
//给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
//
// 示例 1:
//
//
//输入: "Let's take LeetCode contest"
//输出: "s'teL ekat edoCteeL tsetnoc" 
//
//
// 注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
// Related Topics 字符串

    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int i = 0, j = 0;
        while (j < chars.length) {
            while (i < chars.length && chars[i] == ' ') {
                i++;
            }
            while (j < chars.length && chars[j] != ' ') {
                j++;
            }
            reverse(chars, i, j - 1);
            i = j;
            j++;
        }
        return new String(chars);
    }

    private void reverse(char[] arr, int start, int end) {
        if (arr.length == 0) {
            return;
        }
        while (start < end) {
            char tmp = arr[start];
            arr[start++] = arr[end];
            arr[end--] = tmp;
        }
    }

}
