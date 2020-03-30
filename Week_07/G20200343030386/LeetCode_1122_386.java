package com.example.leetCode.Week7;


public class LeetCode_1122_386 {
//给你两个数组，arr1 和 arr2，
//
//
// arr2 中的元素各不相同
// arr2 中的每个元素都出现在 arr1 中
//
//
// 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末
//尾。
//
//
//
// 示例：
//
// 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
//输出：[2,2,2,1,4,3,3,9,6,7,19]
//
//
//
//
// 提示：
//
//
// arr1.length, arr2.length <= 1000
// 0 <= arr1[i], arr2[i] <= 1000
// arr2 中的元素 arr2[i] 各不相同
// arr2 中的每个元素 arr2[i] 都出现在 arr1 中
//
// Related Topics 排序 数组

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] tong = new int[1001];
        for (int arr : arr1) {
            tong[arr]++;
        }
        int n = 0;
        int[] res = new int[arr1.length];
        for (int arr : arr2) {
            for (int i = 0; i < tong[arr]; i++) {
                res[n++] = arr;
            }
            tong[arr] = 0;
        }
        for (int i = 0; i < tong.length; i++) {
            if (tong[i] != 0) {
                for (int j = 0; j < tong[i]; j++) {
                    res[n++] = i;
                }
            }
        }
        return res;
    }

}
