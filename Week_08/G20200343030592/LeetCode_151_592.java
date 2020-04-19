package com.gsf.geekbang_demo.arithmetic.leetCode.week08;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 151. 翻转字符串里的单词
 */
public class Demo151 {

    public String reverseWords(String s) {
        s = s.trim();
        List<String> list = Arrays.asList(s.split(" +"));
        Collections.reverse(list);
        return String.join(" ", list);
    }
}
