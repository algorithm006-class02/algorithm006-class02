package week3;

/**
 * 74. 搜索二维矩阵
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * <p>
 * 示例 1:
 * 输入:
 * matrix = [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * target = 3
 * 输出: true
 * <p>
 * https://leetcode-cn.com/problems/search-a-2d-matrix/
 */
public class Search2DMatrix {
    public static void test() {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };
        int target = 3;
        System.out.println("矩阵维度：" + matrix.length); // 3
        System.out.println("是否存在：" + new Search2DMatrix().searchMatrix2(matrix, target));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        // 暴力法：逐维查找
        for (int i = 0; i < matrix.length; i++) {
            int[] array = matrix[i];
            if (search(array, target)) {
                return true;
            }
        }
        return false;
    }

    private boolean search(int[] array, int target) {
        // 二分法查找
        if (array.length == 0) {
            return false;
        }
        int start = 0;
        int end = array.length - 1;
        if (array[start] <= target && target <= array[end]) {
            while (start <= end) {
                int mid = (start + end) / 2;
                if (array[mid] == target) {
                    return true;
                } else if (array[mid] < target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return false;
    }


    public boolean searchMatrix2(int[][] matrix, int target) {
        // 二分查找法 - 一次循环
        // 把矩阵看成是一个一维的数组，则总共有 m*n 个数字，然后主要就是解决序号到矩阵元素下标的转换
        int m = matrix.length;
        if (m == 0) {
            return false;
        }
        int n = matrix[0].length;

        int start = 0;
        int end = m * n - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            // 映射矩阵下标技巧
            int midValue = matrix[mid / n][mid % n];
            if (midValue == target) {
                return true;
            } else if (midValue < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }
}
