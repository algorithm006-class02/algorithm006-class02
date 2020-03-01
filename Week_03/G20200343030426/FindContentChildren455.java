package com.ping.leetcode.easy;

import java.util.Arrays;

/**
 * @Author: 高一平
 * @Date: 2020/3/1
 * @Description: 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。
 * 对每个孩子 i ，都有一个胃口值 gi ，这是能让孩子们满足胃口的饼干的最小尺寸；
 * 并且每块饼干 j ，都有一个尺寸 sj 。
 * 如果 sj >= gi ，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。
 * 你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
 * <p>
 * 注意：
 * 你可以假设胃口值为正。
 * 一个小朋友最多只能拥有一块饼干。
 * <p>
 * 示例 1:
 * 输入: [1,2,3], [1,1]
 * 输出: 1
 * 解释:
 * 你有三个孩子和两块小饼干，3个孩子的胃口值分别是：1,2,3。
 * 虽然你有两块小饼干，由于他们的尺寸都是1，你只能让胃口值是1的孩子满足。
 * 所以你应该输出1。
 * 示例 2:
 * 输入: [1,2], [1,2,3]
 * 输出: 2
 * 解释:
 * 你有两个孩子和三块小饼干，2个孩子的胃口值分别是1,2。
 * 你拥有的饼干数量和尺寸都足以让所有孩子满足。
 * 所以你应该输出2.
 **/
public class FindContentChildren455 {

    /**
     * @param g 胃口
     * @param s 饼干
     * @return
     */
    public int findContentChildren1(int[] g, int[] s) {
        int result = 0;
        if (g != null && g.length > 0 && s != null && s.length > 0) {
            Arrays.sort(g);
            Arrays.sort(s);
            if (g[0] > s[s.length - 1]) {
                // 如果不能满足胃口最小的孩子，直接返回0
                return 0;
            } else {
                int si = 0;
                for (int i = 0; i < g.length; i++) {
                    if (si < s.length) {
                        for (int j = si; j < s.length; j++) {
                            if (s[j] >= g[i]) {
                                result++;
                                si = j + 1;
                                break;
                            } else if (j == s.length-1){
                                return result;
                            }
                        }
                    } else {
                        break;
                    }
                }
            }
        }
        return result;
    }

    /**
     * @param g 胃口
     * @param s 饼干
     * @return
     */
    public int findContentChildren2(int[] g, int[] s) {
        int result = 0;
        if (g != null && g.length > 0 && s != null && s.length > 0) {
            Arrays.sort(g);
            Arrays.sort(s);
            if (g[0] > s[s.length - 1]) {
                // 如果不能满足胃口最小的孩子，直接返回0
                return 0;
            } else {
                int si = 0;
                for (int i = 0; i < g.length; i++) {
                    if (si < s.length) {
                        for (int j = si; j < s.length; j++) {
                            if (s[j] >= g[i]) {
                                result++;
                                si = j + 1;
                                break;
                            } else if (j == s.length-1){
                                return result;
                            }
                        }
                    } else {
                        break;
                    }
                }
            }
        }
        return result;
    }

    /**
     * @param g 胃口
     * @param s 饼干
     * @return
     */
    public int findContentChildren3(int[] g, int[] s) {
        int result = 0;
        if (g != null && g.length > 0 && s != null && s.length > 0) {
            Arrays.sort(g);
            Arrays.sort(s);
            if (g[0] > s[s.length - 1]) {
                // 如果不能满足胃口最小的孩子，直接返回0
                return 0;
            } else {
                int gi = 0;
                int si = 0;
                while (gi < g.length && si < s.length) {
                    if (g[gi] <= s[si]) {
                        gi++;
                        result++;
                    }
                    si++;
                }
            }
        }
        return result;
    }

}
