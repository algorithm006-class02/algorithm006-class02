class Solution {
public:
    //动态规划求解
    int longestCommonSubsequence(string text1, string text2) {
        if(text1.empty() || text2.empty())
            return 0;
        int row = text1.size() + 1;     //被当做行的那一个字符串
        int col = text2.size() + 1;     //被当做列的那一个字符串
        vector<vector<int>> status{row,vector<int> (col)};
        for(int i = 1; i < row; ++i)
            for(int j = 1; j < col; ++j)
            {
                if(text1[i-1] == text2[j - 1])
                    status[i][j] = 1 + status[i - 1][j - 1];
                else
                    status[i][j] = status[i - 1][j] > status[i][j - 1] ? status[i - 1][j] : status[i][j - 1];
            }
        
        return status[row-1][col-1];
    }
};
