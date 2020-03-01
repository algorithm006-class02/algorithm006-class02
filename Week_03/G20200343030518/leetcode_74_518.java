class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        int left = 0;
        int length = matrix.length;
        int width = matrix[0].length;
        int right = length * width - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int x = mid / width;
            int y = mid % width;
            int value = matrix[x][y];
            if (value == target) {
                return true;
            } else if (value < target) {
                left = mid + 1;
            } else {
                right = mid -1;
            }
        }
        return false;

    }
}