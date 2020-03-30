package com.sebar.test.leetcode.seven.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/merge-intervals/
 * 56. 合并区间
 */
public class Leetcode_56_566 {

    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }

        // 根据起始元素进行排序
        Arrays.sort(intervals, (arr1, arr2) -> Integer.compare(arr1[0], arr2[0]));
        // 构建临时数组
        int[] temp = intervals[0];
        List<int[]> res = new ArrayList<>();
        res.add(temp);

        for (int[] interval : intervals) {
            int begin = temp[0];
            int end = temp[1];

            int nextBegin = interval[0];
            int nextEnd = interval[1];

            // 合并
            if (end >= nextBegin) {
                temp[1] = Math.max(end, nextEnd);
            } else {
                // 没有交集，则循环下一个
                temp = interval;
                res.add(temp);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
