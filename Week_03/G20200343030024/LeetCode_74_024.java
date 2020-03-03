class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix== null || matrix.length == 0) return false;

        int M = matrix.length;
        int N = matrix[0].length;

        int left = 0;
        int right = (M * N) - 1;

        while(left <= right){
            int mid = left + ((right - left) >> 1);
            int midValue = matrix[mid/N][mid%N];
            if ( midValue == target){
                return true;
            }

            if (midValue >= target){
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }

        return false;
    }
}