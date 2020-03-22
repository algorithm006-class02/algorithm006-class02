package G20200343030372;

/**
 * @author Chen.C
 * @date 2020/3/13
 */
public class Max_sum_of_rectangle_no_larger_than_k_363 {

    public int maxSumSubmatrix(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0) {
            return -1;
        }
        int m = matrix.length, n = matrix[0].length;
        int[] sums = new int[m + 1];
        int ans = Integer.MIN_VALUE;
        int i, j, s;

        for (i = 0; i < n; i++) {
            int[] A = new int[m];
            for (j = i; j < n; j++) {
                int max = Integer.MIN_VALUE, sub = 0;
                for (s = 0; s < m; s++) {
                    A[s] += matrix[s][j];
                    sums[s + 1] = sums[s] + A[s];
                    sub = Math.max(sub + A[s], A[s]);
                    max = Math.max(max, sub);
                }
                if (max <= k) {
                    ans = Math.max(ans, max);
                } else {
                    ans = Math.max(ans, mergeSort(sums, 0, m, k));
                }
            }
        }
        return ans;
    }

    private int mergeSort(int[] sum, int start, int end, int k) {
        if (start >= end) {
            return Integer.MIN_VALUE;
        }
        int mid = start + (end - start) / 2;
        int ans = mergeSort(sum, start, mid, k);
        if (ans == k) {
            return ans;
        }
        ans = Math.max(ans, mergeSort(sum, mid + 1, end, k));
        if (ans == k) {
            return ans;
        }

        int[] temp = new int[end - start + 1];
        int i, j = mid + 1, t = 0;
        int p = mid + 1;
        for (i = start; i <= mid; i++) {
            while (p <= end && sum[p] - sum[i] <= k) {
                ans = Math.max(ans, sum[p] - sum[i]);
                p++;
            }
            while (j <= end && sum[j] < sum[i]) temp[t++] = sum[j++];
            temp[t++] = sum[i];
        }
        System.arraycopy(temp, 0, sum, start, t);
        return ans;
    }
}
