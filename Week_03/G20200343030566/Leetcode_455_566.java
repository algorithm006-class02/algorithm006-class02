package com.sebar.test.leetcode.three.practice.greedy;

import java.util.Arrays;

/**
 * 455. 分发饼干
 * https://leetcode-cn.com/problems/assign-cookies/description/
 */
public class Leetcode_455_566 {
    /**
     * 贪心算法，先用最小的饼干喂饱胃口最小的小孩，
     * 这个解法有误，因为一个小朋友只能拥有一块饼干，这样求解会使得一个小朋友拥有多块饼干
     *
     * @param g
     * @param s
     * @return
     */
    public int findContentChildren(int[] g, int[] s) {
        int contentChildrenNum = 0;
        Arrays.sort(g);
        Arrays.sort(s);

        // 循环依次填饱小孩
        for (int i = 0; i < g.length; i++) {
            int needNum = g[i];
            for (int i1 = 0; i1 < s.length; i1++) {
                if (needNum == 0) {
                    contentChildrenNum++;
                    break;
                } else {
                    needNum = needNum - s[i1] < 0 ? 0 : needNum - s[i1];
                    // 用完了置为0
                    s[i1] = 0;
                }
            }
        }
        return contentChildrenNum;
    }

    /**
     * 一次遍历求解饼干喂养小朋友
     *
     * @param g
     * @param s
     * @return
     */
    public int findContentChildren2(int[] g, int[] s) {
        if (g == null || s == null) {
            return 0;
        }
        // paixu
        Arrays.sort(g);
        Arrays.sort(s);

        //
        int gi = 0;
        int si = 0;

        while (gi < g.length && si < s.length) {
            if (g[gi] > s[si]) {
                si++;
            } else {
                gi++;
            }
        }

        return gi;
    }

    public static void main(String[] args) {
        Leetcode_455_566 code = new Leetcode_455_566();
        int contentChildren = code.findContentChildren(new int[]{1, 2}, new int[]{1, 2, 3});
        System.out.println(contentChildren);
    }
}
