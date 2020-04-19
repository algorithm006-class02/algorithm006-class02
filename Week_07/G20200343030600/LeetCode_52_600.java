public class LeetCode_52_600 {
    private int size;
    private int count;

    public int totalNQueens(int n) {
        count = 0;
        size = (1 << n) - 1;
        solve(0, 0, 0);
        return count;
    }

    private void solve(int row, int ld, int rd) {
        if(row == size) {
            count++;
            return;
        }
        int pos = size & (~(row | ld | rd)); //得到当前行可放皇后的格子
        while(pos != 0) { //当前行还有可用的位置
            int p = pos & (~pos + 1); //(负数是用补码表示的，即~pos+1 = -pos)每次从当前行可用的格子中取出最右边位为1的格子放置皇后
            pos &= pos - 1; //pos -= p; 当前行最右边格子已放皇后，将其置成 0，代表这个格子已遍历过
            solve(row | p, (ld | p) << 1, (rd | p) >> 1);
        }
    }
}
