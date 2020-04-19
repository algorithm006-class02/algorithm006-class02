package com.gsf.geekbang_demo.arithmetic.leetCode.week08;

/**
 * 541. 反转字符串 II
 */
public class Demo541 {

    public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        for (int start = 0; start < len; start += 2*k) {
            reverse(arr, start, Math.min(start + k - 1, len - 1));
        }
        return new String(arr);
    }

    private void reverse(char[] arr, int i, int j) {
        while (i < j) {
            char temp = arr[i];
            arr[i++] = arr[j];
            arr[j--] = temp;
        }
    }
}
