package com.gsf.geekbang_demo.arithmetic.leetCode.week08;

/**
 * 387. 字符串中的第一个唯一字符
 */
public class Demo387 {

    //数组
    public int firstUniqCharArr(String s) {
        int[] arr = new int[26];
        for (char ch : s.toCharArray()) {
            arr[ch - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (arr[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    //自带的api
    public int firstUniqCharAPI1(String s) {
        for (int i = 0; i < s.length(); i++) {
            int start = s.indexOf(s.charAt(i));
            int end = s.lastIndexOf(s.charAt(i));
            if (start == end) {
                return i;
            }
        }
        return -1;
    }

    public int firstUniqCharAPI2(String s) {
        int n = s.length();
        for (int i = 'a'; i <= 'z'; i++) {
            int start = s.indexOf(i);
            int end = s.lastIndexOf(i);
            if (start != -1 && start == end) {
                n = Math.min(start, n);
            }
        }
        if (n != s.length()) return n;
        return -1;
    }
}
