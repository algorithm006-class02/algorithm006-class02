import java.util.ArrayList;
import java.util.List;

/**
 * @author : Hyuk
 * @description : LeetCode_120_536
 * @date : 2020/3/14 7:26 下午
 */
public class LeetCode_120_536 {

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0 || triangle.get(0).size() == 0) { return 0; }
        int m = triangle.size();
        int[][] arr = new int[m][m];
        for (int i = 0; i < m; ++i) {
            arr[m - 1][i] = triangle.get(m - 1).get(i);
        }
        for (int i = m - 2; i >= 0; --i) {
            for (int j = 0, len = triangle.get(i).size(); j < len; ++j) {
                arr[i][j] = Math.min(arr[i + 1][j], arr[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }
        return arr[0][0];
    }
}
