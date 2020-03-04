import java.util.ArrayList;
import java.util.List;

public class LeetCode_51_378 {
    List<List<String>> output = new ArrayList<>();

    //用来记录每一行哪个列被占用
    int[] rows;
    int[] main;
    int[] second;
    int[] queue;
    int n;

    public List<List<String>> solveNQueens(int n) {
        rows = new int[n];
        main = new int[2 * n - 1];
        second = new int[2 * n - 1];
        queue = new int[n];
        this.n = n;
        backTrack(0);
        return output;
    }

    private void backTrack(int row) {
        if (row >= n)
            return;

        for(int col = 0;col<n;col++){
            if(isNotUnderAttack(row,col)){
                placeQueue(row,col);
                if(row == n-1)
                    addSolution();
                backTrack(row+1);

                removeQueue(row,col);
            }

        }

    }

    private void removeQueue(int row, int col) {
        rows[col] = 0;
        main[row-col+n-1]=0;
        second[row+col] = 0;
        queue[row] = 0;
    }

    private void addSolution() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i< n;i++){
            int col = queue[i];
            StringBuilder sb = new StringBuilder();
            for (int j= 0;j<col;j++) sb.append(".");
            sb.append("Q");
            for (int j = 0;j<n-1-col;j++) sb.append(".");
            list.add(sb.toString());
        }
        output.add(list);
    }

    private void placeQueue(int row, int col) {
        rows[col] = 1;
        main[row-col+n-1]=1;
        second[row+col] = 1;
        queue[row] = col;

    }

    private boolean isNotUnderAttack(int row, int col) {
        int ret = rows[col] + main[row-col+n-1] +second[row+col];
        return ret==0;
    }
}
