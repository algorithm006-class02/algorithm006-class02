package com.example.leetCode.Week7;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LeetCode_56_386 {
//给出一个区间的集合，请合并所有重叠的区间。
//
// 示例 1:
//
// 输入: [[1,3],[2,6],[8,10],[15,18]]
//输出: [[1,6],[8,10],[15,18]]
//解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
//
//
// 示例 2:
//
// 输入: [[1,4],[4,5]]
//输出: [[1,5]]
//解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
// Related Topics 排序 数组

    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        List<int[]> res = new ArrayList<>();
        int[] curr = intervals[0];
        res.add(curr);
        for (int[] interval : intervals) {
            if (interval[0] <= curr[1]) {
                curr[1] = Math.max(interval[1], curr[1]);
            } else {
                curr = interval;
                res.add(curr);
            }
        }
        return res.toArray(new int[res.size()][]);
    }

}
