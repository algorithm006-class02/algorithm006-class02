class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int[][] tmp = new int[intervals.length][2];
        int count = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (count == 0) {
                tmp[count++] = intervals[i];
            } else {
                if (intervals[i][1] <= tmp[count - 1][1]) {
                    continue;
                } else if (intervals[i][0] <= tmp[count - 1][1]) {
                    tmp[count - 1][1] = intervals[i][1];
                } else {
                    tmp[count++] = intervals[i];
                }
            }
        }
        int[][] result = new int[count][2];
        System.arraycopy(tmp, 0, result, 0, count);
        return result;
    }
}
