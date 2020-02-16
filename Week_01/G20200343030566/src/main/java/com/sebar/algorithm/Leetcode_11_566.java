package com.sebar.algorithm;

/**
 * @author liguang@youxin.com
 * @Date 2020/2/12
 * @Description 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 */
public class Leetcode_11_566 {
    /**
     * 解决方法一
     * 暴力穷举，试探每一种组合形成的矩形面积
     *
     * @param nums
     * @return
     */
    public int solutionOne(int[] nums) {
        int maxArea = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                maxArea = Math.max(maxArea, Math.min(nums[i], nums[j]) * (j - i));
            }
        }
        return maxArea;
    }

    /**
     * 解决方案，采用双指针进行移动比较，
     * 一根指针在头，一根指针在尾巴
     * 如果头指针比尾巴指针大，则尾巴指针向内移动一位，
     * 如果头指针比尾巴指针小，则头指针向内移动一位，
     *
     * @param nums
     * @return
     */
    public int solutionTwo(int[] nums) {
        int maxArea = 0;
        int head = 0;
        int tail = nums.length - 1;
        while (head < tail) {
            maxArea = Math.max(maxArea, Math.min(nums[head], nums[tail]) * (tail - head));
            // 头部比尾部高
            if (nums[head] > nums[tail]) {
                tail--;
            } else {
                head++;
            }
        }
        return maxArea;
    }

}
