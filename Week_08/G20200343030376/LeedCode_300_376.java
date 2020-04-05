package com.example.lib;

/**
 * 所属项目:JavaProject
 * 所属类名:com.example.lib.LeedCode_300_376
 * 功能描述:
 * 创建作者:VVs
 * 创建时间:2020/4/5
 */



public class LeedCode_300_376 {

    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int res = 0;
        for(int num : nums) {
            int i = 0, j = res;
            while(i < j) {
                int m = (i + j) / 2;
                if(tails[m] < num) i = m + 1;
                else j = m;
            }
            tails[i] = num;
            if(res == j) res++;
        }
        return res;
    }

}
