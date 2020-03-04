package algorithm.leetCode.week03.No455;

import java.util.Arrays;

/**
 * @author ltw
 * on 2020-03-03.
 */
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        if (g == null || s == null) return 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int gi = 0, si = 0;
        while (gi < g.length && si < s.length) { //之所以不需要判断具体数字 是因为 每个小朋友只能拿一个饼干
            if (g[gi] <= s[si]) {
                gi++;
            }
            si++;
        }
        return gi;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a = {1, 2, 3};
        int[] b = {1, 1};
        System.out.println(solution.findContentChildren(a, b));
    }
}

