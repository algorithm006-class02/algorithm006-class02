//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void solve(char[][] board) {
        if(board==null || board.length<=2)
            return;
        int m=board.length;
        int n=board[0].length;
        char flag='Y';
        for(int i=0;i<n;i++){
            helper(board,0,i,m,n,flag);
            helper(board,m-1,i,m,n,flag);
        }
        for(int i=0;i<m;i++){
            helper(board,i,0,m,n,flag);
            helper(board,i,n-1,m,n,flag);
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='Y')
                    board[i][j]='O';
                else
                    board[i][j]='X';
            }
        }
    }
    public void helper(char[][] board,int x,int y,int m,int n,char flag){
        if(x<0 || y<0 ||x>=m || y>=n)
            return;
        if(board[x][y]!='O')
            return;
        board[x][y]=flag;
        int[] dx={0,0,1,-1};
        int[] dy={1,-1,0,0};
        for(int i=0;i<4;i++){
            int temx=x+dx[i];
            int temy=y+dy[i];
            helper(board,temx,temy,m,n,flag);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
