package com.sebar.algorithm;

/**
 * @author liguang@youxin.com
 * @Date 2020/2/15
 * @Description
 */
public class Leetcode_42_566 {
    /**
     * 思路：
     * 1.先找出当前数组中最大的数字，决定了雨柱子最高的维度
     * 1，再横向往上拓展，连续比当前循环高度小的数字有多少个，
     * 则决定了能接多少单元的水
     *
     * @param height
     * @return
     */
    public int trap(int[] height) {
        // 当前数组中最高的元素有多高
        int maxHeight = height[0];
        int minHeight = height[0];
        for (int i = 0; i < height.length; i++) {
            maxHeight = Math.max(maxHeight, height[i]);
            minHeight = Math.min(minHeight, height[i]);
        }

        // 决定了需要向上前进多少步
        int loopContinueArea = 0;
        int i = minHeight + 1;
        for (; i <= maxHeight; i++) {
            // 一定是从下标1开始的，两边不可能存水,从底部开始一个个往上指
            Boolean isStart = false;
            int startIndex = 0;

            // 第一个大于当前循环的元素位置
            for (int k = 1; k < height.length; k++) {
                if (height[k] >= i) {
                    startIndex = k;
                    break;
                }
            }

            int j = startIndex;
            for (; j < height.length; j++) {
                // 有小于当前循环数的时候，开始计数
                if (height[j] < i && j < height.length - 1) {
                    if (startIndex != 0 && isStart) {
                        continue;
                    }
                    startIndex = j;
                    // 开始计数
                    isStart = true;
                    // 填平小的区域
                    height[j] = i;
                    continue;
                } else if (height[j] >= i && isStart) {
                    loopContinueArea = loopContinueArea + (j - startIndex);
                    isStart = false;
                }
            }
        }
        return loopContinueArea;
    }

    /**
     * 每次确认左右两边较低储水柱
     *
     * @param height
     * @return
     */
    public int trapTwo(int[] height) {
        int area = 0;
        int length = height.length;
        for (int i = 1; i < length - 1; i++) {
            int maxLeft = 0;
            int maxRight = 0;
            for (int j = i; j >= 0; j--) {
                maxLeft = Math.max(maxLeft, height[j]);
            }
            for (int j = i; j < length; j++) {
                maxRight = Math.max(maxRight, height[j]);
            }
            int i1 = Math.min(maxLeft, maxRight) - height[i];
            area += i1;
        }
        return area;
    }

    /**
     * 动态求解
     *
     * @param height
     * @return
     */
    public int trapThree(int[] height) {
        int area = 0;
        int[] leftArray = new int[height.length];
        int[] rightArray = new int[height.length];

        for (int i = 1; i < height.length - 1; i++) {
            leftArray[i] = Math.max(leftArray[i - 1], height[i - 1]);
        }

        for (int i = height.length - 2; i >= 0; i--) {
            rightArray[i] = Math.max(rightArray[i + 1], height[i + 1]);
        }

        for (int i = 1; i < height.length - 1; i++) {
            int i1 = Math.min(leftArray[i], rightArray[i]);
            if (i1 > height[i]) {
                area += (i1 - height[i]);
            }
        }
        return area;
    }
}
