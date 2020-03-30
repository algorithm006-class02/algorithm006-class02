package com.example.lib;

/**
 * 所属项目:JavaProject
 * 所属类名:com.example.lib.LeedCode_191_376
 * 功能描述:
 * 创建作者:VVs
 * 创建时间:2020/3/29
 */

public class LeedCode_191_376 {


    public int hammingWeight(int n) {
        int sum = 0;
        while (n != 0) {
            sum++;
            n &= (n - 1);
        }
        return sum;
    }

}

