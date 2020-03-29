class Solution {
public:
    bool isValidSudoku(vector<vector<char>>& board) {
        if(board.empty())
            return true;
        int row[9][9] = {0};            //这里两个维度第一维的9代表的含义是9行，第二个9代表的意义是这一行上的数字有1-9共9种可能的取值
        int col[9][9] = {0};            //第一维的9代表9列，第二维9代表的是每一个位置上有1-9共9种可能的取值
        int boxes[9][9] = {0};          //第一维代表的是共有9个盒子，第二维代表的是每个盒子里有1-9共9种可能的取值
        //以上三个二维数组里 col[x][y]代表的是第x列，数字y出现的次数，依次类推
        for(int i = 0; i < 9; ++i)
        {
            for(int j = 0; j < 9; ++j)
            {
                //检查行上是不是出现了重复的数字
                char c = board[i][j];
                if(c == '.')
                    continue;
                if(row[i][c - '1'])
                    return false;
                if(col[j][c - '1'])
                    return false;
                if(boxes[(i / 3) *3 + j/3][c - '1'])
                    return false;
                row[i][c - '1'] = 1;
                col[j][c - '1'] = 1;
                boxes[ (i / 3) * 3 + j / 3][c - '1'] = 1;
            }
        }
        
        return true;
    }
};
