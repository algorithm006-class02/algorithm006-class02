package com.test.datastructure;

public class Atoi8 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Atoi8 check = new Atoi8();
        String input = "0-1";
        System.out.println(check.myAtoi(input));

    }

    public int myAtoi(String str) {
        int start = 0;
        if (str == null || str.trim().length() == 0) {
            return 0;
        }
        StringBuilder builder = new StringBuilder();
        char sign = ' ';
        boolean hasNum = false;
        while (start < str.length()) {
            if (str.charAt(start) == ' ') {
                start++;
            } else {
                break;
            }
        }
        while (start < str.length()) {
            if ((str.charAt(start) == '+' || str.charAt(start) == '-') && !hasNum) {
                if (sign == ' ') {
                    sign = str.charAt(start);
                    start++;
                } else {
                    return 0;
                }
            } else if (str.charAt(start) >= '0' && str.charAt(start) <= '9') {
                hasNum = true;
                builder.append(str.charAt(start));
                start++;
            } else if (!hasNum) {
                return 0;
            } else if (hasNum) {
                break;
            }
        }
        if (hasNum) {
            double r = Double.parseDouble(builder.toString());
            if ((sign == '+' || sign == ' ') && r >= Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else if (sign == '-') {
                r = -r;
                if (r <= Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }
            }
            return (int) r;
        } else {
            return 0;
        }

    }

}
