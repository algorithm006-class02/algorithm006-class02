import java.util.Arrays;
import java.util.Comparator;

public class LeetCode_56_600 {
    public int[][] merge(int[][] arr) {
        if(arr == null || arr.length == 0) return arr;
        Arrays.parallelSort(arr, Comparator.comparingInt(x -> x[0]));
        int pos = 0;
        for(int i = 1; i < arr.length; i++) {
            if(arr[pos][1] >= arr[i][0]) {
                arr[pos][1] = Math.max(arr[pos][1], arr[i][1]);
            } else {
                arr[++pos] = arr[i];
            }
        }
        int[][] ans = new int[pos + 1][];
        System.arraycopy(arr, 0, ans, 0, pos + 1);
        return ans;
    }
}
