package com.sebar.test.leetcode.seven.practice;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/relative-sort-array/
 * 1122. 数组的相对排序
 */
public class Leetcode_1122_566 {
    /**
     * 计数排序
     * 思路，先统计arr2中每个元素在arr1中出现的次序，然后统计完成后，根据次序进行返回，再排列剩余的元素
     *
     * @param arr1
     * @param arr2
     * @return
     */
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        // 用于计数的集合
        HashMap<Integer, Integer> countMap = new HashMap<>();
        // 针对 arr1 计数
        for (int i = 0; i < arr1.length; i++) {
            Integer count = countMap.getOrDefault(arr1[i], 0);
            countMap.put(arr1[i], ++count);
        }

        int[] newArr = new int[arr1.length];
        int nowIndex = 0;
        // 循环arr2进行赋值
        for (int i = 0; i < arr2.length; i++) {
            Integer count = countMap.get(arr2[i]);
            for (Integer j = 0; j < count; j++) {
                newArr[nowIndex++] = arr2[i];
            }
            countMap.remove(arr2[i]);
        }
        // 不为空时取出所有的key进行排序
        if (!countMap.isEmpty()) {
            Set<Integer> keySet = countMap.keySet();
            keySet.stream().sorted(Comparator.reverseOrder());
            for (Integer key : keySet) {
                Integer count = countMap.get(key);
                for (Integer j = 0; j < count; j++) {
                    newArr[nowIndex++] = key;
                }
            }
        }

        return newArr;
    }

    /**
     * 维护一个map太麻烦，直接用二维数组进行记录
     * 缺点：浪费空间
     *
     * @param arr1
     * @param arr2
     * @return
     */
    public int[] relativeSortArray2(int[] arr1, int[] arr2) {
        int[] count = new int[1001];
        int[] result = new int[arr1.length];

        for (int i = 0; i < arr1.length; i++) {
            count[arr1[i]]++;
        }
        // 开始下标
        int startIndex = 0;
        for (int i = 0; i < arr2.length; i++) {
            while (count[arr2[i]] > 0) {
                result[startIndex++] = arr2[i];
                count[arr2[i]]--;
            }
        }
        // 未出现的进行排序
        for (int i = 0; i < 1001; i++) {
            while (count[i] > 0) {
                result[startIndex++] = i;
                count[i]--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Leetcode_1122_566 coco = new Leetcode_1122_566();
        int[] ints = coco.relativeSortArray(new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19}, new int[]{2, 1, 4, 3, 9, 6});
        System.out.println(ints);
    }
}
