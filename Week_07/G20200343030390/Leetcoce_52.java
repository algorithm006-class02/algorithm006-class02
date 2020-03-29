/**
 *
 *  52.N皇后2
 *  n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *  给定一个整数 n，返回 n 皇后不同的解决方案的数量。
 */

class Solution {
    private int size;
    private int count;

    public int totalNQueens(int n) {
        count=0;
        size=(1<<n)-1;
        solve(0,0,0);
        return count;
    }
    private void solve(int row, int ld, int rd) {
        if(row == size) {
            count++;
            return;
        }
        int pos = size&(~(row|ld|rd));
        while(pos!=0){
            int p = pos&(-pos);
            pos-=p;
            solve(row|p,(ld|p)<<1,(rd|p)>>1);
        }
    }

}