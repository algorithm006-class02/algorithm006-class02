package com.example.task;

public class LeetCode_11_386 {
    public int maxArea(int[] height) {
        int maxarea = 0;
        int l = 0;
        int r = height.length - 1;
        while (l < r){
            maxarea = height[l] < height[r] ?
                    Math.max(maxarea, (r - l) * height[l++]) :
                    Math.max(maxarea, (r - l) * height[r--]);
        }
        return maxarea;
    }
}
