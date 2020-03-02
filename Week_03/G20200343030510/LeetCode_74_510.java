
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = matrix.length;
        if (i==0) return false;
        int j = matrix[0].length;

        int left = 0, right = i * j - 1;
        int mid,midElement;
        while (left <= right){
            mid = (left + right) / 2;
            midElement = matrix[mid / j][mid % j];
            if (target == midElement )
                return true;
            else{
                if (midElement > target )
                    right = mid - 1;
                else left = mid + 1;

            }

        }
        return false;


    }
}

