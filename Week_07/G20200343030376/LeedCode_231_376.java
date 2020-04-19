package com.example.lib;

/**
 * 所属项目:JavaProject
 * 所属类名:com.example.lib.LeedCode_231_376
 * 功能描述:
 * 创建作者:VVs
 * 创建时间:2020/3/29
 */

public class LeedCode_231_376 {

    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

}
