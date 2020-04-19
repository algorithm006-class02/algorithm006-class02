class Solution
{
public:
    using node_t = std::pair<int, int>;

    void solve(vector<vector<char>> &board)
    {
        if (board.size() == 0 || board[0].size() == 0)
        {
            return;
        }

        int ROWS = board.size();
        int COLS = board[0].size();

        std::vector<node_t> borders;
        for (int r = 0; r < ROWS; r++)
        {
            borders.push_back({r, 0});
            borders.push_back({r, COLS - 1});
        }

        for (int c = 0; c < COLS; c++)
        {
            borders.push_back({0, c});
            borders.push_back({ROWS - 1, c});
        }

        for (auto pair : borders)
        {
            DFS(board, pair.first, pair.second);
        }

        for (int r = 0; r < ROWS; r++)
        {
            for (int c = 0; c < COLS; c++)
            {
                if (board[r][c] == 'O')
                    board[r][c] = 'X';
                if (board[r][c] == '*')
                    board[r][c] = 'O';
            }
        }

        return;
    }

    void DFS(vector<vector<char>> &board, int r, int c)
    {
        if (board[r][c] != 'O')
        {
            return;
        }

        int ROWS = board.size();
        int COLS = board[0].size();

        board[r][c] = '*';
        if (c < COLS - 1)
        {
            DFS(board, r, c + 1);
        }

        if (r < ROWS - 1)
        {
            DFS(board, r + 1, c);
        }

        if (c > 0)
        {
            DFS(board, r, c - 1);
        }

        if (r > 0)
        {
            DFS(board, r - 1, c);
        }
    }
};