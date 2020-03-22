//529
//https://leetcode-cn.com/problems/minesweeper

class Solution {
public:
    vector<vector<char>> updateBoard(vector<vector<char>>& board, vector<int>& click) {
        dfs(board, click[0], click[1]);
        return board;
    }    

    void dfs(vector<vector<char>>& board, int row, int col) {
        if ('M' == board[row][col]) {
            board[row][col] = 'X';
            return;
        }
        if ('E' != board[row][col]) {
            return;
        }
        int mines = 0;
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++ ) {
                if (i >= 0 && i < board.size() && j >= 0 && j < board[0].size()) { 
                    if ('M' == board[i][j] || 'X' == board[i][j])
                        mines++;
                }
            }
        }
        if (0 < mines) {
            board[row][col] =  mines + '0';
            return;
        } 
        else {
            board[row][col] = 'B';
            for (int i = row - 1; i <= row + 1; i++) {
                for (int j = col - 1; j <= col + 1; j++ ) {
                    if (i >= 0 && i < board.size() && j >= 0 && j < board[0].size()) { 
                        if ('E' == board[i][j])
                            dfs(board, i, j);
                    }
                }
            }
        }
    }
};
