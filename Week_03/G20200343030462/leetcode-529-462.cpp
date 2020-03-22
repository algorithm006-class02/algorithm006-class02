class Solution {
public:
    vector<vector<char>> updateBoard(vector<vector<char>>& board, vector<int>& click) {
        if('M' == board[click[0]][click[1]])
        {
            board[click[0]][click[1]] = 'X';
            return board;
        }
        int iRow = click[0];
        int iCol = click[1];
        updateBoard(board,iRow,iCol);
        return board;
    }
private:
    std::vector<std::vector<int>> m_vecDirec{{1,0},{0,1},{1,1},{-1,0},{-1,-1},{0,-1},{1,-1},{-1,1}};    //递归的时候要向着上、下、左、右、左上、左下、右上、右下8个方向探索
    
    void updateBoard(std::vector<std::vector<char>> &vecBoard,int iRow,int iCol)
    {
        //如果边界是合法的，并且当前处理的是块是'E'（因为如果是'B'和'X'的话说明已经翻过了，如果是'M'的话，就不应该翻了，如果你自动翻开了地雷，玩家就没得玩了）
        if(isConditionVaild(vecBoard,iRow,iCol) && 'E' == vecBoard[iRow][iCol] )
        {
            //搜索(iRow,iCol)这个位置上应该放数字还是放'B'，放数字的话，应该是几，所以从8个方向上依次检查[iRow,iCol]附近是否有雷，有雷的情况不递归，要直接相邻才算
            int iCount = 0; //当前坐标附近地雷的数量
            for(auto const &direction : m_vecDirec)
            {
                int iTmpRow = iRow + direction[0];
                int iTmpCol = iCol + direction[1];
                if(isConditionVaild(vecBoard,iTmpRow,iTmpCol)  && ('M' == vecBoard[iTmpRow][iTmpCol] || 'X' == vecBoard[iTmpRow][iTmpCol] ))
                    ++iCount;
            }
            
            if(iCount > 0)
            {
                vecBoard[iRow][iCol] = char(iCount + '0');
                return;     //都是雷区，不用探索了
            }
            
            vecBoard[iRow][iCol] = 'B';
            
            //递归探索该坐标点8个相邻方向上的其它点的情况
            for(auto const &direction : m_vecDirec)
            {
                int iTmpRow = iRow + direction[0];
                int iTmpCol = iCol + direction[1];
                if(isConditionVaild(vecBoard,iTmpRow,iTmpCol) && 'E' == vecBoard[iTmpRow][iTmpCol])
                    updateBoard(vecBoard,iTmpRow,iTmpCol);
            }
        }
    }
    
    bool isConditionVaild(const std::vector<std::vector<char>> &vecBoard,int iRow,int iCol)
    {
        //所谓的合法边界其实就是确保无论从哪个方向上搜索，都不应该产生数组越界的行为
        if(iRow >= 0 && iCol >= 0 && iRow < vecBoard.size() && iCol < vecBoard[iRow].size())
            return true;
        return false;
    }
};
