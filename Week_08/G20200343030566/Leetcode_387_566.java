package com.sebar.test.leetcode.eight.pratice;

import java.util.LinkedHashMap;

/**
 * @Author LG-QCY
 * @Date :2020/4/5 15:49
 */
public class Leetcode_387_566 {
    /**
     * 采用额外空间记录
     * @param s
     * @return
     */
    public int firstUniqChar(String s){
        //额外空间
        LinkedHashMap<Character,Integer> dict=new LinkedHashMap<>();
        // 依次进行添加到空间中，
        for (int i = 0; i < s.toCharArray().length; i++) {
            Integer count = dict.getOrDefault(s.charAt(i), 0);
            dict.put(s.charAt(i),++count);
        }
        // 第二次循环
        for (int i = 0; i < s.toCharArray().length; i++) {
            if (dict.get( s.charAt(i))==1) {
                return i;
            }
        }
        return -1;
    }

    /**
     * solution2
     * @param s
     * @return
     */
    public int solution2(String s){
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (s.indexOf(ch) == s.lastIndexOf(ch)) {
                return i;
            }
        }
        return -1;
    }

}
