class Solution {
public:
    int father[300];

    int findFather(int x) {
        while (x!=father[x]) {
            x = father[x];
        }
        return x;
    }

    void Union(int a, int b) {
        int fa = findFather(a);
        int fb = findFather(b);
        if (fa!=fb) {
            father[fa] = fb;
        }
    }

    void init() {
        for (int i=0; i<300; i++) {
            father[i] = i;
        }
    }

    int findCircleNum(vector<vector<int>>& M) {
        init();

        for (int i=0; i<M.size(); i++) {
            for (int j=i+1; j<M.size(); j++) {
                if (M[i][j]==1) {
                    Union(i, j);
                }
            }
        }

        int res = 0;
        for (int i=0; i<M.size(); i++) {
            if (i==father[i]) {
                res++;
            }
        }
        return res;
    }
};