struct DSU
{
    std::vector<int> data;
    
    void init(int n) { data.assign(n, -1); }
    
    bool unionSet(int x, int y)
    {
        x = root(x);
        y = root(y);
        if (x != y)
        {
            if (data[y] < data[x])
            {
                std::swap(x, y);
            }
            data[x] += data[y];
            data[y] = x;
        }
        return x != y;
    }

    bool same(int x, int y) { return root(x) == root(y); }

    int root(int x) { return data[x] < 0 ? x : data[x] = root(data[x]); }

    int size(int x) { return -data[root(x)]; }
};
class Solution {
public:
    int findCircleNum(vector<vector<int>>& M) 
    {
        int ans = M.size();
        DSU dsu;
        dsu.init(M.size());
        for (size_t i = 0; i < M.size(); i++)
        {
            for (size_t j = i + 1; j < M.size(); j++)
            {
                if (M[i][j] == 0) continue;
                ans -= dsu.unionSet(i, j);
            }
        }
        return ans;
    }
};
