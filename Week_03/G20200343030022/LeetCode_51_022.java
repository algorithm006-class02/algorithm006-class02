import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author ：zhenghaoran.
 * @Date ：Created in 16:16 2020/2/29
 * @Description：
 */
public class LeetCode_51_022 {
    public Set colSet = new HashSet();
    public Set pieSet = new HashSet();
    public Set naSet = new HashSet();

    List<List<String>> res = new ArrayList();

    public List<List<String>> solveNQueens(int n) {

        int[][] board=new int[n][n];
        if(n == 0){
            return res;
        }
        nQueen(n, 0, board);
        return res;
    }
    private void nQueen(int n, int row, int[][] board){
        if (row==n){
            res.add(track(board,n));
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isVaild(col,row)){
                colSet.add(col);
                pieSet.add(col+row);
                naSet.add(col-row);
                board[row][col]=1;
                //填写下一行
                nQueen(n,row+1,board);
                board[row][col]=0;

                colSet.remove(col);
                pieSet.remove(col+row);
                naSet.remove(col-row);
            }
        }

    }
    private boolean isVaild(int col,int row){
        if(colSet.contains(col) || pieSet.contains(col + row)  || naSet.contains(col -row))
            return false;
        return true;
    }

    private List<String> track(int[][] board, int n) {
        List<String> list=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder temp=new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (board[i][j]==0)temp.append('.');
                else temp.append('Q');
            }
            list.add(temp.toString());
        }
        return list;
    }

    public static void main(String[] args) {
        LeetCode_51_022 l = new LeetCode_51_022();
        System.out.println(l.solveNQueens(4));
    }
}
