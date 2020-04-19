class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] bucket = new int[1001];
        for (int i : arr1) {
            bucket[i]++;
        }
        int index = 0;
        int[] result = new int[arr1.length];
        for (int j : arr2) {
            for (int k = 0; k < bucket[j]; k++) {
                result[index++] = j;
            }
            bucket[j] = 0;
        }
        for (int n = 0; n < bucket.length; n++) {
            for (int k = 0; k < bucket[n]; k++) {
                result[index++] = n;
            }
        }
        return result;
    }
}
