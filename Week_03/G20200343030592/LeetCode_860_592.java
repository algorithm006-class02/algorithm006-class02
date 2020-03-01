package com.gsf.geekbang_demo.arithmetic.leetCode.week03;

/**
 * 860. 柠檬水找零
 */
public class Demo860 {
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int b : bills) {
            if (b == 5) {
                five++;
            } else if (b == 10) {
                if (five-- == 0) return false;
                ten++;
            } else if (b == 20) {
                if (five > 0 && ten > 0) {
                    five--;
                    ten--;
                } else if (five > 2){
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
