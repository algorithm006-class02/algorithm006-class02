ass Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int row = matrix.length;
        if (row == 0) {
            return false;
        } 
        int column = matrix[0].length;
        if (column == 0) {
            return false;
        }
        

        int top = 0;
        int bottom = row - 1;
        int midRow = (top + bottom) / 2;
       
        while (top <= bottom) {
            midRow = (top + bottom) / 2;
            if (target >= matrix[midRow][0] && target <= matrix[midRow][column - 1]) {
                break;
            } 
            if (target > matrix[midRow][column - 1]) {
                top = midRow + 1;
            } 
            if (target < matrix[midRow][0]) {
                bottom = midRow - 1;
            }
        }

        int left = 0;
        int right = column - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target == matrix[midRow][mid]) {
                return true;
            } else if (target > matrix[midRow][mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;

    }
}
