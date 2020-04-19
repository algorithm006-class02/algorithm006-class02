class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        // 桶排序
        int[] temp = new int[1001];
        for (int i : arr1) {
            temp[i]++;
        }
        int index=0;
        for (int j : arr2) {
            while (temp[j] >0) {
                arr1[index] = j;
                temp[j]--;
                index++;
            }
        }
        for (int i=0; i<temp.length; i++) {
            while (temp[i] >0) {
                arr1[index] = i;
                temp[i]--;
                index++;
            }
        }
        return arr1;
    }
}