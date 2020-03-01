//先确定行，再在行里二分查找
class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int m = matrix.size();
        if (m==0) return false;
        int n = matrix[0].size();
        if (n==0) return false;
        int i=0;
        while (i<m) {
            if (matrix[i][0]<=target && target<=matrix[i][n-1])
                break;
            else
                i++;
        }
        if (i==m) return false;
        int low=0, high=n-1;
        while (low<=high) {
            int mid = low + (high-low)/2;
            if (target==matrix[i][mid]) return true;
            if (matrix[i][low]<=target && target<=matrix[i][mid]) {
                high = mid;
            } else {
                low = mid+1;
            }
        }
        return false;
    }
};