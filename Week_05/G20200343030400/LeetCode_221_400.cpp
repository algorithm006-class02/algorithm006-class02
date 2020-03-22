class Solution {
public:
    int maximalSquare(vector<vector<char>>& matrix) {
        int m = matrix.size();
        if (m == 0) {
            return 0;
        }
        int n = matrix[0].size();
        if (n == 0) {
            return 0;
        }
        char maxSquare = '0';      
        for (int row = 0; row < m; row++) {
            if (maxSquare < matrix[row][0]) {
                maxSquare = matrix[row][0];
            }
        }
        for (int col = 1; col < n; col++) {
            if (maxSquare < matrix[0][col]) {
                maxSquare = matrix[0][col];
            }
        }
        for (int row = 1; row < m; row++) {
            for (int col = 1; col < n; col++) {
                if ('0' < matrix[row][col]) {
                    matrix[row][col] += (min(min(matrix[row - 1][col], matrix[row][col - 1]), matrix[row - 1][col - 1]) - '0');
                    if (maxSquare < matrix[row][col]) {
                        maxSquare = matrix[row][col];
                    } 
                }
            }   
        }
        int size = maxSquare - '0';
        return size * size;
    }
};
