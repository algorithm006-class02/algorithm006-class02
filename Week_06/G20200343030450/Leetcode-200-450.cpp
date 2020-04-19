class Solution {
public:
    int numIslands(vector<vector<char>>& v) {
        int count = 0;
        char from = '1';
        char to = 'x';
        for(auto i=0;i<v.size();i++){
            for(auto j=0;j<v[i].size();j++){
                if(v[i][j]==from){
                    ++count;
                    dfs(v,i,j,from,to);
                }
            }
        }
        return count;
    }
    
    bool issafe(vector<vector<char>>&v,int r,int c){
        int row = v.size();
        int col = v[0].size();
        if((r>=0 and r<row) and (c>=0 and c<col)){
            return true;
        }
        return false;
    }
    
    void dfs(vector<vector<char>>&v,int row,int col,char from,char to){
        if(issafe(v,row,col) and v[row][col]==from){
            v[row][col] = to;
            dfs(v,row+1,col,from,to);
            dfs(v,row-1,col,from,to);
            dfs(v,row,col+1,from,to);
            dfs(v,row,col-1,from,to);
        }
    }
};