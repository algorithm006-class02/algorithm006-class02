package com.sebar.test.leetcode.eight.pratice;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author LG-QCY
 * @Date :2020/4/5 17:36
 */
public class Leetcode_205_566 {
    /**
     * map
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Character> dict = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            if (dict.get(sc) == null) {
                if (dict.containsKey(tc)) {
                    return false;
                }
                dict.put(sc, tc);
            } else if (dict.get(sc) != tc) {
                return false;
            }
        }
        return true;
    }
}
