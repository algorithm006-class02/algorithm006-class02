package com.ping.leetcode.utils;

/**
 * @Author: 高一平
 * @Date: 2020/3/21
 * @Description: 多维数组工具类
 **/
public class MultiArrayUtils {

    private static String TAG = "=";

    /**
     * 二维数组打印
     *
     * @param param
     */
    public static void print(Object[][] param) {
        System.out.println("===================================");
        for (Object[] row : param) {
            print(row);
        }
        System.out.println("===================================");
    }

    public static void print(String[][] param) {
        System.out.println("===================================");
        for (String[] row : param) {
            print(row);
        }
        System.out.println("===================================");
    }

    public static void print(int[][] param) {
        System.out.println("===================================");
        for (int[] row : param) {
            print(row);
        }
        System.out.println("===================================");
    }

    public static void print(boolean[][] param) {
        System.out.println("===================================");
        for (boolean[] row : param) {
            print(row);
        }
        System.out.println("===================================");
    }

    public static void print(Object[] param) {
        StringBuilder result = new StringBuilder();
        result.append(TAG);
        for (Object col : param) {
            result.append(col).append(TAG);
        }
        System.out.println(result.toString());
    }

    public static void print(String[] param) {
        StringBuilder result = new StringBuilder();
        result.append(TAG);
        for (String col : param) {
            result.append(col).append(TAG);
        }
        System.out.println(result.toString());
    }

    public static void print(int[] param) {
        StringBuilder result = new StringBuilder();
        result.append(TAG);
        for (int col : param) {
            result.append(col).append(TAG);
        }
        System.out.println(result.toString());
    }

    public static void print(boolean[] param) {
        StringBuilder result = new StringBuilder();
        result.append(TAG);
        for (boolean col : param) {
            result.append(col).append(TAG);
        }
        System.out.println(result.toString());
    }
}
