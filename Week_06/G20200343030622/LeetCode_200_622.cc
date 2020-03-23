class Solution
{
public:
    int result;

    int union_find(std::vector<int> &parent, int x)
    {
        while (parent[x] != x)
            x = parent[x];
        return x;
    }

    void union_join(std::vector<int> &parent, int x, int y)
    {
        int parent_x = union_find(parent, x);
        int parent_y = union_find(parent, y);

        if (parent_x != parent_y)
        {
            parent[parent_x] = parent_y;
            result--;
        }
    }

    int numIslands(vector<vector<char>> &grid)
    {
        if (grid.size() == 0 || grid[0].size() == 0)
        {
            return 0;
        }

        int m = grid.size();
        int n = grid[0].size();

        std::vector<int> parent;
        for (int i = 0; i < m * n; i++)
        {
            parent.push_back(i);
        }

        result = m * n;

        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (grid[i][j] != '1')
                {
                    result--;
                    continue;
                }

                int p = i * n + j;
                if (i > 0 && grid[i - 1][j] == '1')
                {
                    int q = p - n;
                    union_join(parent, p, q);
                }

                if (i < m - 1 && grid[i + 1][j] == '1')
                {
                    int q = p + n;
                    union_join(parent, p, q);
                }

                if (j > 0 && grid[i][j - 1] == '1')
                {
                    int q = p - 1;
                    union_join(parent, p, q);
                }

                if (j < n - 1 && grid[i][j + 1] == '1')
                {
                    int q = p + 1;
                    union_join(parent, p, q);
                }
            }
        }

        return result;
    }
};