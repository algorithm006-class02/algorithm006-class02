/*
 * @lc app=leetcode.cn id=529 lang=cpp
 *
 * [529] 扫雷游戏
 */

// @lc code=start
class Solution {
public:
    int dirs[8][2] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, 
                      {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
    bool valid(int x, int y, int R, int C) {
        return x >= 0 && x < R && y >= 0 && y < C;
    }
    vector<vector<char>> updateBoard(vector<vector<char>>& board, vector<int>& click) {
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }
        int R = board.size();
        int C = board[0].size();
        vector<vector<int> > ADJ(R, vector<int>(C, 0));
        for (int i = 0; i < R; ++i) {
            for (int j = 0; j < C; ++j) {
                if (board[i][j] == 'M' || board[i][j] == 'X') {
                    for (int k = 0; k < 8; ++k) {
                        int x = i + dirs[k][0];
                        int y = j + dirs[k][1];
                        if (valid(x, y, R, C)) {
                            ++ADJ[x][y];
                        }
                    }
                }
            }
        }
        if (ADJ[click[0]][click[1]] > 0) {
            board[click[0]][click[1]] = '0' + ADJ[click[0]][click[1]];
            return board;
        }
        queue<pair<int, int> > q;
        board[click[0]][click[1]] = 'B';
        q.push({click[0], click[1]});
        while (!q.empty()) {
            auto p = q.front();
            q.pop();
            int x = p.first;
            int y = p.second;
            for (int i = 0; i < 8; ++i) {
                int r = x + dirs[i][0];
                int c = y + dirs[i][1];
                if (valid(r, c, R, C)) {
                    if (ADJ[r][c] > 0) {
                        board[r][c] = '0' + ADJ[r][c];
                    } else if (board[r][c] == 'E') {
                        board[r][c] = 'B';
                        q.push({r, c});
                    }
                }
            }
        }
        return board;
    }
};
// @lc code=end

