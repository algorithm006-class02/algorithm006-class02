/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] 接雨水
 */

// @lc code=start
class Solution {
    //接雨水  分析 leftMax rightMax 自己的高度height[i]
    //木桶理论 短板效应 决定能放多少水
    //每个位置存储单元的通项公式
    //Units = max(min(leftMax,rightMax) - height[i],0)
    //然后枚举每个位置存水容量加起来即可

    //暴力法 时间复杂度 O(n*n)
    public int trap(int[] height) {
        int len = height.length;
        if (len < 3) {
            return 0;
        }
        int res = 0;
        for (int i = 1; i < len - 1; i++) {
            int leftMax = leftMax(height, i);
            int rightMax = rightMax(height, i, len);
            if (height[i] < Math.min(leftMax, rightMax)) {
                res += Math.min(leftMax, rightMax) - height[i];
            }
        }
        return res;
    }

    //计算center左边柱子的最高高度（不含center）
    private int leftMax(int[] height, int center) {
        int res = 0;
        for (int i = center - 1; i >= 0; i--) {
            res = Math.max(res, height[i]);
        }
        return res;
    }

    //计算右边柱子的最高高度（不含center）
    private int rightMax(int[] height, int center, int n) {
        int res = 0;
        for (int i = center + 1; i < n; i++) {
            res = Math.max(res, height[i]);
        }
        return res;
    }


    //方法2 空间换时间
    //接雨水的第一个位置和最后一个位置都没有用，因为无法构成水坑
    //用空间去换存储leftMax 和 rightMax 的时间
    //    时间复杂度 O(n)
    //    空间复杂度 创建了2个数组和高度一样的数组 O(n)
    public int trapMethod2(int[] height) {
        int len = height.length;
        if (len < 3) {
            return 0;
        }
        //记录索引位置i左边最高高度，不包括索引i
        int[] leftMax = new int[len];
        for (int i = 1; i < len; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i - 1]);
        }
        //记录索引位置i右边的最高高度，不包括索引i
        int[] rightMax = new int[len];
        for (int i = len - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i + 1]);
        }
        int res = 0;
        for (int i = 1; i < len - 1; i++) {
            int minHeight = Math.min(leftMax[i], rightMax[i]);
            if (height[i] < minHeight) {
                res += minHeight - height[i];
            }
        }
        return res;
    }

    //方法3 首尾指针中间相撞
    //时间复杂度 O(n) 空间复杂度 O(1)
    public int trapMethod3(int[] height) {
        int len = height.length;
        if (len < 3) {
            return 0;
        }
        int res = 0;
        int leftMax = height[0];
        int rightMax = height[len - 1];
        //初始值的选取，特判 头和尾都不存在雨水
        int left = 1;
        int right = len - 2;
        while (left <= right) {
            int minVal = Math.min(leftMax, rightMax);
            if (minVal == leftMax) {
                if (minVal > height[left]) {
                    res += minVal - height[left];
                }
                leftMax = Math.max(leftMax, height[left]);
                left++;
            } else {
                if (minVal > height[right]) {
                    res += minVal - height[right];
                }
                rightMax = Math.max(rightMax, height[right]);
                right--;
            }
        }
        return res;
    }
}
// @lc code=end

