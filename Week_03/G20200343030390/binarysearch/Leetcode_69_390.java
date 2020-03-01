package com.subject.week03.binarysearch;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 *
 *实现 int sqrt(int x) 函数。
 *
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 *
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 示例 1:
 *
 * 输入: 4
 * 输出: 2
 * 示例 2:
 *
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 *
 *
 */



public class Leetcode_69_390 {
    public int mySqrt(int x) {
        // 1.二分查找 单调递增 上下界 这段代码细节很多
        if(x==0 || x == 1) {
            return x;
        }
        int left = 1;
        int right = x;
        int mid = 1;
        while (left <= right) {
            mid = left + (left+right)/2;
            if(mid * mid > x ){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return (int) right;
    }

}