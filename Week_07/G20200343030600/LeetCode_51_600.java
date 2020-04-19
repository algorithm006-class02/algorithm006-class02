import java.util.ArrayList;
import java.util.List;

public class LeetCode_51_600 {
    private int size;
    private int count;
    private int[] ans;
    private List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        count = 0;
        size = (1 << n) - 1;
        ans = new int[n];
        solve(0, 0, 0);
        return res;
    }

    private int lg(int x) {
        int sum = 0;
        while(x > 0) {
            x = x >> 1;
            sum++;
        }
        return sum;
    }

    private int level(int x) {
        int sum = 0;
        while(x != 0) {
            x &= x - 1;
            sum++;
        }
        return sum;
    }

    private List<String> transform(int[] arr) {
        List<String> list = new ArrayList<>();
        int length = arr.length;
        for(int i : ans) {
            StringBuilder sb = new StringBuilder("");
            for(int j = 1; j < i; j++) sb.append(".");
            sb.append("Q");
            for(int j = 0; j < length - i; j++) sb.append(".");
            list.add(sb.toString());
        }
        return list;
    }

    private void solve(int row, int ld, int rd) {
        if(row == size) {
            count++;
            res.add(transform(ans));
            return;
        }
        int index = level(row);
        int pos = size & (~(row | ld | rd)); //得到当前行可放皇后的格子
        while(pos != 0) { //当前行还有可用的位置
            int p = pos & (~pos + 1); //(负数是用补码表示的，即~pos+1 = -pos)每次从当前行可用的格子中取出最右边位为1的格子放置皇后
            ans[index] = lg(p);
            pos &= pos - 1; //pos -= p; 当前行最右边格子已放皇后，将其置成 0，代表这个格子已遍历过
            solve(row | p, (ld | p) << 1, (rd | p) >> 1);
        }
    }
}
