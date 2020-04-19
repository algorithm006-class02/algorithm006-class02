package com.sebar.test.leetcode.eight.pratice;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author LG-QCY
 * @Date :2020/4/5 17:25
 */
public class Leetcode_557_566 {
    /**
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        if (s == null) {
            return null;
        }
        //
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        String returnStr = "";
        for (int i = 0; i < wordList.size(); i++) {
            //reverse
            String newStr = reverseChars(wordList.get(i).toCharArray(), 0, wordList.get(i).length()-1);
            returnStr += newStr;
            if (i != wordList.size() - 1) {
                returnStr += " ";
            }
        }
        return returnStr;
    }

    /**
     * 反转数组
     *
     * @param chars
     */
    private String reverseChars(char[] chars, int start, int end) {
        while (start < end) {
            // 首尾对调
            char temp = chars[start];
            chars[start++] = chars[end];
            chars[end--] = temp;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        Leetcode_557_566 coco=new Leetcode_557_566();
        String s = coco.reverseWords("Let's take LeetCode contest");
        System.out.println(s);
    }
}
