public class LeetCode_74 {
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            //二分法查找
            int nr = matrix.length;
            if (nr == 0) {
                return false;
            }
            int nc = matrix[0].length;
            if (nc == 0) {
                return false;
            }

            int rleft = 0;
            int rright = nr - 1;
            int r = 0;
            //找到所在行
            while (rright - rleft > 1) {
                int mid = (rright + rleft) / 2;

                if (target == matrix[mid][0]) {
                    return true;
                } else {
                    if (target < matrix[mid][0]) {
                        rright = mid;
                    } else {
                        rleft = mid;
                    }
                }
            }
            if (target >= matrix[rright][0]) {
                r = rright;
            } else {
                r = rleft;
            }

            //找到所在列
            int cleft = 0;
            int cright = nc - 1;
            while (cleft <= cright) {
                int mid = (cleft + cright) / 2;
                if (target == matrix[r][mid]) {
                    return true;
                } else {
                    if (target < matrix[r][mid]) {
                        cright = mid - 1;
                    } else {
                        cleft = mid + 1;
                    }
                }
            }
            return false;
        }

    }
}
