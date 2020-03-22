/*
 * @lc app=leetcode.cn id=529 lang=cpp
 *
 * [529] 扫雷游戏
 */

// @lc code=start
class Solution {
public:
    int dx[8] = {-1,-1,-1, 0, 0, 1, 1, 1};
    int dy[8] = { 1, 0,-1, 1,-1, 1, 0, -1};
    vector<vector<char>> updateBoard(vector<vector<char>>& board, vector<int>& click) 
	{
        int row = click[0];
        int col = click[1];
        //访问记录
        //vector<vector<bool>> visited( board.size(), 
        //vector<bool>(board[0].size(), false) );
        if(board[row][col] == 'M'){
            board[row][col] = 'X'; 
        } else{
            DFS(row, col, board);
        }
        return board;
    }
    
    void DFS(int row, int col, vector<vector<char>>& board)
	{
        //统计附近是否有雷, 有雷就返回
        int mn = findMine(row, col, board);
        if ( mn > 0 ) {
            board[row][col] = '0' + mn;
            return ;
        }
        //没有雷就移动
        board[row][col] = 'B';
        for (int k = 0; k < 8; k++)
		{
            int x = row + dx[k], y = col + dy[k];
            if ( x >= 0 && x < board.size() && y >= 0 && y < board[0].size() && 
                    board[x][y]=='E'){
                DFS(x, y, board);
            }
        }
    }
    int findMine(int row, int col, vector<vector<char>>& board)
	{
        //左上、左、左下、上、下、右上、右、右下
        int count = 0;
        for (int i = 0; i < 8; i++)
		{
            int x = row + dx[i], y = col + dy[i];
            if ( x >= 0 && x < board.size() && y >= 0 && y < board[0].size()){
            if ( board[x][y] == 'M') count+=1; //有雷+1
            }
        }
        return count;
    }
};
// @lc code=end

