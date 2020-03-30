import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_51_422 {

    List<List<String>> res = new ArrayList<List<String>>();

    public List<List<String>> solveNQueens(int n) {
        if (n < 1) {
            return res;
        }
        List<Integer> list = new ArrayList<Integer>();

        help(0, n, list);
        return res;
    }

    private void help(int row, int n, List<Integer> list) {
        if (row == n) {
            List<String> strList = new ArrayList<String>();
            for (Integer num : list) {
                char[] t = new char[n];
                Arrays.fill(t, '.');
                t[num] = 'Q';
                strList.add(new String(t));
            }
            res.add(strList);
        }
    }
}
