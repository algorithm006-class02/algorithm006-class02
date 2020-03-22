import java.util.Arrays;

/**
 * @author : Hyuk
 * @description : LeetCode_62_536
 * @date : 2020/3/14 4:21 下午
 */
public class LeetCode_62_536 {

    public int uniquePaths(int m, int n) {
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; ++i) { arr[i][0] = 1; }
        for (int i = 0; i < n; ++i) { arr[0][i] = 1; }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; ++j) {
                arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
            }
        }
        return arr[m - 1][n - 1];
    }


    public int uniquePaths1(int m, int n) {
        int[] arr = new int[n];
        Arrays.fill(arr, 1);
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                arr[j] += arr[j - 1];
            }
        }
        return arr[n - 1];
    }
}
