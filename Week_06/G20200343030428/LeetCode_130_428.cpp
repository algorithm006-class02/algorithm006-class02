/*
 * @lc app=leetcode.cn id=130 lang=cpp
 *
 * [130] 被围绕的区域
 */

// @lc code=start
class Solution {
public:
    void solve(vector<vector<char>>& board) {
       int nr = board.size();
       if (!nr) return;
       int nc = board[0].size();
       for (int r = 0; r < nr; r++) {
           for (int c = 0; c < nc; c++) {
               if (((r == 0 or c == 0 or r == (nr - 1) or c == (nc - 1) )) and board[r][c] == 'O') {
                   dfs(board, r, c);
               }
           }
       } 
       for (int r = 0; r < nr; r++) {
           for (int c = 0; c < nc; c++) {
               if (board[r][c] == 'O') 
                    board[r][c] = 'X';
               if (board[r][c] == '#') 
                    board[r][c] = 'O';
           }
       }
    }

    void dfs(vector<vector<char>>& board, int r, int c) {
        int nr = board.size();
        int nc = board[0].size();
        if (r < 0 || r >= nr || c < 0 || c >= nc || board[r][c] == 'X' || board[r][c] == '#')
            return;
        board[r][c] = '#';
        dfs(board, r - 1, c);
        dfs(board, r + 1, c);
        dfs(board, r, c - 1);
        dfs(board, r, c + 1);
    }
};
// @lc code=end

