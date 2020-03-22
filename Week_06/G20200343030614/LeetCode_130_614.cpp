const int maxn=0x7fffff;
int father[maxn];
class Solution {
public:
    int find(int x) {
        int j=x;
        while (father[x]!=x) {
            x=father[x];
        }
        while (father[j]!=x) {
            father[j]=x;
        }
        return x;
    }
    void uni(int i,int j) {
        int f1=find(i);
        int f2=find(j);
        father[f1]=f2;
    }
    void solve(vector<vector<char>>& board) {
        if (board.size()==0||board[0].size()==0) return;
        int temp=board.size()*board[0].size();
        for (int i=0;i<=temp;i++) {
            father[i]=i;
        }
        for (int i=0;i<board.size();i++) {
            for (int j=0;j<board[0].size();j++) {
                if (board[i][j]=='X') continue;
                int k=i*board[0].size()+j;
                if (i==0||j==0||i==board.size()-1||j==board[0].size()-1) {
                    uni(k,temp);
                    continue;
                }
                else if (board[i][j]=='O') {
                        if (board[i][j-1]=='O') uni(k,k-1);
                        if (board[i][j+1]=='O') uni(k,k+1);
                        if (board[i-1][j]=='O') uni(k,k-board[0].size());
                        if (board[i+1][j]=='O') uni(k,k+board[0].size());
                }
            }
        }
        int temp_father=find(temp);
        for (int i=0;i<board.size();i++) {
            for (int j=0;j<board[0].size();j++) {
                int k=i*board[0].size()+j;
                if (board[i][j]=='X') continue;
                if (find(k)!=temp_father) board[i][j]='X';
            }
        }
    }
};