package com.example.lib;

/**
 * 所属项目:JavaProject
 * 所属类名:com.example.lib.LeedCode_860_376
 * 功能描述:
 * 创建作者:VVs
 * 创建时间:2020/3/1
 */

public class LeedCode_860_376 {

    public boolean lemonadeChange(int[] bills) {

        int five = 0, ten = 0;
        for (int bill : bills) {
            switch (bill) {
                case 5: five++; break;
                case 10: five--; ten++; break;
                case 20: {
                    if (ten > 0) {
                        ten--; five--;
                    } else {
                        five -= 3;
                    }
                    break;
                }
                default: break;
            }
            if (five < 0) {
                return false;
            }
        }
        return true;

    }

}
