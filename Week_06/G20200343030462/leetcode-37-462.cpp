class Solution {
public:
    void solveSudoku(vector<vector<char>>& board) {
        if(board.empty())
            return;
        slove(board);
    }
private:
    bool slove(vector<vector<char>> &board)
    {
        for(int i = 0; i < board.size(); ++i)
            for(int j = 0; j < board[i].size(); ++j)
            {
                //如果当前位置上可以放数字，那么就把1到9挨个放进去看哪一个是可以让棋盘合法的做法
                if('.' == board[i][j])
                {
                    for(char c = '1'; c <='9'; ++c)
                    {
                        if(isVaild(board,c,i,j))
                        {
                            board[i][j] = c;
                            if(slove(board))
                                return true;
                              board[i][j] = '.';      //回溯恢复状态
                        }
                    }
                    
                    //如果哪一种方案都不能使棋盘有效，那就无解
                    return false;
                }
            }
        
        return true;
    }
    
    //判断当前走法是否可以让棋盘有效
    bool isVaild(vector<vector<char>> &board,char c,int row,int col)
    {
        //3*3的块有9个，每一行能容纳9个元素，每一列可以容纳9个元素
        for(int i = 0; i < 9; ++i)
        {
            //检查行是否有效
            if(board[row][i] != '.' && c == board[row][i])
                return false;
            
            //检查列是否有效
            if(board[i][col] != '.' && c == board[i][col])
                return false;
            
            //检查每个box是否有效
            if(board[ 3 * (row / 3) + i / 3][ 3 * (col / 3) + i % 3] != '.' && 
              c == board[ 3 * (row / 3) + i / 3][ 3 * (col / 3) + i % 3] )
                return false;
        }
        return true;
    }
};
