package com.sebar.test.leetcode.seven.practice;

/**
 * https://leetcode-cn.com/problems/valid-anagram/
 * 242. 有效的字母异位词
 */
public class Leetcode_242_566 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        // 构建一个26个字母的技数桶
        int[] charNum = new int[26];
        for (int i = 0; i < s.length(); i++) {
            charNum[s.charAt(i) - 'a']++;
            charNum[t.charAt(i) - 'a']++;
        }
        // 检验是否有一项不等于0
        for (int i = 0; i < charNum.length; i++) {
            if (charNum[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
