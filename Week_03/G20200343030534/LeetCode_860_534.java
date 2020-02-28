package com.test.datastructure;

public class LemonadeChange860 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] input = {5,5,10,10,20};
        lemonadeChange(input);
    }

    public static boolean lemonadeChange(int[] bills) {
        if (bills == null)
            return false;
        if (bills.length >= 1 && (bills[0] == 10 || bills[0] == 20)) {
            return false;
        }
        int sumOfFive = 0;
        int sumOfTen = 0;

        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                sumOfFive += 5;
            } else if (bills[i] == 10) {
                sumOfTen += 10;
                sumOfFive -= 5;
            } else {
                if (sumOfTen > 0 && sumOfFive > 0) {
                    sumOfTen -= 10;
                    sumOfFive -= 5;
                } else if (sumOfFive > 0) {
                    sumOfFive -= 15;
                } else {
                    return false;
                }
            }
            if (sumOfFive < 0 || sumOfTen < 0) {
                return false;
            }
        }
        return true;
    }
}
