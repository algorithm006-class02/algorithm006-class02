package com.sebar.test.leetcode.eight.pratice;

/**
 * @Author LG-QCY
 * @Date :2020/4/5 17:42
 */
public class Leetcode_680_566 {
    /**
     * @param s
     * @return
     */
    public boolean validPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i)!= s.charAt(j)) {
                //
                return isParalindrome(s, i, j - 1) || isParalindrome(s, i + 1, j);
            }
        }
        return true;
    }

    private boolean isParalindrome(String s, int i, int j) {
        while (i<j){
            if (s.charAt(i++) !=s.charAt(j++)) {
                return false;
            }
        }
        return true;
    }
}
