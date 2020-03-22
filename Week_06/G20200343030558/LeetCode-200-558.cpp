#include <vector>

using namespace std;

//使用并查集的方式
class UnionFind{
    private:
        vector<int> parents;
        int count;
    public:
        UnionFind(vector<vector<char>>& grid){
            count = 0;
            int m = grid.size();
            int n = grid[0].size();
            for(int i = 0; i < m; ++i){
                for(int j = 0; j < n; ++j){
                    if(grid[i][j] == '1'){
                        parents.push_back(i * n + j);
                        ++count;
                    }
                    else{
                        parents.push_back(-1);
                    }
                }
            }
        }

        int find(int i){
            if(parents[i] != i) parents[i] = find(parents[i]);
            return parents[i];
        }

        void Union(int x, int y){
            int rootx = find(x);
            int rooty = find(y);
            if(rootx != rooty){
                parents[rootx] = rooty;
                --count;
            }
        }
        int getCount(){
            return count;
        }
};

class Solution {
public:
    int numIslands(vector<vector<char>>& grid) {
        if(grid.size() == 0){
                return 0;
            }
        int row = grid.size(), col = grid[0].size();
        UnionFind uf(grid);
        for(int i = 0; i < row; ++i){
            for(int j = 0; j < col; ++j){
                if(grid[i][j] == '1'){
                    grid[i][j] = '0';
                    int old = i * col + j;
                    if(i - 1 >= 0 && grid[i - 1][j] == '1'){
                        uf.Union(old, (i - 1) * col + j);
                    }
                    if(i + 1 < row && grid[i + 1][j] == '1'){
                        uf.Union(old, (i + 1) * col + j);
                    }
                    if(j - 1 >= 0 && grid[i][j - 1] == '1'){
                        uf.Union(old, i * col + j - 1);
                    }
                    if(j + 1 < col && grid[i][j + 1] == '1'){
                        uf.Union(old, i * col + j + 1);
                    }
                }
            }
        }
        return uf.getCount();
    }

       
};