package com.test.datastructure;

public class DecodeWays91 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        DecodeWays91 decode = new DecodeWays91();
        System.out.println(decode.numDecodings("110"));
    }

    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.charAt(0) == '0') {
            return 0;
        }

        int[] result = new int[s.length()];
        result[0] = 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2') {
                    if(i >= 2) {
                    result[i] = result[i - 2];
                    } else {
                        result[i] = result[i -1];
                    }
                } else {
                    return 0;
                }
            } else if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2' && s.charAt(i) >= '1' && s.charAt(i) <= '6') {
                if(i >=2) {
                    result[i] = result[i - 1] + result[i - 2];
                } else {
                    result[i] = result[i - 1] + 1;
                }
            } else {
                result[i] = result[i - 1];
            }
        }
        return result[result.length - 1];
    }

}
