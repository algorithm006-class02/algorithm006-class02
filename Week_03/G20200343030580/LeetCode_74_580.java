class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        int[] indexes = new int[matrix.length];
        for (int i = 0; i < indexes.length; i++) {
            if (matrix[i].length == 0) {
                return false;
            }
            indexes[i] = matrix[i][0];
        }
        int left = 0, right = indexes.length - 1;
        while (right >= left) {
            int mid = (right + left) / 2;
            if (target == indexes[mid]) {
                return true;
            } else if (target > indexes[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right >= 0 ? binarySearch(matrix[right], target) : false;

    }

    private boolean binarySearch(int[] data, int target) {
        int left = 0, right = data.length - 1;
        while (right >= left) {
            int mid = (right + left) / 2;
            if (target == data[mid]) {
                return true;
            } else if (target > data[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}