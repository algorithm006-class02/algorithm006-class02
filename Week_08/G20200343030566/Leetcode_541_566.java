package com.sebar.test.leetcode.eight.pratice;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author LG-QCY
 * @Date :2020/4/5 16:07
 */
public class Leetcode_541_566 {
    public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        for (int left = 0, step = 2 * k; left < arr.length; left += step) {
            int right = Math.min(arr.length - 1, left + k - 1);
            swap(arr, left, right);
        }
        return new String(arr);
    }

    private void swap(char[] arr, int left, int right) {
        while (left < right) {
            arr[left] ^= arr[right];
            arr[right] ^= arr[left];
            arr[left++] ^= arr[right--];
        }
    }

    public static void main(String[] args) {
        Leetcode_541_566 coco = new Leetcode_541_566();
        String reverseStr = coco.reverseStr("a", 2);
        System.out.println(reverseStr);
    }
}
