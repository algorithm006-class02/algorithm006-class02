class Solution
{
public:
    int find(std::vector<int> &parent, int i)
    {
        while (parent[i] != i)
        {
            i = parent[i];
        }

        return i;
    }

    void join(std::vector<int> &parent, int x, int y)
    {
        int parent_x = find(parent, x);
        int parent_y = find(parent, y);

        if (parent_x != parent_y)
        {
            parent[parent_x] = parent_y;
        }
    }

    int findCircleNum(vector<vector<int>> &M)
    {
        if (M.empty())
            return 0;

        int n = M.size();
        int groups = M.size();

        vector<int> parent(n, 0);
        for (int i = 0; i < parent.size(); i++)
        {
            parent[i] = i;
        }

        for (int i = 0; i < n; i++)
        {
            for (int j = i + 1; j < n; j++)
            {
                if (M[i][j])
                {
                    int group_a = find(parent, i);
                    int group_b = find(parent, j);
                    if (group_a != group_b)
                    {
                        groups--;
                        join(parent, i, j);
                    }
                }
            }
        }

        return groups;
    }
};