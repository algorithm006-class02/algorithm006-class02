class Solution {
public:
    int maximalSquare(vector<vector<char>>& matrix) {
        if(matrix.empty()) return 0;
        int m = matrix.size();
        int n = matrix[0].size();
        int c[m][n];
        int max_tag = INT_MIN;
        for(int i = 0; i < n; i++){
            c[0][i] = matrix[0][i] - '0';
            max_tag = max(max_tag, c[0][i]);
        }
        for(int j = 0; j < m; j++){
            c[j][0] = matrix[j][0] - '0';
            max_tag = max(max_tag, c[j][0]);
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(matrix[i][j] == '1'){
                    int tmp = min(c[i-1][j-1],c[i-1][j]);
                    c[i][j] = min(tmp, c[i][j-1]) + 1;
                }
                else{
                    c[i][j] = 0;
                }
                max_tag = max(max_tag, c[i][j]);
            }
        }
        return max_tag * max_tag;
    }
};