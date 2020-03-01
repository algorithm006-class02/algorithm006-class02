package com.sebar.test.leetcode.three.homework;

/**
 * @author liguang
 * @Date 2020/2/28
 * @Description 74. 搜索二维矩阵
 * https://leetcode-cn.com/problems/search-a-2d-matrix/
 */

public class Leetcode_74_566 {
    public static void main(String[] args) {
        int[][] matrix = new int[1][1];
        matrix[0][0] = 1;
        matrix[0][0] = 3;
        matrix[0][2] = 4;
        matrix[0][3] = 7;
        matrix[1][0] = 10;
        matrix[1][1] = 11;
        matrix[1][2] = 16;
        matrix[1][3] = 20;
        matrix[2][0] = 23;
        matrix[2][1] = 30;
        matrix[2][2] = 34;
        matrix[2][3] = 50;

        Leetcode_74_566 code = new Leetcode_74_566();
        boolean b = code.searchMatrix(matrix, 3);
//        boolean b = code.searchMatrixByPower(matrix, 3);
        System.out.println(b);
    }

    /**
     * //将二维数组装换成一维数组
     * 由于每行都是从左到右递增，且第一个整数比上一行的最后一个整数大，则可以构建一个递增的数组
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        // 行
        int m = matrix.length;
        if (m == 0) {
            return false;
        }
        // 每行多少元素
        int n = matrix[0].length;

        int left = 0;
        int right = n * m - 1;
        int pivotIdx, pivotElement;
        while (left <= right) {
            pivotIdx = (left + right) / 2;
            pivotElement = matrix[pivotIdx / n][pivotIdx % n];
            if (target == pivotElement) {
                return true;
            } else {
                if (target < pivotElement) {
                    right = pivotIdx - 1;
                } else {
                    left = pivotIdx + 1;
                }
            }
        }
        return false;
    }

    /**
     * 暴力求解，缩小领域，每一行最后一个元素来定义这一行是不是存在目标值
     * 复杂度O(n)
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrixByPower(int[][] matrix, int target) {
        // 行
        int m = matrix.length;
        if (m == 0) {
            return false;
        }

        for (int i = 0; i < m; i++) {
            // 获取每一行的数据
            int[] matrix1 = matrix[i];
            if (matrix1 == null || matrix1.length == 0) {
                return false;
            }
            // 当前行没有比目标大的
            if (matrix1[matrix1.length - 1] < target) {
                continue;
            }
            // 当前行最后一个元素比目标值大
            int left = 0;
            int right = matrix1.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (target == matrix1[mid]) {
                    return true;
                } else if (target > matrix1[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }
}
