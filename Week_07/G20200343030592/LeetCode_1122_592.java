package com.gsf.geekbang_demo.arithmetic.leetCode.week07;

import java.util.Arrays;

/**
 * 1122. 数组的相对排序
 */
public class Demo1122 {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int k = 0;
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr1.length; j++) {
                if (arr1[j] == arr2[i]) {
                    int temp = arr1[k]; arr1[k++] = arr1[j]; arr1[j] = temp;
                }
            }
        }
        if (k != arr1.length - 1) {
            insertionSort(arr1, k);
        }
        return arr1;
    }

    private void insertionSort(int[] arr1, int k) {
        for (int i = k + 1; i < arr1.length; i++) {
            int value = arr1[i];
            int j = i - 1;
            for (; j >= k; j--) {
                if (arr1[j] > value) {
                    arr1[j + 1] = arr1[j];
                } else {
                    break;
                }
            }
            arr1[j + 1] = value;
        }
    }

    public static void main(String[] args) {
        System.err.println(Arrays.toString(new Demo1122().relativeSortArray(new int[]{26,21,11,20,50,34,1,18}, new int[]{21,11,26,20})));
    }
}
