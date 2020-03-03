package com.sebar.test.leetcode.three.practice.greedy;

/**
 * 860. 柠檬水找零
 * https://leetcode-cn.com/problems/lemonade-change/description/
 */
public class Leetcode_860_566 {
    /**
     * 柠檬水找零
     *
     * @param bills 收入的零钱
     *              时间复杂度O(n) 空间复杂度O(1)
     * @return
     */
    public boolean lemonadeChange(int[] bills) {
        //收入的零钱中 五美元和十美元的数量
        int five = 0;
        int ten = 0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                five++;
            }
            if (bills[i] == 10) {
                // 收入了十美元，却没有五美元可以找零的时候，返回false
                if (five == 0) {
                    return false;
                }
                five--;
                ten++;
            }
            if (bills[i] == 20) {
                // 收入了二十美元，则要找给客户一个十美元，一个五美元,或者三个五美元，如果没有则返回false
                if (five > 0 && ten > 0) {
                    five--;
                    ten--;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Leetcode_860_566 code = new Leetcode_860_566();
        boolean flag = code.lemonadeChange(new int[]{10, 10});
        System.out.println(flag);
    }
}
