class Solution {
public:
    int minimumTotal(vector<vector<int>>& triangle) {
        vector<vector<int>> status(triangle);
        for(int row = status.size() - 2; row >= 0; --row)
            for(int col = 0; col < status[row].size(); ++col)
                status[row][col] += status[row + 1][col] < status[row + 1][col + 1] ? status[row + 1][col] : status[row + 1][col + 1];
        return status[0][0];
    }
};
