package week7;

import java.util.*;

/**
 * 56. 合并区间
 * 给出一个区间的集合，请合并所有重叠的区间。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 * <p>
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * <p>
 * https://leetcode-cn.com/problems/merge-intervals/
 */
public class MergeIntervals {
    public static void test() {
        int[][] intervals = {{8, 10}, {1, 3}, {15, 18}, {2, 6}};
//        new MergeIntervals().merge(intervals);
        System.out.println("合并之后的区间：" + new MergeIntervals().merge(intervals));
    }

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 0) return intervals;
        List<Interval> data = new ArrayList<>(intervals.length);
        for (int[] interval : intervals) {
            data.add(new Interval(interval));
        }
        Collections.sort(data, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start > o2.start ? 1 : (o1.start == o2.start ? 0 : -1);
            }
        });
        System.out.println("data:" + data.toString());
        LinkedList<Interval> merged = new LinkedList<>();
        for (Interval interval : data) {
            if (merged.isEmpty() || merged.getLast().end < interval.start) {
                merged.add(interval);
            } else {
                Interval last = merged.getLast();
                if (last.end < interval.end)
                    last.end = interval.end;
            }
        }
        int[][] result = new int[merged.size()][2];
        for (int i = 0; i < merged.size(); i++) {
            result[i] = merged.get(i).toArray();
        }
        return result;
    }

    private static class Interval {
        int start;
        int end;

        Interval(int[] interval) {
            this.start = interval[0];
            this.end = interval[1];
        }

        int[] toArray() {
            return new int[]{this.start, this.end};
        }

        @Override
        public String toString() {
            return "[" + start + ", " + end + "]";
        }
    }
}
