package com.gsf.geekbang_demo.arithmetic.leetCode.week03;

import java.util.Arrays;

/**
 * 455. 分发饼干
 */
public class Demo455 {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int gi = 0, si = 0;
        while (gi < g.length && si < s.length) {
            //当一块饼干s大于等于一个孩子的胃口g时，孩子加一
            if (g[gi] <= s[si]) gi++;
            si++;
        }
        return gi;
    }

}
